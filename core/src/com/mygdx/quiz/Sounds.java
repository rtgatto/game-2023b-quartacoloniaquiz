package com.mygdx.quiz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Sounds {
    private Sound diceSound;
    private Sound eventSound;
    private Sound moveSound;
    private Sound rightSound;
    private Sound wrongSound;

    public Sounds() {
        this.diceSound = Gdx.audio.newSound(Gdx.files.internal("sounds/dice.wav"));
        this.eventSound = Gdx.audio.newSound(Gdx.files.internal("sounds/event.wav"));
        this.moveSound = Gdx.audio.newSound(Gdx.files.internal("sounds/move.mp3"));
        this.rightSound = Gdx.audio.newSound(Gdx.files.internal("sounds/right.mp3"));
        this.wrongSound = Gdx.audio.newSound(Gdx.files.internal("sounds/wrong.mp3"));
    }
}