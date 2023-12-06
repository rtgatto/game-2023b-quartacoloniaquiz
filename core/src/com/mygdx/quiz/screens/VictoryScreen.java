package com.mygdx.quiz.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.quiz.Sounds;

public class VictoryScreen implements Screen {
    private OrthographicCamera camera;
    private Sounds sounds;
    private BitmapFont font;
    private SpriteBatch batch;

    public VictoryScreen(){
        batch = new SpriteBatch();
        sounds = new Sounds();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1365, 700);

        font = new BitmapFont();
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        sounds.victory.play();
        font.draw(batch, "Victory!", (float) Gdx.graphics.getHeight() /2, (float) Gdx.graphics.getWidth() /2);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        sounds.victory.dispose();
        batch.dispose();
        font.dispose();
    }
}
