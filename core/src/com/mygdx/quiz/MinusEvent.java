package com.mygdx.quiz;

import com.badlogic.gdx.graphics.Texture;

public class MinusEvent extends Event {
    private Texture minusTexture;
    private String defaultMessage;
    private int squaresToJump;

    public MinusEvent() {
        super(2); // Assuming 2 represents a Minus Event
        this.minusTexture = null; // Add minus texture image
        this.defaultMessage = "Oh no! You got a Minus Event. ";
        this.squaresToJump = (int) (Math.random() * 10) + 1; // Random number from 1 to 10
    }

    public Texture getMinusTexture() {
        return minusTexture;
    }

    public String getDefaultMessage() {
        return defaultMessage; // keep this getter in case we want to add events that don't jump squares
    }

    public int getSquaresToJump() {
        return squaresToJump;
    }

    public String getMessage() {
        return defaultMessage + "You'll jump back " + calculateActualSquaresToJump() + " squares.";
    }

    private int calculateActualSquaresToJump() {
        // Calculate actual squares to jump after boundary checks
        return Math.min(squaresToJump, getPosition());
    }

    public void applyEvent(Player player) {
        int newPosition = player.getPosition() - getSquaresToJump();
        // Ensure the player doesn't jump out of boundaries
        player.move(Math.max(newPosition, 0) - player.getPosition());// functional programming in Java way :)
        System.out.println(getMessage()); // Display the message
    }
}