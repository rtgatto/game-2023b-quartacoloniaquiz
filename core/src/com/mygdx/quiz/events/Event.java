package com.mygdx.quiz.events;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.quiz.Player;

public abstract class Event {
    private final int type; // 0: Stay Here Event, 1: Quiz, 2: Plus, 3: Minus, for a random generator to
                      // generate
                      // events for squares
    protected String defaultMessage;
    protected int squaresToJump;
    public Texture texture;

    public Event(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public Texture getTexture() {
        return texture;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public abstract String getMessage(Player player);

    // protected abstract int calculateActualSquaresToJump(Player player);

    public abstract void applyEvent(Player player);
}