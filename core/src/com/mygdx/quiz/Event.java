package com.mygdx.quiz;

public class Event {
    private int type; // 0: No Event, 1: Quiz, 2: Plus, 3: Minus, for a random generator to generate
                      // events for squares

    public Event(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}