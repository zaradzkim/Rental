package com.mzaradzki.config;

import com.mzaradzki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Marcel on 2016-11-18.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/login").permitAll() //dont need account
                    .antMatchers("/register").permitAll()
                    .antMatchers("/resources/**").permitAll()
                    .antMatchers("/**").authenticated() //others require logging
                .and()
                .formLogin()   //configuration of login page
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .loginPage("/login") //adress when user isn't authorizated and add my login page
                    .loginProcessingUrl("/login") //definition of adress where send post from login page
                .and()
                .logout()
                    .logoutUrl("/logout") //what adress to post when user logout
                    .logoutSuccessUrl("/login?logout")  // when user logout, go to page login, ?logout forexample for page with information "Logout success"
                .and()
                .csrf() //cross site request forgery
                    .disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService); //checking email and password with UserServiceImpl and UserService interface for Spring security
    }
}
