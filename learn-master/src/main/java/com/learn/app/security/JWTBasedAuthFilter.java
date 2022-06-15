package com.learn.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JWTBasedAuthFilter extends OncePerRequestFilter {

    private static final String HEADER_NAME = "Authorization";

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTHandler jwtHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(HEADER_NAME);
        if (header == null) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuth(request);
        if(authentication!=null) {
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuth(HttpServletRequest request) {
        String token = request.getHeader(HEADER_NAME);
        if (token != null) {
            boolean isValid = jwtHandler.validateJwtToken(token);
            if(isValid) {
                String userName = jwtHandler.getUserNameFromJwtToken(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
                return new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
            }
        }
        return null;
    }
}
