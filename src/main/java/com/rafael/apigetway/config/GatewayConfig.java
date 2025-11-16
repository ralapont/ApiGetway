package com.rafael.apigetway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("productos-route", r -> r.path("/api/productos/**")
                    .uri("lb://PRODUCTOSERVICIO"))
                .route("categorias-route", r -> r.path("/api/categorias/**")
                    .uri("lb://PRODUCTOSERVICIO"))
                .route("clientes-route", r -> r.path("/api/clientes/**")
                    .uri("lb://CLIENTESERVICIO"))
                .route("auth-route", r -> r.path("/api/auth/**")
                        .uri("lb://AUTHSERVICIO"))
                .route("test-route", r -> r.path("/api/test/**")
                        .uri("lb://AUTHSERVICIO"))
                .route("pedido-route", r -> r.path("/api/pedidos/**")
                        .uri("lb://PEDIDOSERVICIO"))
                .build();
    }
}
