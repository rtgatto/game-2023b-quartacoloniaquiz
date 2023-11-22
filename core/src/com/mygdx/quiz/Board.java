package com.mygdx.quiz;

import com.badlogic.gdx.graphics.Texture;

public class Board {
    private Square[] squares;
    private Texture boardTexture;
    public Dice dice;

    public Board(Texture boardTexture) {

        this.boardTexture = boardTexture;
        squares = new Square[120];
        initializeBoard();

//        this.dice = new Dice();
    }

    private void initializeBoard() {
//        read the csv
        for (int i = 0; i < squares.length; i++) {
            squares[i] = new Square(i); // add the line of csv to Square
        }
    }

    public Texture getBoardTexture() {
        return boardTexture;
    }
}