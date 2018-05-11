package com.Weedman4201985.Testgame;

import com.Weedman4201985.Testgame.utils.GdxUtils;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

@SuppressWarnings("unused")
public class InputPollingSample implements ApplicationListener {

	private static final Logger log = new Logger(ApplicationListenerSample.class.getName(),Logger.DEBUG);
	private OrthographicCamera camera;
	private Viewport viewport;
	private SpriteBatch batch;
	private BitmapFont font;


	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		camera = new OrthographicCamera();
		viewport = new FitViewport(1080,720,camera);
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("fonts/oswald-32.fnt"));
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width,height,true);

	}

	@Override
	public void render() {
		//clear screen
		GdxUtils.clearScreen();

        batch.setProjectionMatrix(camera.combined);

		// all drawing code for game appears between batch.begin and batch.end
		batch.begin();

		draw();

		batch.end();

	}

	private void draw() {
		//mouse / touch x/y
		int mouseX = Gdx.input.getX();
		int mouseY = Gdx.input.getY();

		//buttons
		boolean leftPressed = Gdx.input.isButtonPressed(Input.Buttons.LEFT);
		boolean rightPressed = Gdx.input.isButtonPressed(Input.Buttons.RIGHT);

		font.draw(batch,"Mouse/Touch : x= " + mouseX + " Y= " + mouseY,20f,720-20f);
		font.draw(batch,leftPressed ? "Left button pressed " : "Left button not pressed",20f,720-50f);
		font.draw(batch,rightPressed ? "Right button pressed " : "Right button not pressed",20f,720-80f);

		//keys
		boolean wPressed = Gdx.input.isKeyPressed(Input.Keys.W);
		boolean sPressed = Gdx.input.isKeyPressed(Input.Keys.S);

		font.draw(batch,wPressed ? "W button pressed " : "W button not pressed",20f,720-110f);
		font.draw(batch,sPressed ? "S button pressed " : "S button not pressed",20f,720-140f);
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}
