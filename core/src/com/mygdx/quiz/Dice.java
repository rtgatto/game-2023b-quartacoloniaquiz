package com.mygdx.quiz;

public class Dice {
    public int value;

    public Dice() {
        value = roll();
    }

    public int roll() {
        return (int) (Math.random() * 6) + 1;
    }

    public int getValue() {
        return value;
    }
}