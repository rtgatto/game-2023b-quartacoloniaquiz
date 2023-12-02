package com.mygdx.quiz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.quiz.Position;

public class Player {
    public Position position;
    public Texture texture;

    public Player() {
        this.position = new Position(); // player starts at position 0
        this.texture = new Texture(Gdx.files.internal("img/player.png"));
    }

    public void move(int newPosition) {
        // actual position becomes previous and position to move becomes actual position
        position.setPositions(position.getCurrent(), newPosition);
    }

    public Texture getPlayerTexture() {
        return texture;
    }

    public boolean checkWin() {
        return position.getCurrent() >= 119;
    }
}