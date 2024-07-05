package com.esqflowne.chessromance;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Board {
    private Piece[][] tiles;
    private final int width = 8;
    private final int height = 8;
    private Texture boardTexture;

    public Board() {
        tiles = new Piece[width][height];
    }

    public void generateBoard() {
        // generates the board in its default position;
        generateBlack();
        generateWhite();

    }

    private void generateBlack() {
        // generate pawns
        for(int i = 1; i <= width; i++)  {

        }

    }
    private void generateWhite() {

    }




}
