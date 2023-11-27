package com.mygdx.quiz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class StayHereEvent extends Event{

    public StayHereEvent(){
        super(0);
        super.defaultMessage = "Stay here.";
        super.texture = new Texture(Gdx.files.internal("img/null.png"));
    }

    @Override
    public String getMessage(Player player) {
        return null;
    }

    @Override
    protected int calculateActualSquaresToJump(Player player) {
        return 0;
    }

    @Override
    public void applyEvent(Player player) {

    }
}
