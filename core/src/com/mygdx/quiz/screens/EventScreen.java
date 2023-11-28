package com.mygdx.quiz.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.quiz.*;
import com.mygdx.quiz.Event;

public class EventScreen implements Screen {
    public Event event;
    public SpriteBatch batch;
    public BitmapFont font;
    public Player player;
    public Board board;
    public Screen screen;
    private boolean waitingInput = false;
    private boolean waitingTime = true;

    public EventScreen(Player player, Board board, Screen screen){
        this.event = board.squares[player.position.getCurrent()].getEvent();;
        this.player = player;
        this.board = board;
        this.screen = screen;
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            public boolean touchDown(int key){
                if (waitingInput){
                    if (event instanceof Quiz){
                        if (!((Quiz) event).isOptionCorrect(key)){
                            player.position.returnSquares();
                        }
                    }
                    waitingInput = false;
                }
                return true;
            }
        });

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                waitingTime = false;
                waitingInput = true;
            }
        }, 4);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(event.texture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        if (event instanceof Quiz){
            Quiz quiz = (Quiz) event;
            int y = Gdx.graphics.getHeight() - 10;
            for (String option : quiz.getOptions()){
                font.draw(batch, option, 10, y);
                y -= 10;
            }
        }
        else {
            font.draw(batch, event.getMessage(player), 10, Gdx.graphics.getHeight() - 10);
        }
        batch.end();

        if (event instanceof Quiz){
            if (waitingInput){
//                fazer a movimentação das squares nos rectangles
            }
        }
        else {
            if (waitingTime){
//                fazer a movimentação das squares nos rectangles
            }
        }

        finishEvent();
    }
    private void finishEvent(){
        ScreenManager.setScreen(screen);
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

    }
}
