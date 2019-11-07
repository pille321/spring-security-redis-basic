package com.example.spring.session.sessionshare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
                    throws Exception
    {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                        .withUser("admin")
                        .password(encoder.encode("password"))
                        .roles("ADMIN").and()
                        .withUser("horst")
                        .password(encoder.encode("password"))
                        .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http)
                    throws Exception
    {
        http.httpBasic().and().csrf().disable()
                        .authorizeRequests()
                        .antMatchers("/name/**").hasRole("ADMIN")
                        //.anyRequest().authenticated()
                        //.antMatchers("/**").permitAll()
                        .and()
                        //.formLogin()
                        //.loginPage("/login.html")
                        //.loginProcessingUrl("/perform_login")
                        //.defaultSuccessUrl("/homepage.html", true)
                        //.failureUrl("/login.html?error=true")
                        //.failureHandler(authenticationFailureHandler())
                        .logout()
                        //.logoutUrl("/perform_logout")
                        .deleteCookies("JSESSIONID").permitAll();
                        //logoutSuccessHandler(logoutSuccessHandler());
    }
}