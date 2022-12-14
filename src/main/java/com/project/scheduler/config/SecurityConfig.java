package com.project.scheduler.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.project.scheduler.security.CustomLoginFailureHandler;
import com.project.scheduler.security.CustomLoginSuccessHandler;
import com.project.scheduler.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomLoginSuccessHandler customLoginSuccessHandler;

    @Autowired
    private CustomLoginFailureHandler customLoginFailureHandler;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .mvcMatchers(
                    HttpMethod.GET,
                    "/",
                    "/login",
                    "/join",
                    "/resources/**"
                ).permitAll()
                .antMatchers("/member/**").authenticated()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .successHandler(customLoginSuccessHandler)
                .failureHandler(customLoginFailureHandler)
                .usernameParameter("userId")	// ????????? ????????????????????? username??? ?????? ????????? ?????? ????????? ??????????????? ?????? ?????? ??????
                .passwordParameter("userPw")	// ?????? password??? ??????
                .permitAll()
            )
            .logout()
                .logoutSuccessUrl("/")
                .and()
            .csrf().disable()
            .build();
    }

    /**
     * ?????? ??????
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/resources/**");
    }
    
    /**
     * Password Encoding
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /**
    * ?????? ?????? ??????(?????????)
    */
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }
   
}
