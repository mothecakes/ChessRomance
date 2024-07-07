package com.esqflowne.chessromance;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Chess extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Render renderer;
	Board board;
	
	@Override
	public void create () {
		renderer = new Render();
		board = Board.getBoardInstance();
	}

	@Override
	public void render () {
		renderer.renderGUI();
	}
	
	@Override
	public void dispose () {
		renderer.clean();
	}
}
