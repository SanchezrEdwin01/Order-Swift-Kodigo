/**
package com.example.orderswift.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.*;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtAutenticationFilter extends OncePerRequestFilter {

            private  final JwtService jwtService;
            private final UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(
            @org.springframework.lang.NonNull HttpServletRequest request,
            @org.springframework.lang.NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {

            final String authHeader= request.getHeader("Authorization");
            final String jwt;
            final String UserEmail;
            if (authHeader == null || !authHeader.startsWith("Bearer ")){
                filterChain.doFilter(request,response);
                return;
            }
            jwt = authHeader.substring(7);
            UserEmail= jwtService.extractUsername(jwt);
            if(UserEmail != null && SecurityContextHolder.getContext().getAuthentication()==null){
                UserDetails userDetails= this.userDetailsService.loadUserByUsername(UserEmail);
                if(jwtService.isTokenValid(jwt,userDetails)){
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()

                    );

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
            filterChain.doFilter(request,response);
    }
}
**/