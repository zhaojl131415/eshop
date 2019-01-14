package com.eshop.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class TokenFilter extends ZuulFilter {

    private final RouteLocator routeLocator;

    public TokenFilter(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }
    // 过滤器的具体逻辑
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));

        Object userId = request.getParameter("userId");
        if(userId == null) {
            log.warn("userId is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("userId is empty");
            }catch (Exception e){}
            return null;
        }
        log.info("ok");
        return null;
    }

    // 根据逻辑判断是否要过滤
    @Override
    public boolean shouldFilter() {
//        String requestUri = RequestContext.getCurrentContext().getRequest().getRequestURI();
//        if (requestUri.startsWith("/zuul")){
//            return false;
//        } else {
//            // If the request Uri does not start with the path of the authorized endpoints, we block the request
//            for (Route route : routeLocator.getRoutes()) {
//                String serviceUrl = route.getFullPath();
//                String serviceName = route.getId();
//
//                // If this route correspond to the current request URI
//                // We do a substring to remove the "**" at the end of the route URL
//                if (requestUri.startsWith(serviceUrl.substring(0, serviceUrl.length() - 2))) {
//                    if (isAuthorizedRequest(serviceUrl, serviceName, requestUri)){
//                        return false;
//                    } else if (isAuthorizedToken(RequestContext.getCurrentContext().getRequest())){
//                        return false;
//                    }
//                }
//            }
//        }
        return true;
    }

    // 路由之前：pre、路由之时：routing、路由之后：post、路由之后：error
    @Override
    public String filterType() {
        return "pre";
    }

    // 过滤的顺序
    @Override
    public int filterOrder() {
        return 0;
    }
}