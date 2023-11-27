package com.mygdx.quiz.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.quiz.Square;

public class MyRectangle extends Rectangle {
    public Square square;
    public Texture texture;

    public MyRectangle(Square square, int _x){
        this.square = square;
        this.texture = square.getTexture();

        x = _x;
        y = 0;
        width = 195;
        height = 195;
    }

}
