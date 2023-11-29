package com.mygdx.quiz.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
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


    public GameScreen(QuartaColoniaQuiz game) {
        this.game = game;

        board = new Board();
        player = new Player();
        dice = new Dice();
        gameStatus = GameStatus.EM_EXECUCAO;

        Gdx.graphics.setWindowedMode(1365, 195);

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

        if (gameStatus == GameStatus.EM_EXECUCAO){
            int diceValue = dice.roll();
            player.move(diceValue);

            gameStatus = GameStatus.PAUSADO;
        }
        else {
            if (player.checkWin()){
                Gdx.app.exit();
            }
            ScreenManager.setScreen(new EventScreen(player, board, this, board.squares[player.position.getCurrent()]));

            gameStatus = GameStatus.EM_EXECUCAO;
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
    }
}