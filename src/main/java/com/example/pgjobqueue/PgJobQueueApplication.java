package com.example.pgjobqueue;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PgJobQueueApplication {

    public static void main(String[] args) {
        SpringApplication.run(PgJobQueueApplication.class, args);
    }
    @Bean
    CommandLineRunner demo(JobQueue queue) {
        return args -> {
            queue.enqueue("SEND_EMAIL", "{\"to\":\"jan@x.pl\"}");
            System.out.println("PENDING: " + queue.countByStatus("PENDING"));
        };
    }
}
