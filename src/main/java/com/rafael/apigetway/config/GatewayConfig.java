package com.rafael.apigetway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("productos-route", r -> r.path("/api/productos/**")
                    .uri("lb://producto-service"))
                .route("categorias-route", r -> r.path("/api/categorias/**")
                    .uri("lb://producto-service"))
                .route("clientes-route", r -> r.path("/api/clientes/**")
                    .uri("lb://cliente-service"))
                .route("auth-route", r -> r.path("/api/auth/**")
                        .uri("lb://auth-service"))
                .route("test-route", r -> r.path("/api/test/**")
                        .uri("lb://auth-service"))
                .route("pedido-route", r -> r.path("/api/pedidos/**")
                        .uri("lb://pedido-service"))
                .build();
    }
}
