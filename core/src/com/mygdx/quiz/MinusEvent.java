package com.mygdx.quiz;

import com.badlogic.gdx.graphics.Texture;

public class MinusEvent extends Event {

    public MinusEvent() {
        super(2); // Assuming 2 represents a Minus Event
        this.texture = null; // Add minus texture image
        this.defaultMessage = "Oh no! You got a Minus Event. ";
        this.squaresToJump = (int) (Math.random() * 10) + 1; // Random number from 1 to 10
    }

    public Texture getMinusTexture() {
        return super.getTexture();
    }

    public int getSquaresToJump() {
        return squaresToJump;
    }

    @Override
    public String getMessage(Player player) {
        return defaultMessage + "You'll jump back " + calculateActualSquaresToJump(player) + " squares.";
    }

    @Override
    protected int calculateActualSquaresToJump(Player player) {
        return Math.max(player.getPosition() - squaresToJump, 0);
    }

    @Override
        int newPosition = playeesn't
    jump out
    of boundaries player.move(Math.max(newPosition,0)-player.getPosition());// functional programming in Java way :)
}}