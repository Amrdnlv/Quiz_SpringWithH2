package com.example.quizh2_danilov.Businesslayer;

import com.example.quizh2_danilov.Persistence.AnswerRepository;
import com.example.quizh2_danilov.Persistence.OptionRepository;
import com.example.quizh2_danilov.Persistence.QuizRepository;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class QuizService {

    private QuizRepository quizRepository;

    private OptionRepository optionRepository;

    private AnswerRepository answerRepository;

    private HashMap<String, Object> pass = new HashMap() {{
        put("success", true);
        put("feedback", "Congratulations, you're right!");
    }};
    private HashMap<String, Object> fail = new HashMap() {{
        put("success", false);
        put("feedback", "Wrong answer! Please, try again.");
    }};

    @Autowired
    public QuizService(QuizRepository quizRepository, OptionRepository optionRepository, AnswerRepository answerRepository) {
        this.quizRepository = quizRepository;
        this.optionRepository = optionRepository;
        this.answerRepository = answerRepository;
    }

    public Quiz AddQuizQestion(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Iterable<Quiz> GetAllQestion() {
        return quizRepository.findAll();
    }

    public Quiz GetQestionId(Long id) {
        return quizRepository.findQuizById(id);
    }

    public HashMap<String, Object> CheckingTheResponse(Long id, List<Integer> answer) {
        Quiz quizz = quizRepository.findQuizById(id);
        List<Integer> trueAnswer = quizz.GetTrueAnswer();
        Collections.sort(answer);
        Collections.sort(trueAnswer);
        if (answer.equals(trueAnswer)) return pass;
        else return fail;
    }

}
