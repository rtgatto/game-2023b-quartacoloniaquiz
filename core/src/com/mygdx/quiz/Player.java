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

    public void move(int spaces) {
        position.setPositions(position.getCurrent(), position.getCurrent() + spaces);
    }

    public Texture getPlayerTexture() {
        return texture;
    }

    public boolean checkWin() {
        return position.getCurrent() >= 119;
    }
}
