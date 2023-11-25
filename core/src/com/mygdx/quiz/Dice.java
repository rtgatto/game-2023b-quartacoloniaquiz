package com.mygdx.quiz;

import com.badlogic.gdx.graphics.Texture;

public class Dice {
    private int value;
    private Texture diceTexture;

    public Dice() {
        this.diceTexture = diceTexture;
        roll();
    }

    public int roll() {
        return (int) (Math.random() * 6) + 1;
    }

    public int getValue() {
        return value;
    }

    public Texture getDiceTexture() {
        return diceTexture;
    }
}