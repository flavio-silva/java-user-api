# Steps to build all microservices

## General
1. docker-compose up -d

## PHP commands
2. docker exec -it consumer-php-app composer install
3. docker exec -it consumer-php-app php artisan rabbitmq:consume

In the future, this commands will be run automatically
