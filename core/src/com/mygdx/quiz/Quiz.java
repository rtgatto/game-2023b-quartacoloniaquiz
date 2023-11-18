package com.mygdx.quiz;

import java.util.List;

public class Quiz extends Event {
    private String question;
    private List<String> options;
    private int correctOptionIndex;

    public Quiz(String question, List<String> options, int correctOptionIndex) {
        super(0); // Assuming 0 represents a Quiz Event
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
