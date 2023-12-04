package com.mygdx.quiz;

import com.badlogic.gdx.graphics.Texture;
import java.util.List;

public class Quiz extends Event {
    private String question;
    private List<String> options;
    private String correctOption;

    public Quiz(String question, List<String> options, String correctOption, Texture quizTexture) {
        super(1);
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
        this.texture = quizTexture;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectOption(){
        return correctOption;
    }

    public List<String> getOptions() {
        return options;
    }

    @Override
    public String getMessage(Player player) {
        return null;
    }

 //   @Override
  //  protected int calculateActualSquaresToJump(Player player) {
  //      return 0;
   // }

    @Override
    public void applyEvent(Player player) {

    }
}