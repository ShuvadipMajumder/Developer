package com.example.ldap_auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.ldap.LdapBindAuthenticationManagerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()  // All requests require authentication
            )
            .formLogin(login -> login
                .loginPage("/login")  // Custom login page
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")  // Redirect after logout
                .permitAll()
            )
            ;

        return http.build();
    }
    
    @Bean
    AuthenticationManager myAuthenticationManagerBean(LdapContextSource contextSource) {
        LdapBindAuthenticationManagerFactory factory =
                new LdapBindAuthenticationManagerFactory(contextSource);
        factory.setUserSearchBase("OU=people");
        factory.setUserSearchFilter("(&(objectClass=people)(dn={0}))");

        DefaultLdapAuthoritiesPopulator defaultAuthoritiesPopulator = new DefaultLdapAuthoritiesPopulator(
                contextSource, "OU=people");
        defaultAuthoritiesPopulator.setGroupSearchFilter("(&(people={0})(dn=*))");
        defaultAuthoritiesPopulator.setGroupRoleAttribute("dn");
        factory.setLdapAuthoritiesPopulator(defaultAuthoritiesPopulator);

        return factory.createAuthenticationManager();
    }
}
