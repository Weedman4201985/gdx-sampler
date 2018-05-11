package com.Weedman4201985.Testgame;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Logger;

public class GdxModuleInfoSample implements ApplicationListener {

	private static final Logger log = new Logger(ApplicationListenerSample.class.getName(),Logger.DEBUG);

	@Override
	public void create() {

		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		log.debug("App: " + Gdx.app);
		log.debug("Audio: " + Gdx.audio);
		log.debug("Files: " + Gdx.files);
		log.debug("Graphics: " + Gdx.graphics);
		log.debug("GL Version: " + Gdx.gl);
		log.debug("Input: " + Gdx.input);
		log.debug("Net: " + Gdx.net);

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}
}
