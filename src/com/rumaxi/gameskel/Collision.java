package com.rumaxi.gameskel;

public class Collision {
    private Actor object;
    private Actor subject;
    private CollisionType type;

    public Collision(Actor object, Actor subject, CollisionType type) {
        this.object = object;
        this.subject = subject;
        this.type = type;
    }

    public Actor getObject() {
        return object;
    }

    public Actor getSubject() {
        return subject;
    }

    public CollisionType getType() {
        return type;
    }



}
enum CollisionType { COL_LEFT, COL_RIGHT, COL_TOP, COL_BOTTOM; }