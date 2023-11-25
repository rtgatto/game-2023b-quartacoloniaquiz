package com.mygdx.quiz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.util.ArrayList;

public class Board {
    private Square[] squares;
    public QuizReader reader;
    public ArrayList<Quiz> quizes;

    public Board(Texture boardTexture) throws IOException, CsvException {
        squares = new Square[120];

        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < squares.length; i++) {
            squares[i] = new Square(i, quizes); // add the line of csv to Square
        }
    }
}