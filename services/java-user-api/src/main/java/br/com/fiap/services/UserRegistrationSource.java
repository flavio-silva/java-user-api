package br.com.fiap.services;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

@EnableBinding(Source.class)
public interface UserRegistrationSource
{
    @Output("userRegistrationChannel")
    MessageChannel userRegistration();
}
