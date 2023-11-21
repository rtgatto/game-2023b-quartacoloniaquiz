package com.mygdx.quiz;

import com.badlogic.gdx.graphics.Texture;

public abstract class Event {
    private int type; // 0: No Event, 1: Quiz, 2: Plus, 3: Minus, for a random generator to generate
                      // events for squares
    protected String defaultMessage;
    protected int squaresToJump;
    protected Texture texture;

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

    protected abstract int calculateActualSquaresToJump(Player player);

    public abstract void applyEvent(Player player);

}