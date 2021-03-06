package edu.illinois.ncsa.incore.service.semantics;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;

public class CorsFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        MultivaluedMap<String, Object> headers = responseContext.getHeaders();

        // if header origin is in the allowed origin list; add it to access-control-allow-origin header
        String allowedOrigins = System.getenv("SERVICES_ALLOW_ORIGIN");
        String requestHeadersOrigin = requestContext.getHeaderString("Origin");
        if (requestHeadersOrigin != null && allowedOrigins.contains(requestHeadersOrigin)){
            headers.add("Access-Control-Allow-Origin", requestHeadersOrigin);
        }
        headers.add("Access-Control-Allow-Methods", "GET");
        headers.add("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, " +
            "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, auth-user, " +
            "auth-token, x-auth-userinfo");
    }
}
