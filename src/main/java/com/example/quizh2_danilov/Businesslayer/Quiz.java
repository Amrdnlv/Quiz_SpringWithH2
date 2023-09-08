package com.example.quizh2_danilov.Businesslayer;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;
    String title;
    String text;
    // (целевая сущность, каскадный тип)
    @OneToMany(targetEntity = Option.class, cascade = CascadeType.ALL)
    // название внешнего ключа Option, сопоставление с  идентификатором в классе
    @JoinColumn(name="quiz_id", referencedColumnName = "id")
    List<Option> options;

    @OneToMany(targetEntity = Answer.class, cascade = CascadeType.ALL)
    // название внешнего ключа Option, сопоставление с  идентификатором в классе
    @JoinColumn(name="quizanswer_id", referencedColumnName = "id")
    List<Answer> answer;


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    public List<Integer> GetTrueAnswer(){
        List<Integer> truemass = new ArrayList<Integer>();
        for (Answer trueAnswer:answer) {
                truemass.add(trueAnswer.getAnswer());
        }
        return truemass;
    }
}
