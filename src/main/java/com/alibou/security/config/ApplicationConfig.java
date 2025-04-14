package com.alibou.security.config;

import org.springframework.context.annotation.*;
import lombok.RequiredArgsConstructor;
import com.alibou.security.user.UserRepository;
import org.springframework.security.core.userdetails.*;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final UserRepository repository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}