package com.toni.gateway.config.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration("TLDefault")
@ConfigurationProperties(prefix = "resilience4j.timelimiter.configs.default")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimeLimiterDefaultConfigurationProperties {
    private Duration timeoutDuration;
    private Boolean cancelRunningFuture;
}
