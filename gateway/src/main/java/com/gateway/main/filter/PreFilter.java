package com.gateway.main.filter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class PreFilter extends AbstractGatewayFilterFactory<PreFilter.Config> {

    public PreFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(PreFilter.Config config) {
        return ((exchange, chain) -> {
            var requestWriter=exchange.getRequest().mutate()
                    .header("pre-filter-key","pre-filter-value")
                    .build();
            return chain.filter(exchange.mutate().request(requestWriter).build());
        });
    }


    @Getter
    @Setter
    public static class Config {
        private String name;
    }
}
