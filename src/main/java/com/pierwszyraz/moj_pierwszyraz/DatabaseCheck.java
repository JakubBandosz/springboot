package com.pierwszyraz.moj_pierwszyraz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Component
public class DatabaseCheck implements CommandLineRunner {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void run(String... args) {
        try {
            Query query = entityManager.createNativeQuery("SELECT 1");
            Object result = query.getSingleResult();
            System.out.println("dziala: " + result);
        } catch (Exception e) {
            System.err.println("❌ Błąd połączenia z bazą: " + e.getMessage());
        }
    }
}
