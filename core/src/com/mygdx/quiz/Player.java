package com.mygdx.quiz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Player {
    private int position;
    private Texture playerTexture;

    public Player() {
        this.position = 0; // player starts at position 0
        this.playerTexture = new Texture(Gdx.files.internal("dino.png"));
    }

    public void move(int spaces) {
        this.position += spaces;
    }

    public int getPosition() {
        return position;
    }

    public Texture getPlayerTexture() {
        return playerTexture;
    }

    public boolean checkWin() {
        return position >= 119;
    }
}