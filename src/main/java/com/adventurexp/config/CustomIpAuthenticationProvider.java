package com.adventurexp.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CustomIpAuthenticationProvider implements AuthenticationProvider {

    Set<String> whitelist = new HashSet<String>();

    public CustomIpAuthenticationProvider() {

    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
        String userIp = details.getRemoteAddress();
        System.out.println(userIp);
        if (! whitelist.contains(userIp)){
            throw new BadCredentialsException("Invalid IP Address");
        }
        return authentication;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
