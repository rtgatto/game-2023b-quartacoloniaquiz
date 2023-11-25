package com.mygdx.quiz;

import java.io.IOException;
import java.util.ArrayList;
import com.opencsv.exceptions.CsvException;

public class Square {
    private int number;
    public Event event;
    public ArrayList<Quiz> quizzes;

    public Square(int i){
        this.number = i;
        this.quizzes = readQuiz();
        this.event = createEvent(quizzes);
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

    public Event createEvent(ArrayList<Quiz> quizzes){
        double randomEvent = Math.random();
        // 20% chance of an event happening
        if (randomEvent < 0.2) {
            // Within the event, 33% chance for each type (Quiz, Plus, Minus)
            double randomType = Math.random();
            if (randomType < 0.33) {
                Quiz quiz = quizzes.get(0);
                quizzes.remove(0);
                return quiz;
            }
            else if (randomType < 0.66) {
                return new PlusEvent();
            }
            else {
                return new MinusEvent();
            }
        }
        return null;
    }
    public void setEvent(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public int getEventType() {
        if (event != null) {
            return event.getType();
        }
        return 0; // Default value for no event
    }
}