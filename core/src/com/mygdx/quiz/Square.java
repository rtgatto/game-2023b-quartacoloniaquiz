package com.mygdx.quiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import jdk.internal.org.jline.terminal.Terminal;

public class Square {
    private int number;
    public Event event;
    private Texture texture;

    public Square(int i, ArrayList<Quiz> quizzes) {
        this.number = i;
        this.event = createEvent(quizzes);
        this.texture = setRandomTexture();
    }

    public Square(int i) {
        this.number = i;
        this.event = new StayHereEvent();
        this.texture = setRandomTexture();
    }

    public Event createEvent(ArrayList<Quiz> quizzes) {
        double randomEvent = Math.random();

        // 30% chance of an event happening
        if (randomEvent < 0.3) {
            // Within the event, 33% chance for each type (Quiz, Plus, Minus)
            double randomType = Math.random();
            if (randomType < 0.33) {
                Quiz quiz = quizzes.get(0);
                quizzes.remove(0);
                return quiz;
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
        if (event != null) {
            return event.getType();
        }
        return 0; // Default value for no event
    }

    private Texture setRandomTexture() {
        ArrayList<String> namesTextures = new ArrayList<>();
        Random random = new Random();

        namesTextures.add("aquamarine.png");
        namesTextures.add("dark_blue.png");
        namesTextures.add("dark_slate_gray.png");
        namesTextures.add("dark_spring_green.png");
        namesTextures.add("federal_blue.png");
        namesTextures.add("mint.png");
        namesTextures.add("jade.png");

        int index = random.nextInt(namesTextures.size());
        String color = namesTextures.get(index);

        return new Texture(Gdx.files.internal("squareTextures/" + color));
    }

    public Texture getTexture() {
        return this.texture;
    }
}