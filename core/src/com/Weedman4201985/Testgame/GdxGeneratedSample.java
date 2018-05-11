package com.Weedman4201985.Testgame;

import com.Weedman4201985.Testgame.utils.GdxUtils;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GdxGeneratedSample extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {

		GdxUtils.clearScreen();

		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
}
