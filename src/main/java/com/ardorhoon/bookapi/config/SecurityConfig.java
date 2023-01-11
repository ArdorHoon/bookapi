package com.ardorhoon.bookapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;


@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        //모든 인증되지 않은 요청을 허락한다
        httpSecurity.csrf().disable();
        httpSecurity.authorizeRequests().antMatchers("/**").permitAll()
                .and()
                .headers()
                .addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN));
//                .and()
//                .formLogin()
//                .loginPage("/user/login")
//                .defaultSuccessUrl("/")
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
//                .logoutSuccessUrl("/")
//                .invalidateHttpSession(true); //로그아웃 시 생성된 사용자 세션 삭제

        return httpSecurity.build();
    }


}
