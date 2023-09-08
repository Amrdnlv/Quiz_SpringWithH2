package com.example.quizh2_danilov.Persistence;

import com.example.quizh2_danilov.Businesslayer.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz,Long> {
    Quiz findQuizById(Long id);
}
