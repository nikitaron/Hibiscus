package com.poit.hibiscus.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "bank")
public class ClientProperties {
    public static String URL = "http://api.currencylayer.com";
    public static String ENDPOINT = "/live";
    public static String ACCESS_KEY = "3cb2148e7f1e0c00f2e85dc26d283925";
}
