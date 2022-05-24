package com.poit.hibiscus.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

@Component
@ConstructorBinding
@ConfigurationProperties(prefix = "bank.rate")
public class ClientProperties {
    public static String URL;
    public static String ENDPOINT;
    public static String ACCESS_KEY;
}
