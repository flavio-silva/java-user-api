<?php

namespace App\Console\Commands;

use Anik\Amqp\ConsumableMessage;
use App\Notifications\UserCreated;
use App\User;
use Illuminate\Console\Command;

class ConsumeRabbitMQMessages extends Command
{
    /**
     * The name and signature of the console command.
     *
     * @var string
     */
    protected $signature = 'rabbitmq:consume';

    /**
     * The console command description.
     *
     * @var string
     */
    protected $description = 'Consume RabbitMQ Messages';

    /**
     * Create a new command instance.
     *
     * @return void
     */
    public function __construct()
    {
        parent::__construct();
    }

    /**
     * Execute the console command.
     *
     * @return mixed
     */
    public function handle()
    {
        app('amqp')->consume(function (ConsumableMessage $message) {
            echo $message->getStream() . PHP_EOL;

            $admin = factory(User::class)->state('admin')->make();
            $admin->notify(new UserCreated('user test', 'user@test.com'));

            $message->getDeliveryInfo()->acknowledge();
        }, 'routing-key', [
            'queue' => [
                'name' => 'default',
            ]
        ]);
    }
}
