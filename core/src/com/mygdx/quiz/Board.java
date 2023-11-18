package com.mygdx.quiz;

public class Board {
    private Square[] squares;

    public Board() {
        squares = new Square[120];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < squares.length; i++) {
            squares[i] = new Square(i);
        }
    }

    public Event getEventForSquare(int squareIndex) {
        // 20% chance of an event happening
        double randomEvent = Math.random();
        if (randomEvent < 0.2) {
            // Within the event, 33% chance for each type (Quiz, Plus, Minus)
            double randomType = Math.random();
            if (randomType < 0.33) {
                return new Event(0); // Quiz Event
            } else if (randomType < 0.66) {
                return new Event(1); // Plus Event
            } else {
                return new Event(2); // Minus Event
            }
        }
        return null; // No Event
    }
}