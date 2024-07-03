package com.team8.aichatbotproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "quiz_set")
public class QuizSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizsetId;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private Integer numberOfQuestions;

    @Column(nullable = false)
    private Integer score;

    @Override
    public String toString() {
        return "QuizSet{" +
                "quizsetId=" + quizsetId +
                ", subject=" + subject +
                ", createdAt=" + createdAt +
                ", numberOfQuestions=" + numberOfQuestions +
                ", score=" + score +
                '}';
    }
}
