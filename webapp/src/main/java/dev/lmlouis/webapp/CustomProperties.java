package dev.lmlouis.webapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;


@Configuration
@ConfigurationProperties(prefix="dev.lmlouis.webapp")
@Data
public class CustomProperties {
    private String apiUrl;
}
