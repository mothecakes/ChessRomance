package com.esqflowne.chessromance;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Render {
    // Render serves as our render manager
    private Texture banner;
    private Texture board;
    private SpriteBatch batch;

    public Render() {
        LoadGUI();
    }

    public void renderGUI() {
        ScreenUtils.clear(1, 0, 0, 1);
        batch.begin();
        batch.draw(banner, 600, 0);
        batch.draw(board, 0, 0, 600, 600, 0, 0,
                512, 512, false, false);
        batch.end();
    }

    public void clean() {
        batch.dispose();
        banner.dispose();
        board.dispose();
    }

    private void LoadGUI() {
        //LoadGUI
        //LoadBoard
        //LoadEntities
        batch = new SpriteBatch();
        banner = new Texture("tempGUI.png");
        board = new Texture("board.png");
    }




}
