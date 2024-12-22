package ru.netology.task_4_Hibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        // Доступ к /public/** без авторизации
                        .requestMatchers("/public/**").permitAll()
                        // Все остальные запросы требуют авторизации
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        // Включение стандартной формы логина
                        .defaultSuccessUrl("/", true)
                )
                .logout(logout -> logout
                        // Включение стандартного логаута
                        .logoutSuccessUrl("/public")
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}