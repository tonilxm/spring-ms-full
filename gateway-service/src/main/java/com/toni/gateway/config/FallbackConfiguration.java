package com.toni.gateway.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
        return ServerResponse.ok().body(Mono.just(new DefaultDepartment(1L, "Default department")), DefaultDepartment.class);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class DefaultDepartment {
    private Long id;
    private String name;
}
