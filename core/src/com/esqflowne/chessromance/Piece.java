package com.esqflowne.chessromance;

import com.badlogic.gdx.math.Vector2;

abstract class Piece {
    enum Side {
        Black,
        White
    }
    enum Unit {
        Pawn,
        Knight,
        Bishop,
        Rook,
        Queen,
        King
    }

    public Piece(Unit unit, Vector2 position, Side side) {
        this.unit = unit;
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
