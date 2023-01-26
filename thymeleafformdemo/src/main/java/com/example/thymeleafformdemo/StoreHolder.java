package com.example.thymeleafformdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class StoreHolder {
    private static EphemeralPeristanceStore peristenceStore;

    @Bean
    protected EphemeralPeristanceStore getPersistenceStore() {
        return Objects.requireNonNullElseGet(peristenceStore, EphemeralPeristanceStore::new);
    }
}

