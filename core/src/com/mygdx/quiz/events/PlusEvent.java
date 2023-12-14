package com.mygdx.quiz.events;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.quiz.Dice;
import com.mygdx.quiz.Player;

public class PlusEvent extends Event {

    public PlusEvent() {
        super(2); // Assuming 2 represents a Plus Event
        super.texture = new Texture(Gdx.files.internal("img/quarta_colonia.png")); // Add plus texture image
        super.defaultMessage = "Você encontrou um atalho";
        super.squaresToJump = new Dice().roll();
    }

    public Texture getPlusTexture() {
        return super.getTexture();
    }

    public int getSquaresToJump() {
        return squaresToJump;
    }

    // @Override
    public String getMessage(Player player) {
        return defaultMessage;
    }

    @Override
    public void applyEvent(Player player) {
        int newPosition = player.position.getCurrent() + getSquaresToJump();
        // Ensure the player doesn't jump out of boundaries
        if (newPosition > 119) {
            newPosition = 119;
        }
        player.move(newPosition);
    }
}