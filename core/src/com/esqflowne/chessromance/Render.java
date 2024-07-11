package com.esqflowne.chessromance;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class Render {
    // Render serves as our render manager
    private static Render instance = null;

    private Texture banner;
    private Texture boardTexture;
    private Texture pawn;

    private SpriteBatch batch;

    private Board boardData = null;

    public boolean drag;

    private Vector2 mousePosition = null;

    public static Render getRenderInstance() {
        if (instance == null)
            instance = new Render();
        return instance;
    }

    private Render() {
        loadGUI();
        boardData = Board.getBoardInstance();
    }

    public void renderAll() {
        batch.begin();
        renderGUI();
        renderPieces(boardData.getAllPieces());
        batch.end();
    }

    private void renderGUI() {
        ScreenUtils.clear(1, 0, 0, 1);
        batch.draw(banner, 600, 0);
        batch.draw(boardTexture, 0, 0, 600, 600, 0, 0,
                512, 512, false, false);
    }

    public void clean() {
        batch.dispose();
        banner.dispose();
        boardTexture.dispose();
        pawn.dispose();
    }

    public void setMousePosition(int x, int y) {
        mousePosition = new Vector2(x, 600 - y);
    }

    public void resetMousePosition() {
        mousePosition = Vector2.Zero;
    }

    private void loadGUI() {
        //LoadGUI
        //LoadBoard
        //LoadEntities
        batch = new SpriteBatch();
        banner = new Texture("GUI/banner.png");
        boardTexture = new Texture("board.png");
        pawn = new Texture("units/plants-1.png");
    }

    private void renderPieces(Piece[] pieces) {
        // TODO implement dragging logic
        // if holding down on region
        // // make the unit follow along the cursor from the center
        // if user lets go of cursor while holding unit
        // // round down screen coordinate
        // // update piece position

        final int tileSize = 600/8;
        final int tileOffset = tileSize/2;
        for (Piece piece : pieces) {
            //batch.draw()
            if (piece.dragged && piece.alive) {
                if (piece.side == Piece.Side.WHITE) {
                    if (piece.unit == Piece.Unit.PAWN)
                        batch.draw(pawn, mousePosition.x - tileOffset, mousePosition.y - tileOffset, tileSize, tileSize,
                                0, 0, 64, 64, false, false);

                    if (piece.unit == Piece.Unit.BISHOP)
                        batch.draw(pawn, mousePosition.x - tileOffset, mousePosition.y - tileOffset, tileSize, tileSize,
                                128, 0, 64, 64, false, false);
                }
                if (piece.side == Piece.Side.BLACK) {
                    if (piece.unit == Piece.Unit.PAWN)
                        batch.draw(pawn, mousePosition.x - tileOffset, mousePosition.y - tileOffset, tileSize, tileSize,
                                64, 0, 64, 64, false, false);

                    if (piece.unit == Piece.Unit.BISHOP)
                        batch.draw(pawn, mousePosition.x - tileOffset, mousePosition.y - tileOffset, tileSize, tileSize,
                                192, 0, 64, 64, false, false);

                }
            }
            else if (piece.alive){
                if (piece.side == Piece.Side.WHITE) {
                    if (piece.unit == Piece.Unit.PAWN)
                        batch.draw(pawn, tileSize * piece.position.x, tileSize * piece.position.y, tileSize, tileSize,
                                0, 0, 64, 64, false, false);

                    if (piece.unit == Piece.Unit.BISHOP)
                        batch.draw(pawn, tileSize * piece.position.x, tileSize * piece.position.y, tileSize, tileSize,
                                128, 0, 64, 64, false, false);
                }
                if (piece.side == Piece.Side.BLACK) {
                    if (piece.unit == Piece.Unit.PAWN)
                        batch.draw(pawn, tileSize * piece.position.x, tileSize * piece.position.y, tileSize, tileSize,
                                64, 0, 64, 64, false, false);

                    if (piece.unit == Piece.Unit.BISHOP)
                        batch.draw(pawn, tileSize * piece.position.x, tileSize * piece.position.y, tileSize, tileSize,
                                192, 0, 64, 64, false, false);

                }
            }
        }
    }






}
