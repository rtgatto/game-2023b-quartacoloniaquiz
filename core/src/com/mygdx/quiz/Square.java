package com.mygdx.quiz;

public class Square {
    private int number;
    private Event event;

    public Square() {
        this.number = -1;
        this.event = null;
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