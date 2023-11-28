package com.mygdx.quiz.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.quiz.QcqGame;
import com.mygdx.quiz.QuartaColoniaQuiz;

public class GameScreen implements Screen {

    QuartaColoniaQuiz game;
    QcqGame qcqGame;
    private OrthographicCamera camera;
    public MyRectangle[] rectangles;

    public GameScreen(QuartaColoniaQuiz game) {
        this.game = game;
        Gdx.graphics.setWindowedMode(1365, 195); // 1365, 195

        qcqGame = new QcqGame();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1365, 195);

        rectangles = new MyRectangle[7];

        int x = 0;
        for (int i = 0; i < 7; i++){
            rectangles[i] = new MyRectangle(qcqGame.board.squares[i], x);
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
        game.batch.draw(qcqGame.player.getPlayerTexture(), rectangles[qcqGame.player.position.getCurrent() * 195].x, rectangles[0].y, rectangles[0].width, rectangles[0].height);
        game.batch.end();

        qcqGame.playing();
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
    }
}