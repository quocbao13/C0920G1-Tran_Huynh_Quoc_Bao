package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questionType")
public class QuestionType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionTypeId;
    private String name;

    @OneToMany(mappedBy = "questionType",cascade = CascadeType.ALL)
    private List<Question> questions;

    public QuestionType() {
    }

    public Long getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Long questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
