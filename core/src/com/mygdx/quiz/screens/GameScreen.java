package com.mygdx.quiz.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.quiz.*;

import java.util.Scanner;

public class GameScreen implements Screen {

    QuartaColoniaQuiz game;
    private OrthographicCamera camera;
    public MyRectangle[] rectangles;
    public Board board;
    public Player player;
    public Dice dice;
    public GameStatus gameStatus;
    public BitmapFont font;


    public GameScreen(QuartaColoniaQuiz game) {
        this.game = game;

        board = new Board();
        player = new Player();
        dice = new Dice();
        gameStatus = GameStatus.RUNNING;
        font = new BitmapFont();


        Gdx.graphics.setWindowedMode(1365, 700);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1365, 195);

        rectangles = new MyRectangle[7];

        int x = 0;
        for (int i = 0; i < 7; i++){
            rectangles[i] = new MyRectangle(board.squares[i], x);
            x += 195;
        }
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(245,255,250, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        for (MyRectangle rectangle : rectangles){
            game.batch.draw(rectangle.texture, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
        game.batch.draw(player.getPlayerTexture(), player.position.getCurrent()*195, 0, 195, 195);
        game.batch.end();

        playing();
    }
    public void playing(){
        if (gameStatus == GameStatus.RUNNING){
            int diceValue = dice.roll();
            player.move(diceValue);
            gameStatus = GameStatus.PAUSED;

            if (player.checkWin()){
                Gdx.app.exit();
            }
        }
        else {
//            ScreenManager.setScreen(new EventScreen(player, board, this, board.squares[player.position.getCurrent()]));
            Event event = board.squares[player.position.getCurrent()].event;

            SpriteBatch spriteBatch = new SpriteBatch();
            spriteBatch.begin();
            spriteBatch.draw(event.getTexture(), 0, 0, event.getTexture().getWidth(), event.getTexture().getHeight());

            if (event instanceof Quiz){
                Quiz quiz = (Quiz) event;
                System.out.print(quiz.getQuestion());

//                int y = Gdx.graphics.getHeight() + 30;
//                font.draw(spriteBatch, quiz.getQuestion(), 10, 10);

                for (String option : quiz.getOptions()){
//                    font.draw(spriteBatch, option, 10, y);
//                    y += 10;
                    System.out.print(option);
                }
//                int numberDown = getNumberDown();

                Scanner scanner = new Scanner(System.in);
                int userInput;
                do {
                    System.out.println("\nDigite um número (1-5): ");
                    userInput = scanner.nextInt();
                } while (userInput < 1 || userInput > 5);

                System.out.println(userInput + "============================================");
                scanner.close();

                quiz.isOptionCorrect(userInput, player);
//                gameStatus = GameStatus.RUNNING;
            }
            else {
                System.out.print(event.getMessage(player));
                if (Gdx.input.isKeyPressed(Input.Keys.ENTER)){
                    gameStatus = GameStatus.RUNNING;
                }
            }
            spriteBatch.end();
            moveSquares();
        }
    }

    private void moveSquares(){
        for (int i = 0; i < rectangles.length; i++){
            int pos = player.position.getCurrent()+i;

            if (pos < 120){
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
        game.batch.dispose();
        for (int i = 0; i < 120; i++){
            board.squares[i].event.texture.dispose();
        }
        for (int i = 0; i < 7; i++){
            rectangles[i].texture.dispose();
        }
        font.dispose();
    }
}