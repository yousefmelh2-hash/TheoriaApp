package com.example.yousef;

public class Question {
    public int id;
    public String category;
    public String answer1;
    public String answer2;
    public String answer3;
    public String correctAnswer;
    public String questionText;
    public String imageUri;

    public Question(int id, String category, String answer1, String answer2, String answer3,
                    String correctAnswer, String questionText, String imageUri) {
        this.id = id;
        this.category = category;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.correctAnswer = correctAnswer;
        this.questionText = questionText;
        this.imageUri = imageUri;
    }
}