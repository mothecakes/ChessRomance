package com.esqflowne.chessromance;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Board {
    private final int width = 8;
    private final int height = 8;
    private Piece[] whitePieces = null;
    private Piece[] blackPieces = null;
    private Piece[] allPieces = null;
    private Piece[] deadPieces;

    private Piece.Side turn = Piece.Side.WHITE;

    private static Board boardInstance = null;


    public static Board getBoardInstance() {
        if (boardInstance == null) {
            boardInstance = new Board();
        }
        return boardInstance;
    }

    public Piece[] getAllPieces() {
        if (allPieces == null) {
            System.out.println("all piece getter called\n");
            int count = 0;
            allPieces = new Piece[32];
            if (whitePieces == null) generateWhite();
            for (Piece white: whitePieces) {
                allPieces[count] = white;
                count++;
            }
            if (blackPieces == null) generateBlack();
            for (Piece black: blackPieces) {
                allPieces[count] = black;
                count++;
            }
        }
        return allPieces;
    }


    private Board() {
        deadPieces = new Piece[32];
    }

    private void generateBlack() {
        // generate pawns
        // offsets are determined based on white being on bottom
        if(blackPieces == null)
        {
            blackPieces = new Piece[16];

            final int offsetY = 6;
            final int offsetX = 0;

            int count = 0;
            for (int j = 0; j < 2; j++) {
                for(int i = 0; i < width; i++)  {
                    blackPieces[count] = new Pawn(new Vector2(offsetX + i,offsetY + j), Piece.Side.BLACK);
                    count++;
                }
            }
            for (Piece piece: blackPieces) {
                System.out.println("Black pawn created (" + piece.position.x + ", " + piece.position.y +
                        ")" + '\n');
            }

        }

    }
    private void generateWhite() {
        // generate pawns
        if (whitePieces == null) {
            whitePieces = new Piece[16];
        }
        final int offsetY = 0;
        final int offsetX = 0;

        int count = 0;
        for (int j = 0; j < 2; j++) {
            for(int i = 0; i < width; i++)  {
                whitePieces[count] = new Pawn(new Vector2(offsetX + i,offsetY + j), Piece.Side.WHITE);
                count++;
            }
        }
        for (Piece piece: whitePieces) {
            System.out.println("White pawn created (" + piece.position.x + ", " + piece.position.y +
                    ")" + '\n');
        }

    }

    // turn manager logic

    public void setTurn() {
        if (turn == Piece.Side.WHITE) turn = Piece.Side.BLACK;
        else if (turn == Piece.Side.BLACK) turn = Piece.Side.WHITE;
    }

    public Piece.Side getTurn() {
        return turn;
    }






}
