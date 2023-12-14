package com.mygdx.quiz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.quiz.events.*;

import java.util.ArrayList;
import java.util.Random;

public class Square {
    private final int number;
    public Event event;
    private final Texture texture;

    public Square(int i, Quiz quiz) {
        this.number = i;
        this.event = createEvent(quiz);
        this.texture = setRandomTexture();
    }

    public Square(int i) {
        this.number = i;
        this.event = new StayHereEvent();
        this.texture = setRandomTexture();
    }

    public Event createEvent(Quiz quiz) {
        double randomEvent = Math.random();

        // 30% chance of an event happening
        if (randomEvent < 0.7) {
            // Within the event, 33% chance for each type (Quiz, Plus, Minus)
            double randomType = Math.random();
            if (randomType < 0.33) {
                return quiz.getRandomQuiz();
            } else if (randomType < 0.66) {
                return new PlusEvent();
            } else {
                return new MinusEvent();
            }
        }
        return new StayHereEvent();
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public int getEventType() {
        return event.getType();
    }

    private Texture setRandomTexture() {
        ArrayList<String> namesTextures = new ArrayList<>();
        Random random = new Random();

        namesTextures.add("tile1.jpg");
        namesTextures.add("tile2.jpg");
        namesTextures.add("tile1.jpg");
        namesTextures.add("tile6.jpg");
        namesTextures.add("tile6.jpg");
        namesTextures.add("tile2.jpg");
        namesTextures.add("tile7.jpg");

        int index = random.nextInt(namesTextures.size());
        String color = namesTextures.get(index);

        return new Texture(Gdx.files.internal("squareTextures/" + color));
    }

    public Texture getTexture() {
        return this.texture;
    }
}