package com.mygdx.quiz.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class ScreenManager {
    private static Game game;

    public static void initialize(Game game){
        ScreenManager.game = game;
    }

    public static void setScreen(Screen screen){
        game.setScreen(screen);
    }
}
