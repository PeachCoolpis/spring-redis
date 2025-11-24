package com.springredis;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringRedisApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringRedisApplication.class, args);
    }
    
    @Bean
    public JPAQueryFactory  jpaQueryFactory(EntityManager em) {
        return new JPAQueryFactory(em);
    }
}
