package com.onetwo.library_management.configuration;


import com.onetwo.library_management.security.*;

import com.onetwo.library_management.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

//    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//        // @formatter:off
//        auth.inMemoryAuthentication()
//                .withUser("user1").password(passwordEncoder.encode("user1Pass")).roles("USER")
//                .and()
//                .withUser("user2").password(passwordEncoder.encode("user2Pass")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder.encode("adminPass")).roles("ADMIN");
//        // @formatter:on
//    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/anonymous*").anonymous()
                    .antMatchers("/register*").permitAll()
                    .antMatchers("/login*").permitAll()
                    .antMatchers("/").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .successHandler(authenticationSuccessHandler())
                    .failureHandler(authenticationFailureHandler())
                    .defaultSuccessUrl("/", true)
                .and()
                    .exceptionHandling()
                        .accessDeniedHandler(accessDeniedHandler())
                        .authenticationEntryPoint(authenticationEntryPoint())
                .and()
                    .logout().permitAll()
                    .deleteCookies("JSESSIONID")
                    .logoutSuccessHandler(logoutSuccessHandler());
        //.and()
        //.exceptionHandling().accessDeniedPage("/accessDenied");
        //.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
        // @formatter:on
    }


    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }
    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

    @Bean
    public CustomAuthenticationEntryPoint authenticationEntryPoint() {
        return new CustomAuthenticationEntryPoint();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

}