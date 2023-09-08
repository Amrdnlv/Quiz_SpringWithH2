package com.example.quizh2_danilov.Presentation;

import com.example.quizh2_danilov.Businesslayer.Quiz;
import com.example.quizh2_danilov.Businesslayer.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuizContoller {

    @Autowired
    QuizService quizService;


    //Добавление вопроса
    @PostMapping("/quizzes")
    public ResponseEntity AddQuizez(@RequestBody Quiz quiz) {
        //return quizRepository.save(quiz);
        return new ResponseEntity(quizService.AddQuizQestion(quiz), HttpStatus.CREATED);
    }

    //Получение всех вопросов
    @GetMapping("/quiz")
    public ResponseEntity Quiz() {
        return new ResponseEntity<Object>(quizService.GetAllQestion(), HttpStatus.OK);
    }

    //Получение вопроса
    @GetMapping("/quizzes/{id}")
    public ResponseEntity GetQuzez (@PathVariable("id") long id ) {
        return new ResponseEntity<Object>(quizService.GetQestionId(id), HttpStatus.OK);
    }

    //Проверка правильного ответа
    @PostMapping("/quizzes/{id}/solve")
    public ResponseEntity QuizAnswerSolver(@PathVariable Long id, @RequestParam List<Integer> answer) {

        return new ResponseEntity(quizService.CheckingTheResponse(id,answer), HttpStatus.OK);
    }

}
