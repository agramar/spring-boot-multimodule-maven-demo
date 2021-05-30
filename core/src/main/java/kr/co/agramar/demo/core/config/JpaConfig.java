package kr.co.agramar.demo.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "kr.co.agramar.demo.*.*.jpa")
@Configuration
public class JpaConfig {
}
