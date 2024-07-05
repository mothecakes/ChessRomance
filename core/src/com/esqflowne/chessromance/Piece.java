package com.esqflowne.chessromance;

import com.badlogic.gdx.math.Vector2;

abstract class Piece {
    enum Side {
        BLACK,
        WHITE
    }
    enum Unit {
        PAWN,
        KNIGHT,
        BISHOP,
        ROOK,
        QUEEN,
        KING
    }

    public Piece(Unit unit, Vector2 position, Side side) {
        // constructor will place the unit respective to their own side
        this.unit = unit;
        // TODO make method that is called to convert position from relative to absolute
        this.position = position;
        this.side = side;
    }

    public Unit unit;
    public Vector2 position;
    public Side side;
    public boolean alive;

    public abstract void move(Vector2 target);

    public void die() {
        alive = false;
    }


}
