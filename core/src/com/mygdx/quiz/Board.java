package com.mygdx.quiz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.util.ArrayList;

public class Board {
    public Square[] squares;

    public Board() {
        squares = new Square[120];

        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < squares.length; i++) {
            squares[i] = new Square(i);
        }
    }
    protected Event getEventForSquare (int position){
        return squares[position].getEvent();
    }
}