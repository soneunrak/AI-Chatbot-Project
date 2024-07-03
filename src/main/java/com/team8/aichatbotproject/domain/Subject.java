package com.team8.aichatbotproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String subjectName;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", user=" + user +
                ", subjectName='" + subjectName + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}