package com.github.dannil.productmanagement;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest
class ProductManagementApplicationTests {

    // Testcontainers takes care of tearing down the container
    @SuppressWarnings("resource")
    private static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:17")
            .withDatabaseName("postgres").withUsername("postgres").withPassword("postgres");

    @BeforeAll
    private static void setup() {
        postgres.start();
        System.setProperty("spring.datasource.url", postgres.getJdbcUrl());
        System.setProperty("spring.datasource.username", postgres.getUsername());
        System.setProperty("spring.datasource.password", postgres.getPassword());
    }

}
