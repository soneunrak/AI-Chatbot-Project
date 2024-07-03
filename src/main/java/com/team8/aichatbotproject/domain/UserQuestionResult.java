package com.team8.aichatbotproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Entity
public class UserQuestionResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resultId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "user_option_id", nullable = false)
    private Option option;

    @Column(nullable = false)
    private Boolean isCorrect;

    @Column(nullable = false)
    private Boolean isBookmarked = false;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
