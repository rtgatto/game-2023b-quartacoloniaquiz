package com.mygdx.quiz;

public class Dice {
    private int value;

    public Dice() {
        roll();
    }

    public void roll() {
        value = (int) (Math.random() * 6) + 1;
    }

    public int getValue() {
        return value;
    }
}