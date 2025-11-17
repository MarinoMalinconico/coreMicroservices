package com.companyName.coreMicroservices.autoconfig;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@AutoConfiguration
@ConditionalOnClass(org.springframework.data.jpa.repository.JpaRepository.class)
@EntityScan(basePackages = "com.companyName.coreMicroservices.repository.entity")
@EnableJpaRepositories(basePackages = "com.companyName.coreMicroservices.repository")
@Configuration
public class DataAccessAutoConfiguration {
}
