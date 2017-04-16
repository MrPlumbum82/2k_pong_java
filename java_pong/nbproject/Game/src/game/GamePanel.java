/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author primary
 */
public class GamePanel extends JPanel implements Runnable {

	// constants 
	private static final long ONE_SECOND = 1000000000; //10^9 nanoseconds in a second

	// dimensions
	public static final int WIDTH = 320;
	public static final int HEIGHT = 240;
	public static final int SCALE = 3;

	// game thread
	private Thread thread;

	private boolean running;
	private int frameCounter;

	private Color titleColor;
	private Font titleFont;

	private int FPS = 60;
//	private long targetTime = 1000 / FPS;
	// image
	private BufferedImage image;
	private Graphics2D g;

	// game state manager
//	private GameStateManager gsm;
	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		this.setFocusable(true);
		this.requestFocusInWindow();
	}

	@Override
	public void addNotify() {
		System.out.println("addNotify was just called");

		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
//			addKeyListener(this);
			thread.start();
		}
	}

	@Override
	public void run() {
		System.out.println("run method called");

		init();

		long start;
		long elapsed = 0;
		long wait;

		while (running) {

			start = System.nanoTime();

			drawToScreen();

			elapsed += System.nanoTime() - start;

			// Calculating FPS
			if (elapsed >= ONE_SECOND) {
				System.out.println("FPS=" + frameCounter);
//				drawFPS();
				frameCounter = 0;
				elapsed = 0;
			}
//			System.out.println(elapsed + "                   " + frameCounter);
		}

//		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	private void init() {
		frameCounter = 0;
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.createGraphics();
		running = true;

		titleColor = new Color(128, 0, 0);
		titleFont = new Font("Century Gothic", Font.PLAIN, 28);

//		gsm = new GameStateManager();
	}

	private void update() {
//		gsm.update();
	}

	private void draw() {
//		gsm.draw(g);
	}

	private void drawToScreen() {
		frameCounter++;
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		g2.dispose();
	}

	private void drawFPS(){

		// draw fps counter
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString(Integer.toString(frameCounter), 70, 60);

	}
}
