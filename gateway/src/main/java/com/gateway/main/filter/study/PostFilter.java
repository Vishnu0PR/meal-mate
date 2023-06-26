package com.gateway.main.filter.study;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class PostFilter extends AbstractGatewayFilterFactory<PostFilter.Config> {

    public PostFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (((exchange, chain) -> chain.filter(exchange).then(Mono.fromRunnable(() -> {
            var response = exchange.getResponse();
            var headers = response.getHeaders();
            headers.forEach((key, value) -> System.out.println("Key :"+key+" & "+"Value : "+value));
            System.out.println(response.getRawStatusCode());
        }))));
    }

    @Getter
    @Setter
    public static class Config {
        private String name;
    }
}
