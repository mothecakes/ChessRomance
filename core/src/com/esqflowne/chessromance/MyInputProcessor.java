package com.esqflowne.chessromance;


import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

import static com.esqflowne.chessromance.Board.getBoardInstance;

public class MyInputProcessor implements InputProcessor {

    Render render = Render.getRenderInstance();
    Board board = Board.getBoardInstance();

    @Override
    public boolean keyDown(int i) {
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        // record placement of touch
        Vector2 pos = findTile(i, i1);
        Piece unit = findUnit(pos);
        if (pos == null) {
            return false;
        }
        if (unit != null) {
            if (unit.side == board.getTurn()) {
                System.out.println("unit side" + unit.side);
                System.out.println("turn side" + board.getTurn());
                unit.dragged = true;
            }
        }
        render.setMousePosition(i, i1);

        // if is in bounds of unit
        // // turn drag flag on that unit
        return false;
    }

    @Override
    public boolean touchUp(int x, int y, int i2, int i3) {
        // if drag flag on, and new tile,
        for (Piece piece : board.getAllPieces()) {
            if (piece.dragged) {
                Vector2 target = findTile(x,y);
                if (!target.equals(piece.position)) {
                    piece.move(target);
                    render.resetMousePosition();
                    piece.dragged = false;
                }
            }
        }
        // // convert mouse position to board position
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        // if any unit has drag flag on
        for (Piece piece : board.getAllPieces()) {
            if (piece.dragged) {
                render.setMousePosition(i, i1);
            }
        }
        // // render position to mouse coordinate instead of original
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }

    private Vector2 findTile(int x, int y) {
        final int tileSize = 600/8;
        x = MyMath.getRange(x, 0, 600-64);
        y = MyMath.getRange(y, 0, 600-64);
        if (x <= 600) {
            x = (x/tileSize);
            y = 7 - (y/tileSize);
            System.out.println("x: " + x + ' ' + "y: " + y + '\n');
            return new Vector2(x,y);
        }
        else
            return null;

    }

    private Piece findUnit(Vector2 pos) {
        for (Piece piece : board.getAllPieces()) {
            if (piece.position.equals(pos)) {
                if (!piece.movableTiles.isEmpty()) {
                    System.out.println("this unit can move forward" + '\n');
                }
                return piece;
            }
        }
        return null;
    }
}
