package com.mygdx.quiz;

import com.badlogic.gdx.graphics.Texture;

public class Player {
    private int playerId;
    private int position;
    private Texture playerTexture;

    public Player(int playerId, Texture playerTexture) {
        this.playerId = playerId;
        this.position = 0; // player starts at position 0
        this.playerTexture = playerTexture;
    }

    public void move(int spaces) {
        this.position += spaces;
    }

    public int getPosition() {
        return position;
    }

    public int getPlayerId() {
        return playerId;
    }

    public Texture getPlayerTexture() {
        return playerTexture;
    }

    public boolean checkWin() {
        return position >= 119;
    }
}