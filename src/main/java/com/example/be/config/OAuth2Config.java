package com.example.be.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class OAuth2Config {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        List<ClientRegistration> registrations = new ArrayList<>();

        registrations.add(
                ClientRegistration.withRegistrationId("google")
                        .clientId("709881037816-cc8fe8jdnpdi7hjkri0ojj9qnk4t62fg.apps.googleusercontent.com")
                        .clientSecret("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")
                        .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                        .redirectUriTemplate("{baseUrl}/login/oauth2/code/{registrationId}")
                        .scope("openid", "profile", "email")
                        .authorizationUri("https://accounts.google.com/o/oauth2/v2/auth")
                        .tokenUri("https://www.googleapis.com/oauth2/v4/token")
                        .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
                        .userNameAttributeName("sub")
                        .clientName("Google")
                        .build()
        );

        return new InMemoryClientRegistrationRepository(registrations);
    }
}