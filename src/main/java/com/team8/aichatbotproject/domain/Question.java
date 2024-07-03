package com.team8.aichatbotproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;

    @ManyToOne
    @JoinColumn(name = "quizset_id", nullable = false)
    private QuizSet quizSet;

    @Column(nullable = false)
    private String questionContent;

    @Column(nullable = false)
    private String explanation;
}
