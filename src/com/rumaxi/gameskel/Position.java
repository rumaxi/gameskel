package com.rumaxi.gameskel;

public class Position {
    int x,y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Position() {
        x=0; y=0;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}