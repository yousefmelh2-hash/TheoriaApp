package com.example.yousef;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;

public class Practice extends AppCompatActivity {
private Boolean doneFirstQuestion=false;
private boolean inPreviousQUestion=false;
private int numberOfQuestions =0;

TextView tvQuestion;
private String currentCorrectAnswer;
ImageView picture;
private RadioButton radioBtnAnswer1, radioBtnAnswer2, radioBtnAnswer3, radioBtnAnswer4;
Button btnPrevious, btnNext, btnEnd;
RadioGroup radioGroup;
ArrayList<Question> questions=new ArrayList<>();

    HelperDB dbHelper;
    Question currentQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
       initComponents();
       setListeners();
       loadNewQuestion();
    }

    private void loadNewQuestion() {
        inPreviousQUestion=false;
        currentQuestion = dbHelper.getTamrurimQuestion();

        if (currentQuestion != null) {
            tvQuestion.setText(currentQuestion.questionText);

            currentCorrectAnswer = currentQuestion.correctAnswer;

            // הכנסת 4 התשובות לרשימה וערבוב שלהן
            ArrayList<String> answers = new ArrayList<>();
            answers.add(currentQuestion.answer1);
            answers.add(currentQuestion.answer2);
            answers.add(currentQuestion.answer3);
            answers.add(currentQuestion.correctAnswer);
            Collections.shuffle(answers);

            radioBtnAnswer1.setText(answers.get(0));
            radioBtnAnswer2.setText(answers.get(1));
            radioBtnAnswer3.setText(answers.get(2));
            radioBtnAnswer4.setText(answers.get(3));

            // ניקוי הבחירה מהשאלה הקודמת
            radioGroup.clearCheck();
            if (currentQuestion.imageUri != null && !currentQuestion.imageUri.isEmpty()) {
                picture.setVisibility(View.VISIBLE);

                // Use Glide to download and display the image from the URL
                Glide.with(this)
                        .load(currentQuestion.imageUri)
                        .into(picture);

            } else {
                // Hide the ImageView if there is no image for this question
                picture.setVisibility(View.GONE);
            }
        }
        radioBtnAnswer1.setTextColor(Color.WHITE);
        radioBtnAnswer2.setTextColor(Color.WHITE);
        radioBtnAnswer3.setTextColor(Color.WHITE);
        radioBtnAnswer4.setTextColor(Color.WHITE);
    }

    private void setListeners() {
    btnPrevious.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (numberOfQuestions==0 ){
                Toast.makeText(Practice.this, "אי אפשר לחזור, כי לא פתרת שאלה קודמת", Toast.LENGTH_SHORT).show();
            }
            else {}
        }
    });
    btnNext.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            loadNewQuestion();
            if (!inPreviousQUestion){numberOfQuestions++;}
            questions.add(currentQuestion);
        }
    });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton selectedRadioButton = findViewById(checkedId);


                // הבדיקה הזו חשובה כי clearCheck() מפעיל את המאזין עם null
                if (selectedRadioButton != null) {

                    // אם צדק - ירוק, אם טעה - אדום
                    if (selectedRadioButton.getText().toString().equals(currentCorrectAnswer)) {
                        selectedRadioButton.setTextColor(Color.GREEN);

                    } else {
                        selectedRadioButton.setTextColor(Color.RED);
                    }

                    // צובע את התשובה הנכונה בירוק (למקרה שטעה)
                    if (radioBtnAnswer1.getText().toString().equals(currentCorrectAnswer)) radioBtnAnswer1.setTextColor(Color.GREEN);
                    if (radioBtnAnswer2.getText().toString().equals(currentCorrectAnswer)) radioBtnAnswer2.setTextColor(Color.GREEN);
                    if (radioBtnAnswer3.getText().toString().equals(currentCorrectAnswer)) radioBtnAnswer3.setTextColor(Color.GREEN);
                    if (radioBtnAnswer4.getText().toString().equals(currentCorrectAnswer)) radioBtnAnswer4.setTextColor(Color.GREEN);

                }
            }
        });

    }

    private void loadPreviousQuestion(){
            /*inPreviousQUestion=true;
            tvQuestion.setText(currentQuestion.questionText);


        Question prevQuestion = questions.get(numberOfQuestions-1);
        currentCorrectAnswer = prevQuestion.correctAnswer;

            radioBtnAnswer1.setText(prevQuestion.answer1);
            radioBtnAnswer2.setText(prevQuestion.answer2);
            radioBtnAnswer3.setText(prevQuestion.answer3);
            radioBtnAnswer4.setText(prevQuestion.correctAnswer);

        radioGroup.clearCheck();

            if (currentQuestion.imageUri != null && !currentQuestion.imageUri.isEmpty()) {
                picture.setVisibility(View.VISIBLE);

                // Use Glide to download and display the image from the URL
                Glide.with(this)
                        .load(prevQuestion.imageUri)
                        .into(picture);

            } else {
                // Hide the ImageView if there is no image for this question
                picture.setVisibility(View.GONE);
            }
        for (int i = 0; i < 4; i++) {
            RadioButton rb = (RadioButton) radioGroup.getChildAt(i);
            rb.setTextColor(Color.WHITE); // Reset color first

            if (rb.getText().toString().equals(currentCorrectAnswer)) {
                rb.setTextColor(Color.GREEN);
            }
        }*/

    }

    private void initComponents() {
        btnPrevious=findViewById(R.id.btnPrevious);
        btnNext=findViewById(R.id.btnNext);
        btnEnd=findViewById(R.id.btnEnd);
        radioGroup=findViewById(R.id.radioGroup);
        radioBtnAnswer1 = (RadioButton) radioGroup.getChildAt(0);
        radioBtnAnswer2 = (RadioButton) radioGroup.getChildAt(1);
        radioBtnAnswer3 = (RadioButton) radioGroup.getChildAt(2);
        tvQuestion = findViewById(R.id.tvQuestion);
        radioBtnAnswer4 = (RadioButton) radioGroup.getChildAt(3);
        picture=findViewById(R.id.picture);
        dbHelper = new HelperDB(this);
        // הצבת התשובות המעורבבות בכפתורי הרדיו
        radioBtnAnswer1 = (RadioButton) radioGroup.getChildAt(0);
        radioBtnAnswer2 = (RadioButton) radioGroup.getChildAt(1);
        radioBtnAnswer3 = (RadioButton) radioGroup.getChildAt(2);
        radioBtnAnswer4 = (RadioButton) radioGroup.getChildAt(3);

    }
}