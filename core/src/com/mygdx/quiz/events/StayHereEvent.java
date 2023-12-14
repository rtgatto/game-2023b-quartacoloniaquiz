package com.mygdx.quiz.events;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.quiz.Player;

public class StayHereEvent extends Event {

    public StayHereEvent() {
        super(0);
        super.defaultMessage = "Role o dado para avançar";
        super.texture = new Texture(Gdx.files.internal("img/stayherebg.jpg"));
    }

    @Override
    public String getMessage(Player player) {
        return defaultMessage;
    }

    @Override
    public void applyEvent(Player player) {

    }
}