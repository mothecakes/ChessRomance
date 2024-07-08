package com.esqflowne.chessromance;

import com.badlogic.gdx.math.Vector2;

public class Pawn extends Piece {
    public Pawn(Vector2 pos, Side side) {
        super(Unit.PAWN, pos, side);


    }

    public void move(Vector2 target) {
        detectTile();
        if (movableTiles.contains(target))
            position = target;
        movableTiles.clear();
    }

    public void die() {

    }

    public void detectTile() {
        detectMoveable();
    }

    private void  detectMoveable() {
        if (this.side == Side.WHITE) {
            int targetY = MyMath.getRange((int) (position.y + 1), 0, 7);
            Vector2 coord = new Vector2(position.x, targetY);

            if (checkTile(coord)) {
                movableTiles.add(coord);
            }
        }
        if (this.side == Side.BLACK) {
            int targetY = MyMath.getRange((int) (position.y - 1), 0, 7);
            Vector2 coord = new Vector2(position.x, targetY);

            if (checkTile(coord)) {
                movableTiles.add(coord);
            }
        }
    }

    private void detectTakeable() {
        if (this.side == Side.WHITE) {
            int targetY = (int)position.y + 1;
            int targetX = (int)position.x + 1;
            int targetX2 = (int)position.x - 1;
            
            if (MyMath.inRange(targetY,0,7) && (MyMath.inRange(targetX,0,7) ||
                MyMath.inRange(targetX2,0,7)) ) {
                    Vector2 coord = new Vector2(position.x, targetY);

                    if (checkTile(coord)) {
                        movableTiles.add(coord);
                    }

            }


        }

    }
}
