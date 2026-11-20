package com.example.pgjobqueue;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobQueue {

    private final JdbcTemplate jdbc;

    public JobQueue(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void enqueue(String type, String payload) {
        jdbc.update("INSERT INTO jobs (type, payload) VALUES (?, ?)", type, payload);
    }

    public int countByStatus(String status) {
        Integer n = jdbc.queryForObject(
                "SELECT count(*) FROM jobs WHERE status = ?", Integer.class, status);
        return n == null ? 0 : n;
    }
}