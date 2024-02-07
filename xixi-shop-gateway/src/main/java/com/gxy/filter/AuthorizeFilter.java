package com.gxy.filter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.gxy.entity.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Authorize Filter
 * @author Jianghu
 * @date 2022-04-15 14:29:49
 */
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {

    // 请求白名单
    public static List<String> PASS_URLS = new ArrayList<String>();
    static {
        // 无需验证的地址
        PASS_URLS.add("/api/manage/login");
        PASS_URLS.add("/api/manage/findPassword/.*?");

//        PASS_URLS.add("/api/account/register");
//        PASS_URLS.add("/static/.*?");
//        PASS_URLS.add("/api/common/dictionary/.*?");
//        PASS_URLS.add("/api/common/file/.*?");
//        PASS_URLS.add("/api/common/redis/.*?");
//        PASS_URLS.add("/api/common/sendMail");
//        PASS_URLS.add("/api/account/findPassword/.*?");
//        PASS_URLS.add("/api/site/.*?");
//        PASS_URLS.add("/api/market/order/selectByUser");
    };

    /**
     * -过滤器优先级，数值越小优先级越高
     */
    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // 获取 Request、Response
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        // 获取 URI，并放行无需权限的接口
        String uri = request.getURI().getPath();
        String passUrl = PASS_URLS.stream()
                .filter(item -> uri.matches(item))
                .findFirst()
                .orElse("");
        if (StringUtils.isNotBlank(passUrl)) {
            return chain.filter(exchange);
        }

        // 从请求头中获取 token
        HttpHeaders headers = request.getHeaders();
        String token = headers.getFirst("Token");
        if (StringUtils.isBlank(token)) {
            // 若 token 为空则返回 401
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        // 获取 token 中签发对象并验证令牌
        String id = JwtUtils.getAudience(token);
        DecodedJWT decodedJWT = JwtUtils.verifyToken(token, id);
        if (decodedJWT == null) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        return chain.filter(exchange);
    }

}
