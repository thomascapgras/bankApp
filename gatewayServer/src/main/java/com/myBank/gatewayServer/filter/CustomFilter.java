package com.myBank.gatewayServer.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Component
public class CustomFilter implements GlobalFilter, Ordered {
    final Logger logger = LoggerFactory.getLogger(CustomFilter.class);


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {
        exchange.getRequest().mutate()
                .header("X-Custom-Header", "CustomValue")
                .build();
        logger.debug("filtering request ...");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
