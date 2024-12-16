package com.movil.boliviaXplore.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.config.Customizer;

@Configuration
public class WebSecurityConfig{

    private final UserDetailsService userDetailsService;
    private final JWTAuthorizationFilter jwtAuthorizationFilter;

    public WebSecurityConfig(UserDetailsService userDetailsService, JWTAuthorizationFilter jwtAuthenticationFilter){
        this.userDetailsService = userDetailsService;
        this.jwtAuthorizationFilter = jwtAuthenticationFilter;
    }
    
    @Bean
    SecurityFilterChain filterChain (HttpSecurity http, AuthenticationManager authManager) throws Exception{

        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
        jwtAuthenticationFilter.setAuthenticationManager(authManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");

        http
        .csrf(csrf -> csrf.disable()) // Desactiva CSRF
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("api/**").authenticated()
        )
        .httpBasic(Customizer.withDefaults()) // Configura HTTP Basic Auth
        .sessionManagement(session -> session
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Define sesiones sin estado (Stateless)
        )
        .addFilter(jwtAuthenticationFilter) // Agrega tu filtro de autenticación JWT
        .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class); // Agrega tu filtro de autorización JWT antes de UsernamePasswordAuthenticationFilter

    return http.build();
    }

    @Bean 
    AuthenticationManager authManager(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    @Bean 
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
