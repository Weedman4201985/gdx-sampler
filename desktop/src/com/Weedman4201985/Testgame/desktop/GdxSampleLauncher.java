package com.Weedman4201985.Testgame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglAWTCanvas;

import javax.swing.*;
import java.awt.*;

public class GdxSampleLauncher extends JFrame {

    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;

    //AWT = Abstract Window Toolkit
    private LwjglAWTCanvas canvas;

    public GdxSampleLauncher() throws HeadlessException {
        setTitle(GdxSampleLauncher.class.getSimpleName());
        setMinimumSize(new Dimension(WIDTH,HEIGHT));
        setSize(WIDTH,HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //tell window (JFrame) to resize and layout components

        pack();
        setVisible(true);
    }

}
