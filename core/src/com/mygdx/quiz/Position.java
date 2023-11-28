package com.mygdx.quiz;

public class Position{
    protected int current;
    protected int previus;

    public Position(){
        this.current = 0;
        this.previus = 0;
    }

    public void setPositions(int current, int previus){
        this.current = current;
        this.previus = previus;
    }

    public int getCurrent(){
        return this.current;
    }

    public int getPrevius(){
        return this.previus;
    }

    public void returnSquares(){
        this.current = this.getPrevius();
    }
}