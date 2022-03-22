package com.toni.gateway.config.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;


@Configuration("TLDepartment")
@ConfigurationProperties(prefix = "resilience4j.timelimiter.instances.department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimeLimiterDepartmentConfigurationProperties {
    private Duration timeoutDuration;
    private Boolean cancelRunningFuture;
}
