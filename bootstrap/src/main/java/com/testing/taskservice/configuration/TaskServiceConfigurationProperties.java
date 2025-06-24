package com.testing.taskservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "task-service")
public class TaskServiceConfigurationProperties {

}
