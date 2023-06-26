package com.gateway.main.filter;

import com.gateway.main.security.JWTService;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
public class JWTAuthenticationFilter extends AbstractGatewayFilterFactory<JWTAuthenticationFilter.Config> {



    private final RouteValidator routeValidator;
    private final JWTService jwtService;


    public JWTAuthenticationFilter(RouteValidator routeValidator, JWTService jwtService) {
        super(Config.class);
        this.routeValidator = routeValidator;
        this.jwtService = jwtService;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            if (routeValidator.isSecured.test(exchange.getRequest())) {
                if (!exchange.getRequest().getHeaders().containsKey(AUTHORIZATION)) {
                    throw new RuntimeException("missing authHeader");
                }
                String authHeader = exchange.getRequest().getHeaders().get(AUTHORIZATION).get(0);
                if (authHeader != null || authHeader.startsWith("Bearer ")) {

                    authHeader = authHeader.substring(7);

                    try {
                        jwtService.isTokenValid(authHeader);

                    } catch (Exception e) {
                        throw new RuntimeException("un authorized access to application");
                    }

                }
            }
            return chain.filter(exchange);
        });
    }

    @Override
    public Class<Config> getConfigClass() {
        return Config.class;
    }

    @Override
    public Config newConfig() {
        return new Config();
    }

    public static class Config {
    }
}
