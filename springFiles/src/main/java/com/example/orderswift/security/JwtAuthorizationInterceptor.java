package com.example.orderswift.security;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import io.jsonwebtoken.Claims;
import org.springframework.http.HttpStatus;

import org.springframework.web.method.HandlerMethod;

import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


@Component
public class JwtAuthorizationInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();

            JwtAuthorizationRequired annotation = method.getAnnotation(JwtAuthorizationRequired.class);

            if (annotation == null) {
                return true;
            }

            Claims claims = (Claims) request.getAttribute("claims");
            String role = claims.get("role", String.class);
            String requiredRole = annotation.value();

            if (!role.equals(requiredRole)) {
                response.sendError(HttpStatus.FORBIDDEN.value(), "Insufficient privileges");
                return false;
            }
        }

        return true;
    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // No se utiliza en este ejemplo
    }


    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // No se utiliza en este ejemplo
    }


}

