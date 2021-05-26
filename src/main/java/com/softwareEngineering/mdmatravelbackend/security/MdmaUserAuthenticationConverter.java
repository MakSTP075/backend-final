package com.softwareEngineering.mdmatravelbackend.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MdmaUserAuthenticationConverter extends DefaultUserAuthenticationConverter {
    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {
        Authentication authentication = super.extractAuthentication(map);
        List<GrantedAuthority> authorities = new ArrayList<>(authentication.getAuthorities());
        MdmaUserDetails userDetails = getMdmaUserDetails(map, authorities);
        return new UsernamePasswordAuthenticationToken(userDetails, "N/A", authorities);
    }

    private MdmaUserDetails getMdmaUserDetails(Map<String, ?> map, Collection<GrantedAuthority> authorities) {

        MdmaUserDetails.MdmaUserDetailsBuilder builder = MdmaUserDetails.builder()
                .userId(Long.valueOf(map.get("user_id").toString()))
                .username(map.get("user_name").toString())
                .isAdmin((Boolean) map.get("is_admin"))
                .authorities(authorities);

        return builder.build();
    }
}
