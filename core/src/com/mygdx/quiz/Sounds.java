package com.mygdx.quiz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Sounds {
    public Sound diceSound;
    public Sound eventSound;
    public Sound moveSound;
    public Sound rightSound;
    public Sound wrongSound;

    public Sounds() {
        this.diceSound = Gdx.audio.newSound(Gdx.files.internal("sounds/dice.mp3"));
        this.eventSound = Gdx.audio.newSound(Gdx.files.internal("sounds/event.mp3"));
        this.moveSound = Gdx.audio.newSound(Gdx.files.internal("sounds/move.mp3"));
        this.rightSound = Gdx.audio.newSound(Gdx.files.internal("sounds/right.mp3"));
        this.wrongSound = Gdx.audio.newSound(Gdx.files.internal("sounds/wrong.mp3"));
    }
}