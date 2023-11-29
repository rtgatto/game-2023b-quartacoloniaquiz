package com.mygdx.quiz.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.quiz.*;
import com.mygdx.quiz.Event;

import java.io.StringReader;

public class EventScreen implements Screen{
    public Event event;
    public SpriteBatch batch;
    public BitmapFont font;
    public Player player;
    public Board board;
    public GameScreen gameScreen;
    public OrthographicCamera camera;
    private boolean waitingInput;
    private boolean waitingTime;

    public EventScreen(Player player, Board board, GameScreen gameScreen, Square square){
        this.event = board.squares[player.position.getCurrent()].getEvent();;
        this.player = player;
        this.board = board;
        this.gameScreen = gameScreen;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, event.getTexture().getWidth(), event.getTexture().getWidth());
        batch = new SpriteBatch();
        font = new BitmapFont();
        waitingInput = false;
        waitingTime = true;
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(event.getTexture(), 0, 0, event.getTexture().getWidth(), event.getTexture().getHeight());

        if (event instanceof Quiz){
            Quiz quiz = (Quiz) event;
            int y = Gdx.graphics.getHeight() + 10;
            for (String option : quiz.getOptions()){
                font.draw(batch, option, 10, y);
                y += 10;
            }
        }
        else {
            font.draw(batch, event.getMessage(player), 10, Gdx.graphics.getHeight() + 10);
        }
        batch.end();

        moveSquares();

        finishEvent();
    }
    private void finishEvent(){
        gameScreen.resume();
        ScreenManager.setScreen(gameScreen);
    }

    private void moveSquares(){
        for (int i = 0; i < gameScreen.rectangles.length; i++){
            int pos = player.position.getCurrent()+i;

            if (pos < 120){
                gameScreen.rectangles[i].square = board.squares[pos];
            }
        }
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
        font.dispose();
        event.texture.dispose();
    }
}
