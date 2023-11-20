package com.mygdx.quiz;

import com.badlogic.gdx.graphics.Texture;

public class PlusEvent extends Event {
    private Texture plusTexture;
    private String defaultMessage;
    private int squaresToJump;

    public PlusEvent() {
        super(1); // Assuming 1 represents a Plus Event
        this.plusTexture = null; // Add plus texture image
        this.defaultMessage = "You got a Plus Event! ";
        this.squaresToJump = (int) (Math.random() * 10) + 1; // Random number of squares to jump, from 1 to 10
    }

    public Texture getPlusTexture() {
        return plusTexture;
    }

    public String getDefaultMessage() {
        return defaultMessage; // keep this getter in case we want to add events that don't jump squares
    }

    public int getSquaresToJump() {
        return squaresToJump;
    }

    public String getMessage(Player player) {
        return defaultMessage + "You'll jump ahead " + calculateActualSquaresToJump(player) + " squares.";
    }

    private int calculateActualSquaresToJump(Player player) {
        // Calculate actual squares to jump after boundary checks
        return Math.min(squaresToJump, 120 - player.getPosition());
    }

    public void applyEvent(Player player) {
        int newPosition = player.getPosition() + getSquaresToJump();
        // Ensure the player doesn't jump out of boundaries
        player.move(Math.min(newPosition, 120) - player.getPosition()); // functional programming in Java way :)
        System.out.println(getMessage(player)); // Display the message
    }
}