package com.mygdx.quiz;

public class Dado {
    private int value;

    public Dado() {
        roll();
    }

    public void roll() {
        value = (int) (Math.random() * 6) + 1;
    }

    public int getValue() {
        return value;
    }
}