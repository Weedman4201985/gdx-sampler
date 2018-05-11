package com.Weedman4201985.Testgame.desktop;

import com.Weedman4201985.Testgame.GdxModuleInfoSample;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncherGdxModuleInfoSample {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new GdxModuleInfoSample(), config);
	}
}
