package com.mygdx.quiz.events;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.quiz.Player;

public class StayHereEvent extends Event {

    public StayHereEvent() {
        super(0);
        super.defaultMessage = "Stay here and roll your dice.";
        super.texture = new Texture(Gdx.files.internal("img/null.png"));
    }

    @Override
    public String getMessage(Player player) {
        return defaultMessage;
    }

    @Override
    public void applyEvent(Player player) {

    }
}