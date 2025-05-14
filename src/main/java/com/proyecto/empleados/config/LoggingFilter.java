package com.proyecto.empleados.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;


/*
Esta clase intercepta todas las peticiones HTTP antes de llegar al Controller
y muestra el metodo,URI y todos los headers en los logs
*/
@Component
public class LoggingFilter {

    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            logger.info("Solicitud HTTP entrante: {} {}", httpRequest.getMethod(), httpRequest.getRequestURI());

            // Loguear headers
            Collections.list(httpRequest.getHeaderNames())
                    .forEach(headerName -> logger.info("Header: {} = {}", headerName, httpRequest.getHeader(headerName)));
        }

        chain.doFilter(request, response);
    }
}
