package com.example.studentwebservice.config;

import com.example.studentwebservice.models.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

//    private final UserDetailsService userDetailsService;

//    public SecurityConfig(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/register", "/swagger-ui.html#").permitAll()
                .antMatchers("account/**").authenticated()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").hasAnyAuthority(Role.ADMIN.getAuthority())
                .antMatchers("/user/**").hasAuthority(Role.USER.getAuthority())
                .anyRequest().authenticated().and().httpBasic()
                .and()
                .formLogin()
                .and()
                .httpBasic();
        return http.build();
    }

//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider(UserRepository userRepo) {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService);
//        provider.setPasswordEncoder(passwordEncoder());
//        return provider;
//    }

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}