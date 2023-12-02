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

    public EventScreen(Player player, Board board, GameScreen gameScreen){
        this.event = board.squares[player.position.getCurrent()].getEvent();
        this.player = player;
        this.board = board;
        this.gameScreen = gameScreen;
        batch = new SpriteBatch();
        font = new BitmapFont();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1365, 700);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(100, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        if (event instanceof Quiz){
//            sounds.eventSound.play(1.0f);

            Quiz quiz = (Quiz) event;
            font.draw(batch, quiz.getQuestion(), 10, 100);
            int y = Gdx.graphics.getHeight() + 10;
            for (String option : quiz.getOptions()){
                font.draw(batch, option, 10, y);
                y += 10;
            }

//            if (quiz.isOptionCorrect1(userInput)) {
//                sounds.rightSound.play(1.0f);
//                gameStatus = GameStatus.RUNNING;
//            } else {
//                sounds.wrongSound.play(1.0f);
//                gameStatus = GameStatus.RUNNING;
        }
        else {
            font.draw(batch, event.getMessage(player), 10, Gdx.graphics.getHeight() + 100);
        }
        batch.end();

        if (Gdx.input.isTouched()){
            finish();
        }

    }
    private void finish(){
        ScreenManager.setScreen(gameScreen);
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
    }
}
