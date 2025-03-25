package com.example.sample1app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ValidatorConfig {

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("ValidationMessages"); // ValidationMessages.properties を指定
        messageSource.setDefaultEncoding("UTF-8"); // UTF-8 を明示的に指定
        bean.setValidationMessageSource(messageSource);
        return bean;
    }
}
