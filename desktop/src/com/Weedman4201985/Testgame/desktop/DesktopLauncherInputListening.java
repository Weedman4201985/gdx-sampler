package com.Weedman4201985.Testgame.desktop;


import com.Weedman4201985.Testgame.InputListeningSample;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncherInputListening {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new InputListeningSample(), config);
    }
}
