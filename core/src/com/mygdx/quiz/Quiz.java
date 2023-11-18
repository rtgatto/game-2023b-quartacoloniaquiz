package com.mygdx.quiz;

import java.util.List;
import java.util.ArrayList;

public class Quiz {
    private String question;
    private List<String> options;
    private int correctOptionIndex;

    public Quiz(String question, List<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;

        if (correctOptionIndex < 0 || correctOptionIndex >= options.size()) {
            throw new IllegalArgumentException("Correct option index is out of bounds");
        }
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isOptionCorrect(int selectedOptionIndex) {
        return selectedOptionIndex == correctOptionIndex;
    }
}