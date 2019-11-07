package com.example.spring.session.sessionshare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;



@SpringBootApplication
public class SessionshareApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SessionshareApplication.class, args);
    }

}
