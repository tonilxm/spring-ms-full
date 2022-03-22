package com.toni.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

@Configuration
public class FallbackConfiguration {
    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.
                route(RequestPredicates.GET("/department-fallback"),
                        this::handleGetFallback);
    }

    private Mono<ServerResponse> handleGetFallback(ServerRequest serverRequest) {
        return ServerResponse.ok().body(Mono.just("Sorry service not stable"), String.class);
    }
}
