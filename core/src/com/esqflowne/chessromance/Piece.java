package com.esqflowne.chessromance;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.List;

import java.util.ArrayList;

abstract class Piece {
    public Unit unit;
    public Vector2 position;
    public Side side;
    public boolean alive;
    public boolean dragged;
    public ArrayList<Vector2> movableTiles;
    public ArrayList<Vector2> takeableTiles;

    private static Board board = null;

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
        this.unit = unit;
        this.position = position;
        this.side = side;

        movableTiles = new ArrayList<Vector2>();
        takeableTiles = new ArrayList<Vector2>();

        if (board == null) board = Board.getBoardInstance();
    }


    public abstract void move(Vector2 target);

    // responsible for detecting movable and takable tiles
    public abstract void detectTile();

    public abstract void detectMoveable();
    public abstract void detectTakeable();

    public boolean checkTile(Vector2 pos) {
        for (Piece piece: board.getAllPieces()) {
            if (piece.position.equals(pos)) return false;
        }
        return true;
    }

    public void die() {
        alive = false;
    }

}
