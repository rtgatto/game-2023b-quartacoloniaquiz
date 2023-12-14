package com.mygdx.quiz.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.quiz.*;
import com.mygdx.quiz.events.Quiz;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.quiz.events.Event;

public class GameScreen implements Screen {

    QuartaColoniaQuiz game;
    private final OrthographicCamera camera;
    public MyRectangle[] rectangles;
    public Board board;
    public Player player;
    public Dice dice;
    public GameStatus gameStatus;
    public BitmapFont font;
    public Sounds sounds;
    private final Texture backgroundImage;
    private Texture bossimg;
    private Event currentEvent;
    public GameScreen(QuartaColoniaQuiz game) {
        this.game = game;

        board = new Board();
        player = new Player();
        dice = new Dice();
        gameStatus = GameStatus.PAUSED;
        font = new BitmapFont();
        font.getData().setScale(1.5f);
        sounds = new Sounds();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1365, 700);

        rectangles = new MyRectangle[7];

        int x = 0;
        for (int i = 0; i < 7; i++) {
            rectangles[i] = new MyRectangle(board.squares[i], x);
            x += 195;
        }
        backgroundImage = new Texture(Gdx.files.internal("img/dungeon.jpg"));

        bossimg = new Texture(Gdx.files.internal("img/bossfight.jpg"));
        currentEvent = null; // quando começa o jogo considera que nao há nenhum evento na tela
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
    
        game.batch.begin();
    
        if (gameStatus == GameStatus.GAME_OVER) {
           font.draw(game.batch, "Game Over!", 600, 350);
        } else {
            game.batch.draw(backgroundImage, 0, 0, 1365, 700);
            for (MyRectangle rectangle : rectangles) {
                game.batch.draw(rectangle.texture, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            }
    
            if (currentEvent != null) {
                if (currentEvent instanceof Quiz) {
                    Quiz quiz = (Quiz) currentEvent;
                    if (quiz.getFundo() != null) {
                        game.batch.draw(quiz.getFundo(), 0, 0, 1365, 700);
                    }
                }
            }
    
            game.batch.draw(player.getPlayerTexture(), (player.position.getCurrent() % 7) * 195, 505, 195, 195);
            font.draw(game.batch, "POSIÇÃO ATUAL: " + player.position.getCurrent(), 550, 200);
        }
    
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
        if (currentEvent != null && currentEvent instanceof Quiz) {
            // define a imagem de fundo do quiz
            bossimg = ((Quiz) currentEvent).getFundo();
        }
    }

    public void setCurrentEvent(Event event) {
        this.currentEvent = event;
    }

    public void gameOver() {
        gameStatus = GameStatus.GAME_OVER;
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