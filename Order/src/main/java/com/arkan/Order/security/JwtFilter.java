package com.arkan.Order.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                   HttpServletResponse response,
                                   FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        // 🔥 DEBUG 1
        System.out.println("=== JWT FILTER ===");
        System.out.println("HEADER: " + header);

        if (header != null && header.startsWith("Bearer ")) {

            String token = header.substring(7);

            // 🔥 DEBUG 2
            System.out.println("TOKEN: " + token);

            try {
                String username = jwtUtil.extractUsername(token);

                // 🔥 DEBUG 3
                System.out.println("USERNAME: " + username);

                if (username != null &&
                        SecurityContextHolder.getContext().getAuthentication() == null) {

                    UsernamePasswordAuthenticationToken auth =
                            new UsernamePasswordAuthenticationToken(
                                    username,
                                    null,
                                    Collections.emptyList()
                            );

                    // 🔥 WAJIB: set ke context
                    SecurityContextHolder.getContext().setAuthentication(auth);

                    System.out.println("AUTH SET SUCCESS");
                } else {
                    System.out.println("USERNAME NULL / AUTH SUDAH ADA");
                }

            } catch (Exception e) {
                System.out.println("JWT ERROR: " + e.getMessage());
            }
        } else {
            System.out.println("HEADER TIDAK VALID / TIDAK ADA");
        }

        filterChain.doFilter(request, response);
    }
}