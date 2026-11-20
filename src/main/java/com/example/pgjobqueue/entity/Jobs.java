package com.example.pgjobqueue.entity;
import lombok.*;
import jakarta.persistence.*;

import javax.print.attribute.standard.JobState;
import java.time.OffsetDateTime;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 100, nullable = false)
    private String type;
    @Column(columnDefinition = "text")
    private String payload;
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private JobStatus status;
    @Column(nullable = false)
    private int attempts;
    @Column(name = "run_at", nullable = false)
    private OffsetDateTime runAt;

}
