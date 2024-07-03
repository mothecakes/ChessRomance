package com.esqflowne.chessromance;

import com.badlogic.gdx.graphics.Texture;

public class Board {
    private int[][] tiles;
    private final int width = 8;
    private final int height = 8;
    private Texture boardTexture;

    public Board() {
        tiles = new int[width][height];
    }



}
