package com.produtize.managementactions.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class FilterHeader implements Filter {

    private static final String X_USERNAME = "x_username";
    private final RequestContext requestContext;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String username = httpRequest.getHeader(X_USERNAME);
        requestContext.setUsername(username);

        MDC.put("method", httpRequest.getMethod());
        MDC.put("user.name", username);
        MDC.put("request.id", requestContext.getId().toString());
        MDC.put("resource", httpRequest.getRequestURI());

        chain.doFilter(request, response);
    }
}
