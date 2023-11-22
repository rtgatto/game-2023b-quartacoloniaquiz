package com.mygdx.quiz.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.quiz.Event;
import com.mygdx.quiz.QuartaColoniaQuiz;

public class GameScreen implements Screen {

    final QuartaColoniaQuiz game;
    private Event event;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Texture texture;
    private ShapeRenderer shapeRenderer;
    private Sprite sprite;


    public GameScreen(QuartaColoniaQuiz game){
        this.game = game;
        batch = new SpriteBatch();
        Gdx.graphics.setWindowedMode(1250, 250); // W: 1370
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 549);
        texture = new Texture(Gdx.files.internal("mapa.png"));
        shapeRenderer = new ShapeRenderer();
        sprite = new Sprite(texture);
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
        sprite.draw(batch);
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
