package com.mygdx.quiz.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.quiz.*;

public class GameScreen implements Screen {

    QuartaColoniaQuiz game;
    private OrthographicCamera camera;
    public MyRectangle[] rectangles;
    public Board board;
    public Player player;
    public Dice dice;
    public GameStatus gameStatus;
    public BitmapFont font;
    public Sounds sounds;
    public GameScreen(QuartaColoniaQuiz game) {
        this.game = game;

        board = new Board();
        player = new Player();
        dice = new Dice();
        gameStatus = GameStatus.PAUSED;
        font = new BitmapFont();
        sounds = new Sounds();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1365, 700);

        rectangles = new MyRectangle[7];

        int x = 0;
        for (int i = 0; i < 7; i++) {
            rectangles[i] = new MyRectangle(board.squares[i], x);
            x += 195;
        }
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(245, 255, 0, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        for (MyRectangle rectangle : rectangles) {
            game.batch.draw(rectangle.texture, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
        game.batch.draw(player.getPlayerTexture(), (player.position.getCurrent() % 7) * 195, 505, 195, 195);
        game.batch.end();

        if (Gdx.input.justTouched()) {
            playing();
        }
    }

    public void playing() {
        sounds.diceSound.play(1.0f);
        int diceValue = dice.roll();
        player.move(diceValue+player.position.getCurrent());
        sounds.moveSound.play(1.0f);

        if (player.checkWin()) {
            ScreenManager.setScreen(new VictoryScreen());
        }
        else {
            ScreenManager.setScreen(new EventScreen(player, board, this));
        }
    }

    private void moveSquares() {
        for (int i = 0; i < rectangles.length; i++) {
            int pos = player.position.getCurrent() + i;

            if (pos < 120) {
                rectangles[i].square = board.squares[pos];
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
        sounds.diceSound.dispose();
        sounds.eventSound.dispose();
        sounds.moveSound.dispose();
        sounds.rightSound.dispose();
        sounds.wrongSound.dispose();
        game.batch.dispose();
        for (int i = 0; i < 7; i++) {
            rectangles[i].texture.dispose();
        }
        font.dispose();
    }
}