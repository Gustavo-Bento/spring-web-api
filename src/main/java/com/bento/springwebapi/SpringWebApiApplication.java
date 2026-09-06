package com.bento.springwebapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application entry point.
 *
 * <p>Bootstraps the Spring Boot context for the Spring Web API project,
 * enabling auto-configuration, component scanning and property support
 * for the {@code com.bento.springwebapi} base package.</p>
 *
 * @author Gustavo Bento
 */
@SpringBootApplication
public class SpringWebApiApplication {

    /**
     * Starts the Spring Boot application.
     *
     * @param args command-line arguments passed to the JVM, forwarded to
     *             {@link SpringApplication#run(Class, String...)}
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringWebApiApplication.class, args);
    }

}