package com.example.quizh2_danilov.Businesslayer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;
    String option;

    public Option() {

    }

    public Option(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }


}
