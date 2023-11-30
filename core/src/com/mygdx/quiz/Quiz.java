package com.mygdx.quiz;

import com.badlogic.gdx.graphics.Texture;
import java.util.List;

public class Quiz extends Event {
    private String question;
    private List<String> options;
    private int correctOptionIndex;

    public Quiz(String question, List<String> options, int correctOptionIndex, Texture quizTexture) {
        super(1);
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

    public void isOptionCorrect(int selectedOptionIndex, Player player) {
        if (!(selectedOptionIndex-1 == correctOptionIndex)){
            System.out.print("Resposta errada\n");
            player.position.setPositions(player.position.getPrevious(), player.position.getPrevious());
        }
        else {
            System.out.print("Resposta correta\n");
        }
    }
    public boolean isOptionCorrect1(int selectedOptionIndex){
        return selectedOptionIndex-1 == correctOptionIndex;

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