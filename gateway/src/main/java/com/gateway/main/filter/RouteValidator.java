package com.gateway.main.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {
    public static final List<String> openApiEndPoints = List.of(
            "/auth",
            "/eureka",
            "/api/v1/user/register"
    );

    public Predicate<ServerHttpRequest> isSecured = serverHttpRequest -> openApiEndPoints
                    .stream()
                    .noneMatch(uri -> serverHttpRequest.getURI().getPath().contains(uri));
}
