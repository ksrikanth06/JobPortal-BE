package com.srikanth.jobportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class JobPortalBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobPortalBeApplication.class, args);
    }

}
