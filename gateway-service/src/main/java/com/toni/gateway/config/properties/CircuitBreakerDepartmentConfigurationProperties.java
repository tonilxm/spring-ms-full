package com.toni.gateway.config.properties;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration("CBDepartment")
@ConfigurationProperties(prefix = "resilience4j.circuitbreaker.instances.department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CircuitBreakerDepartmentConfigurationProperties {
    private Integer slidingWindowSize;
    private Integer permittedNumberOfCallsInHalfOpenState;
    private CircuitBreakerConfig.SlidingWindowType slidingWindowType;
    private Integer minimumNumberOfCalls;
    private Duration waitDurationInOpenState;
    private Float failureRateThreshold;
    private Float slowCallRateThreshold;
    private Duration slowCallDurationThreshold;
}
