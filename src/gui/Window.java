package gui;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

/*
 * Class responsible to display the chessboard and register the mouse
 */
public class Window extends Applet implements Runnable {

	private static final long serialVersionUID = 8551786484748424017L;
	private static int FPS = 60;
	private static long lastUpdate = System.currentTimeMillis();
	private static long millisPerFrame = 1000 / FPS;
	private static long timeSinceLastUpdate;

	public static int windowWidth = 640;
	public static int windowHeight = 480;

	private Image image;
	private Graphics second;

	@Override
	public void init() {

		setSize(windowWidth, windowHeight);
		setBackground(Color.BLACK);
		setFocusable(true);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Snake");
	}

	@Override
	public void start() {
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {
		super.stop();
	}

	@Override
	public void destroy() {
		super.destroy();
	}
	
	@Override
	public void run() {
		while (true) {

			repaint();

			timeSinceLastUpdate = System.currentTimeMillis() - lastUpdate;
			if (timeSinceLastUpdate < millisPerFrame) {
				long timeToSlepp = millisPerFrame - timeSinceLastUpdate;
				try {
					Thread.sleep(timeToSlepp);
					//Thread.sleep(16);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			lastUpdate = System.currentTimeMillis();
		}
	}

}
