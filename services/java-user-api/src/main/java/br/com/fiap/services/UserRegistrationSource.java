package br.com.fiap.services;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface UserRegistrationSource
{
    @Output("userRegistrationChannel")
    MessageChannel userRegistration();
}
