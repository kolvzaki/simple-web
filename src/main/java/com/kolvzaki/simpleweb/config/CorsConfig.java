package com.kolvzaki.simpleweb.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    private static final String[] ALLOWED_METHODS = new String[] { "GET", "POST", "PUT", "DELETE" };

    private static final long MAX_AGE = 60 * 60;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOriginPatterns("*")
                .allowedMethods(ALLOWED_METHODS)
                .allowedHeaders("*")
                .maxAge(MAX_AGE);
    }
}
