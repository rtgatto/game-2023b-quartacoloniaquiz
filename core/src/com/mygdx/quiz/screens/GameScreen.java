package com.mygdx.quiz.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.quiz.QuartaColoniaQuiz;
import sun.awt.X11.XSetWindowAttributes;

public class GameScreen implements Screen {

    final QuartaColoniaQuiz quiz;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Texture texture;
    private ShapeRenderer shapeRenderer;

    public GameScreen(QuartaColoniaQuiz quiz) {
        this.quiz = quiz;
        batch = new SpriteBatch();
        Gdx.graphics.setWindowedMode(1370, 715);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 3400, 2323);
        texture = new Texture(Gdx.files.internal("mapa.png"));
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        batch.setProjectionMatrix(camera.combined);
        shapeRenderer.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(texture, (1370 - texture.getWidth()) / 2f, (715 - texture.getHeight()) / 2f);
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
        batch.dispose();
        texture.dispose();
        shapeRenderer.dispose();
    }
}