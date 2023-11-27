package com.mygdx.quiz;

import com.badlogic.gdx.graphics.Texture;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.util.ArrayList;

public class Board {
    public Square[] squares;
    private Texture boardTexture;

    public Board() {
        squares = new Square[120];
//        this.boardTexture = boardTexture;

        initializeBoard();
    }

    private void initializeBoard() {
        squares[0] = new Square(0);

        ArrayList<Quiz> quizzes = readQuiz();

        for (int i = 1; i < squares.length; i++) {
            squares[i] = new Square(i, quizzes); // add the line of csv to Square
        }
    }

    protected Event getEventForSquare(int position) {
        return squares[position].getEvent();
    }

    private ArrayList<Quiz> readQuiz() {
        ArrayList<Quiz> quizzes;

        try {
            quizzes = QuizReader.readQuizzesFromCSV();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }

        return quizzes;
    }
}