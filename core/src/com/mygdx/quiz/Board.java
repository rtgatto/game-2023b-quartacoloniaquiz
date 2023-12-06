package com.mygdx.quiz;

import com.mygdx.quiz.events.Event;
import com.mygdx.quiz.events.Quiz;

public class Board {
    public Square[] squares;

    public Board() {
        squares = new Square[120];

        initializeBoard();
    }

    private void initializeBoard() {
        squares[0] = new Square(0);

        Quiz quiz = new Quiz();

        for (int i = 1; i < squares.length; i++) {
            squares[i] = new Square(i, quiz);
        }
    }

    protected Event getEventForSquare(int position) {
        return squares[position].getEvent();
    }
}