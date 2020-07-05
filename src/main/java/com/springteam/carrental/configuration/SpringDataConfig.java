package com.springteam.carrental.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.springteam.carrental.model.repository")
@EntityScan(basePackages = "com.springteam.carrental.model.entity")
public class SpringDataConfig {
}
