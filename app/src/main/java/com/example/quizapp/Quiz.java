package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity implements View.OnClickListener {

    private Button falseButton;
    private Button trueButton;
    private TextView questionTextView;
    private ImageView nextButton;
    private ImageView previousbutton;

    private int currentQuestionIndex = 0;

    private Question[] questionBank = new Question[]{
            new Question(R.string.question1, false),
            new Question(R.string.question2, true),
            new Question(R.string.question3, true),
            new Question(R.string.question4, false),
            new Question(R.string.question5, true),
            new Question(R.string.question6, false),
            new Question(R.string.question7, false),
            new Question(R.string.question8, false),
            new Question(R.string.question9, true),
            new Question(R.string.question10, true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        questionTextView = findViewById(R.id.title_view);
        nextButton = findViewById(R.id.next);
        previousbutton = findViewById(R.id.previous);


        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.false_button:
                checkAnswer(false);
                break;
            case R.id.true_button:
                checkAnswer(true);
                break;
            case R.id.next:
                currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length;
                questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());



        }
    }
    public void checkAnswer(boolean userChoice){
        boolean answerIsTrue = questionBank[currentQuestionIndex].isAnswerTrue();
        int toastMessageId = 0;

        if(userChoice == answerIsTrue){
            toastMessageId = R.string.correct;
        }else{
            toastMessageId= R.string.incorrect;
        }
        Toast.makeText(Quiz.this, toastMessageId, Toast.LENGTH_SHORT).show();
    }
}

