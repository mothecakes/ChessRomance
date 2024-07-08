package com.esqflowne.chessromance;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Board {
    private Piece[][] tiles;
    private final int width = 8;
    private final int height = 8;
    private Texture boardTexture;
    private Piece[] whitePieces;
    private Piece[] blackPieces;
    private Piece[] allPieces = null;

    private static Board boardInstance = null;

    public static Board getBoardInstance() {
        if (boardInstance == null) {
            boardInstance = new Board();
        }
        return boardInstance;
    }

    public Piece[] getAllPieces() {
        if (allPieces == null) {
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

    public void generateBoard() {
        // generates the board in its default position;
        whitePieces = new Piece[16];
        blackPieces = new Piece[16];

        generateBlack();
        generateWhite();

    }


    private Board() {
        tiles = new Piece[width][height];
        generateBoard();
    }

    private void generateBlack() {
        // generate pawns
        // offsets are determined based on white being on bottom
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
    private void generateWhite() {
        // generate pawns
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




}
