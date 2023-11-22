package com.mygdx.quiz;

public class Square {
    private int number;
    public Event event;

    public Square(int i) {
        this.number = i;
        this.event = null;
    }

    public Event createEvent(){
        // 20% chance of an event happening
        double randomEvent = Math.random();
        if (randomEvent < 0.2) {
            // Within the event, 33% chance for each type (Quiz, Plus, Minus)
            double randomType = Math.random();
            if (randomType < 0.33) {
//                return new Quiz(question, options, correctOptionIndex, boardTexture);
            } else if (randomType < 0.66) {
                return new PlusEvent();
            } else {
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