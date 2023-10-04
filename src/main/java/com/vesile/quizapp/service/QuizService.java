package com.vesile.quizapp.service;

import com.vesile.quizapp.dao.QuestionDao;
import com.vesile.quizapp.dao.QuizDao;
import com.vesile.quizapp.model.Question;
import com.vesile.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, String title, Integer  numberOfQuestions) {

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numberOfQuestions);

        Quiz quiz = new Quiz();
        quiz.setQuizTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);
    }
}
