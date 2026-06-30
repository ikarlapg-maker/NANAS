package com.Nanas.demo.infraestructura.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 1. DESACTIVAR TOTALMENTE CSRF (Esto quita el error 403 en POST/PUT/PATCH)
            .csrf(csrf -> csrf.disable())
            
            // 2. Permitir que cualquier origen (como React) se conecte
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            
            // 3. Abrir por completo las autorizaciones de las rutas de la API
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll() // <-- Abre todos los endpoints
                .anyRequest().permitAll()              // <-- Abre cualquier otra ruta por seguridad en pruebas
            );
            
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // Permitimos todos los orígenes, métodos y cabeceras de forma masiva para pruebas locales
        configuration.setAllowedOriginPatterns(List.of("*")); 
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
