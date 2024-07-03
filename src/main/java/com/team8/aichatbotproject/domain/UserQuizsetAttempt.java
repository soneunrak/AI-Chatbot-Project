package com.team8.aichatbotproject.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class UserQuizsetAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attemptId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "quizset_id", nullable = false)
    private QuizSet quizSet;

    @ManyToOne
    @JoinColumn(name = "current_question_id", nullable = false)
    private Question currentQuestion;

    @Column(nullable = false)
    private Boolean isComplete;
}
