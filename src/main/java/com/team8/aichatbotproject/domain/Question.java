package com.team8.aichatbotproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @ManyToOne
    @JoinColumn(name = "quizset_id", nullable = false)
    private QuizSet quizSet;

    @Column(nullable = false)
    private String questionContent;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String explanation;

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", quizSet=" + quizSet +
                ", questionContent='" + questionContent + '\'' +
                ", explanation='" + explanation + '\'' +
                '}';
    }
}