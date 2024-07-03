package com.esqflowne.chessromance;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Chess extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Render renderer;
	
	@Override
	public void create () {
		renderer = new Render();
	}

	@Override
	public void render () {
		renderer.renderGUI();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		renderer.clean();
	}
}
