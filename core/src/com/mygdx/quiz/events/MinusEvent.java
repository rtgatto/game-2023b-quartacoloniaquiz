package com.mygdx.quiz.events;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.quiz.Player;

public class MinusEvent extends Event {

    
    public MinusEvent() {
        super(3); // Assuming 3 represents a Minus Event
        super.texture = new Texture(Gdx.files.internal("img/minuseventbg.jpg")); // nao funcionou
        super.defaultMessage = "Você tropeçou e caiu algumas casas para trás";
        super.squaresToJump = (int) (Math.random() * 10) + 1; // Random number from 1 to 10
    }

    public Texture getMinusTexture() {
        return super.getTexture();
    }

        public int getSquaresToJump() {
        return squaresToJump;
    }

    @Override
    public String getMessage(Player player) {
        return defaultMessage;// + "You'll jump back " + calculateActualSquaresToJump(player) + " squares.";
    }


    @Override
    public void applyEvent(Player player) {
        // tentando fazer com que o MinusEvent faça com que o jogador volte casas nao avance
        int newPosition = player.position.getCurrent() - squaresToJump;
        // nao deixa o player ir pra posição menor que 0
        if (newPosition < 0) {
            newPosition = 0;
        }
        player.move(newPosition);
    }
}