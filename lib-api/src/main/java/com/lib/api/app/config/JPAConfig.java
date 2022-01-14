package com.lib.api.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Configuration
public class JPAConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.of(UUID.randomUUID().toString());
    }

    public static String createId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String localDateTimeToPlainText(LocalDateTime localDateTime) {

        return localDateTime.toString()
                .replace("-", "")
                .replace(":", "")
                .replace(".", "");
    }

}
