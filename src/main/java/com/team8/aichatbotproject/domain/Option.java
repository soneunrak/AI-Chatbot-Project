package com.team8.aichatbotproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "option")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionId;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(nullable = false)
    private String optionContent;

    @Column(nullable = false)
    private Boolean isCorrect;

    @Override
    public String toString() {
        return "Option{" +
                "optionId=" + optionId +
                ", question=" + question +
                ", optionContent='" + optionContent + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}