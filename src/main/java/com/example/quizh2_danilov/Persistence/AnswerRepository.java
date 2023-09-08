package com.example.quizh2_danilov.Persistence;

import com.example.quizh2_danilov.Businesslayer.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer,Long> {
}
