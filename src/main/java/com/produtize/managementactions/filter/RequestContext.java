package com.produtize.managementactions.filter;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.UUID;

@Data
@Component
@RequestScope
public class RequestContext {

    private UUID id = UUID.randomUUID();
    private String username;
    private String token;
}
