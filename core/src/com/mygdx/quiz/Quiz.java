package com.mygdx.quiz;

import com.badlogic.gdx.graphics.Texture;
import java.util.List;

public class Quiz extends Event {
    private String question;
    private List<String> options;
    private int correctOptionIndex;

    public Quiz(String question, List<String> options, int correctOptionIndex, Texture quizTexture) {
        super(0);
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
        this.texture = quizTexture;

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

    @Override
    public String getMessage(Player player) {
        return null;
    }

    @Override
    protected int calculateActualSquaresToJump(Player player) {
        return 0;
    }

    @Override
    public void applyEvent(Player player) {

    }
}