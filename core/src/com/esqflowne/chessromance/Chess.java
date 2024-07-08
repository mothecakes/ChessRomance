package com.esqflowne.chessromance;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Chess extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Render renderer;
	Board board;
	MyInputProcessor inputProcessor;

	@Override
	public void create () {
		renderer = Render.getRenderInstance();
		board = Board.getBoardInstance();
		inputProcessor = new MyInputProcessor();
		Gdx.input.setInputProcessor(inputProcessor);
	}

	@Override
	public void render () {
		renderer.renderAll();
	}
	
	@Override
	public void dispose () {
		renderer.clean();
	}
}
