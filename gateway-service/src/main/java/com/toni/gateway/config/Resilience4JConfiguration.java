package com.toni.gateway.config;

import com.toni.gateway.config.properties.CircuitBreakerDefaultConfigurationProperties;
import com.toni.gateway.config.properties.CircuitBreakerDepartmentConfigurationProperties;
import com.toni.gateway.config.properties.TimeLimiterDefaultConfigurationProperties;
import com.toni.gateway.config.properties.TimeLimiterDepartmentConfigurationProperties;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class Resilience4JConfiguration {
    private final CircuitBreakerDefaultConfigurationProperties cbDefaultProps;
    private final CircuitBreakerDepartmentConfigurationProperties cbDepartmentProps;
    private final TimeLimiterDefaultConfigurationProperties tlDefaultProps;
    private final TimeLimiterDepartmentConfigurationProperties tlDepartmentProps;

    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {

        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .slidingWindowSize(cbDefaultProps.getSlidingWindowSize())
                .permittedNumberOfCallsInHalfOpenState(cbDefaultProps.getPermittedNumberOfCallsInHalfOpenState())
                .slidingWindowType(cbDefaultProps.getSlidingWindowType())
                .minimumNumberOfCalls(cbDefaultProps.getMinimumNumberOfCalls())
                .waitDurationInOpenState(cbDefaultProps.getWaitDurationInOpenState())
                .failureRateThreshold(cbDefaultProps.getFailureRateThreshold())
                .slowCallDurationThreshold(cbDefaultProps.getSlowCallDurationThreshold())
                .slowCallRateThreshold(cbDefaultProps.getSlowCallRateThreshold())
                .build();
        TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom()
                .timeoutDuration(tlDefaultProps.getTimeoutDuration())
                .cancelRunningFuture(tlDefaultProps.getCancelRunningFuture())
                .build();

        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
                .timeLimiterConfig(timeLimiterConfig)
                .circuitBreakerConfig(circuitBreakerConfig)
                .build());
    }

    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> departmentCustomizer() {

        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .slidingWindowSize(cbDepartmentProps.getSlidingWindowSize())
                .permittedNumberOfCallsInHalfOpenState(cbDepartmentProps.getPermittedNumberOfCallsInHalfOpenState())
                .slidingWindowType(cbDepartmentProps.getSlidingWindowType())
                .minimumNumberOfCalls(cbDepartmentProps.getMinimumNumberOfCalls())
                .waitDurationInOpenState(cbDepartmentProps.getWaitDurationInOpenState())
                .failureRateThreshold(cbDepartmentProps.getFailureRateThreshold())
                .slowCallDurationThreshold(cbDepartmentProps.getSlowCallDurationThreshold())
                .slowCallRateThreshold(cbDepartmentProps.getSlowCallRateThreshold())
                .build();
        TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom()
                .timeoutDuration(tlDepartmentProps.getTimeoutDuration())
                .cancelRunningFuture(tlDepartmentProps.getCancelRunningFuture())
                .build();

        return factory -> factory.configure(builder -> builder
                .circuitBreakerConfig(circuitBreakerConfig)
                .timeLimiterConfig(timeLimiterConfig), "departmentCircuitBreaker");
    }
}
