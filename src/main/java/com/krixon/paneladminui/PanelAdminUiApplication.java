package com.krixon.paneladminui;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
@SpringBootApplication
@EnableEurekaClient
public class PanelAdminUiApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(PanelAdminUiApplication.class, args);
    }

    @Bean
    public LocaleResolver localeResolver() {

        SessionLocaleResolver resolver = new SessionLocaleResolver();

        resolver.setDefaultLocale(Locale.ENGLISH);

        return resolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {

        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();

        interceptor.setParamName("language");

        return interceptor;
    }

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
