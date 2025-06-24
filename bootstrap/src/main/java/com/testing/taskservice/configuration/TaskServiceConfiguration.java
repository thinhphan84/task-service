package com.testing.taskservice.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(TaskServiceConfigurationProperties.class)
public class TaskServiceConfiguration {

    /**
     * Adds a use-case-specific {@link SomethingProperties} object to the application context. The properties
     * are read from the Spring-Boot-specific {@link TaskServiceConfigurationProperties} object.
     */
    // @Bean
    //  public Something somethingProperties(TaskServiceConfigurationProperties taskServiceConfigurationProperties){
    //    return new somethingProperties();
    //  }

}
