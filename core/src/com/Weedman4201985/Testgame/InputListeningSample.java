package com.Weedman4201985.Testgame;

import com.Weedman4201985.Testgame.utils.GdxUtils;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class InputListeningSample implements ApplicationListener, InputProcessor {



    private static final Logger log = new Logger(InputListeningSample.class.getName(), Logger.DEBUG);
    private static final int MAX_MESSAGE_COUNT = 15;

    private final Array<String> messages = new Array<String>();

    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private BitmapFont font;


    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        camera = new OrthographicCamera();
        viewport = new FitViewport(1080, 720, camera);
        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("fonts/oswald-32.fnt"));

        InputMultiplexer multiplexer = new InputMultiplexer();

        //if first processor method returns false then it will jump to second processor and so on depending on num of processor

        InputAdapter firstProcessor = new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                log.debug("first processor - keyDown keycode= " + keycode);
                return true;
            }

            @Override
            public boolean keyUp(int keycode) {
                log.debug("first processor - keyUp keycode= " + keycode);
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                log.debug("first processor - keyTyped character= " + character);
                return false;
            }

        };

        InputAdapter secondProcessor = new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                log.debug("second processor - keyDown keycode= " + keycode);
                return true;
            }

            @Override
            public boolean keyUp(int keycode) {
                log.debug("second processor - keyUp keycode= " + keycode);
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                log.debug("second processor - keyTyped character= " + character);
                return false;
            }

        };

        multiplexer.addProcessor(firstProcessor);
        multiplexer.addProcessor(secondProcessor);


        Gdx.input.setInputProcessor(multiplexer);


        //Gdx.input.setInputProcessor(this);


    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);

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
        for (int i = 0; i < messages.size; i++) {
            font.draw(batch, messages.get(i), 20.0f, 720 - 40.0f * (i + 1));
        }
    }

    private void addMessage(String message) {
        messages.add(message);

        if (messages.size > MAX_MESSAGE_COUNT) {
            messages.removeIndex(0);
        }
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

    @Override
    public boolean keyDown(int keycode) {
        String message = "keyDown() keycode= " + keycode;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        String message = "keyUp() keycode= " + keycode;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        String message = "keyTyped() keycode= " + character;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        String message = "touchDown() screenX= " + screenX + " screenY= " + screenY;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        String message = "touchUp() screenX= " + screenX + " screenY= " + screenY;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        String message = "touchDragged() screenX= " + screenX + " screenY= " + screenY;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        String message = "mouseMoved() screenX= " + screenX + " screenY= " + screenY;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        String message = "scrolled() amount= " + amount;
        log.debug(message);
        addMessage(message);
        return true;
    }
}
