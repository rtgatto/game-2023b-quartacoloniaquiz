package com.mygdx.quiz.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.quiz.QuartaColoniaQuiz;

public class GameScreen implements Screen {

    final QuartaColoniaQuiz game;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer1, shapeRenderer2, shapeRenderer3, shapeRenderer4, shapeRenderer5;

    public GameScreen(QuartaColoniaQuiz game) {
        this.game = game;
        batch = new SpriteBatch();
        Gdx.graphics.setWindowedMode(1365, 195);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1365, 195);

        shapeRenderer1 = new ShapeRenderer();
        shapeRenderer2 = new ShapeRenderer();
        shapeRenderer3 = new ShapeRenderer();
        shapeRenderer4 = new ShapeRenderer();
        shapeRenderer5 = new ShapeRenderer();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        shapeRenderer1.setProjectionMatrix(camera.combined);
        shapeRenderer2.setProjectionMatrix(camera.combined);
        shapeRenderer3.setProjectionMatrix(camera.combined);
        shapeRenderer4.setProjectionMatrix(camera.combined);
        shapeRenderer5.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.end();

        shapeRenderer1.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer1.setColor(Color.BLUE);
        shapeRenderer1.rect(0, 0, 195, 195);
        shapeRenderer1.end();

        shapeRenderer2.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer2.setColor(Color.RED);
        shapeRenderer2.rect(195, 0, 195, 195);
        shapeRenderer2.end();

        shapeRenderer3.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer3.setColor(Color.WHITE);
        shapeRenderer3.rect(390, 0, 195, 195);
        shapeRenderer3.end();

        shapeRenderer4.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer4.setColor(Color.DARK_GRAY);
        shapeRenderer4.rect(585, 0, 195, 195);
        shapeRenderer4.end();

        shapeRenderer5.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer5.setColor(Color.BLACK);
        shapeRenderer5.rect(780, 0, 195, 195);
        shapeRenderer5.end();
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

        shapeRenderer1.dispose();
        shapeRenderer2.dispose();
        shapeRenderer3.dispose();
        shapeRenderer4.dispose();
        shapeRenderer5.dispose();

    }
}