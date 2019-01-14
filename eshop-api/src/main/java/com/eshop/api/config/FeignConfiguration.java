package com.eshop.api.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.eshop.api.fallback")
@EnableFeignClients(basePackages = "com.eshop.api.clients")
public class FeignConfiguration {
//
//    @Bean
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//        return new BasicAuthRequestInterceptor("admin", "admin");
//    }

//    @Bean
//    public RequestInterceptor headerInterceptor() {
//        return requestTemplate -> {
//            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
//                    .getRequestAttributes();
//            if (attributes != null) {
//                HttpServletRequest request = attributes.getRequest();
//                Enumeration<String> headerNames = request.getHeaderNames();
//                if (headerNames != null) {
//                    while (headerNames.hasMoreElements()) {
//                        String name = headerNames.nextElement();
//                        if ("X-USER".equals(name) || "X-AUTH".equals(name)) {
//                            String values = request.getHeader(name);
//                            requestTemplate.header(name, values);
//                        }
//                    }
//                }
//            }
//        };
//    }
}
