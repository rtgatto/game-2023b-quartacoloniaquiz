package com.mygdx.quiz;

public class Position {
    protected int current;
    protected int previous;

    public Position() {
        this.current = 0;
        this.previous = 0;
    }

    public void setPositions(int previous, int current) {
        this.current = current;
        this.previous = previous;
    }

    public int getCurrent() {
        return this.current;
    }

    public int getPrevius() {
        return this.previous;
    }
}