package com.kiezik.ComputerService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Autowired
    private MessageSource messageSource;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/employees").setViewName("employees");
        registry.addViewController("/employees/add").setViewName("add-employee");
        registry.addViewController("/warehouse").setViewName("warehouse");
        registry.addViewController("/customers").setViewName("customers");
        registry.addViewController("/customers/add").setViewName("add-customer");
        registry.addViewController("/devices").setViewName("devices");
        registry.addViewController("/devices/add").setViewName("add-device");
        registry.addViewController("/devices/find").setViewName("find-device");
        registry.addViewController("/devices/edit").setViewName("edit-device");
        registry.addViewController("/tickets").setViewName("tickets");
        registry.addViewController("/tickets/add").setViewName("add-ticket");
        registry.addViewController("/ticket/{ticketId}").setViewName("ticket");

        registry.addViewController("/my-tickets").setViewName("my-tickets");
    }

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        factory.setValidationMessageSource(messageSource);
        return factory;
    }

    @Bean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }
}
