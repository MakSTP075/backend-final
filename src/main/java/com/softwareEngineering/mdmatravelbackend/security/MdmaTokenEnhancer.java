package com.softwareEngineering.mdmatravelbackend.security;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class MdmaTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        MdmaUserDetails userDetails = (MdmaUserDetails) oAuth2Authentication.getPrincipal();

        Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("user_id", userDetails.getUserId());
        additionalInfo.put("is_admin", userDetails.getIsAdmin());

        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);

        return oAuth2AccessToken;
    }
}
