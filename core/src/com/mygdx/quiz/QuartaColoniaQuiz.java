package com.mygdx.quiz;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.quiz.screens.GameScreen;

public class QuartaColoniaQuiz extends Game {
    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();

        this.setScreen(new GameScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}