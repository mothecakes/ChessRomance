package com.esqflowne.chessromance;

import com.badlogic.gdx.math.Vector2;

public class Pawn extends Piece {
    public Pawn(Vector2 pos, Side side) {
        super(Unit.PAWN, pos, side);


    }

    public void move(Vector2 target) {
        detectTile();
        if (movableTiles.contains(target)) {
            System.out.println("Going from " + position + " to " + target);
            position = target;
        }
        if (takeableTiles.contains(target)) {
            System.out.println("Going from " + position + " to " + target);
            position = target;
        }
        takeableTiles.clear();
        movableTiles.clear();
    }

    public void die() {

    }

    public void detectTile() {
        detectMoveable();
        detectTakeable();
    }

    public void  detectMoveable() {
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

    public void detectTakeable() {
        if (this.side == Side.WHITE) {
            int targetY = (int)position.y + 1;
            int targetLeftX = (int)position.x - 1;
            int targetRightX = (int)position.x + 1;

            if (MyMath.inRange(targetY,0,7) && (MyMath.inRange(targetLeftX,0,7) ||
                MyMath.inRange(targetRightX,0,7)) ) {
                Vector2 leftCheck = null;
                Vector2 rightCheck = null;
                if (targetLeftX >= 0) {
                    leftCheck = new Vector2(targetLeftX, targetY);
                    if (!checkTile(leftCheck)) {
                        takeableTiles.add(leftCheck);
                    }
                }
                if (targetRightX <= 7) {
                    rightCheck = new Vector2(targetRightX, targetY);
                    if (!checkTile(rightCheck)) {
                        takeableTiles.add(rightCheck);
                    }
                }
            }
        }
    }
}
