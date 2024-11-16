package com.hotel.reservas.confing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated() // Todas las solicitudes requieren autenticación
            )
            .httpBasic() // Habilita autenticación básica
            .and()
            .cors(cors -> cors.configurationSource(request -> {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(List.of("http://localhost:3000")); // Permitir solicitudes del frontend
                config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE")); // Métodos HTTP permitidos
                config.setAllowedHeaders(List.of("*")); // Permitir todos los headers
                config.setAllowCredentials(true); // Permitir envío de credenciales
                return config;
            }))
            .csrf(csrf -> csrf.disable()); // Deshabilitar CSRF si el frontend no lo maneja

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.builder()
                .username("444") // Usuario configurado
                .password(passwordEncoder.encode("1234")) // Contraseña encriptada
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

