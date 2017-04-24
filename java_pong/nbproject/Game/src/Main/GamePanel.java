/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

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
	public static final int SCALE = 1;

	// game thread
	private Thread thread;

	private boolean running;
	private int frameCounter;

	private Color titleColor;
	private Font titleFont;

	private int FPS = 30;
	private long targetTime = 1000 / FPS;
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
		init();

		long start;
		long elapsed;
		long elapsed_sum = 0;
		long wait;

		while (running) {
			
			start = System.nanoTime();

			drawToScreen();

			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;

			if (wait <= 0){
				wait = 0;
			}

			try{
				thread.sleep(wait);
			} catch(Exception e){
				e.printStackTrace();
			}

			elapsed = System.nanoTime() - start;
			elapsed_sum += elapsed;
			// Calculating FPS
			if (elapsed_sum >= ONE_SECOND) {
				System.out.println("FPS=" + frameCounter);
				frameCounter = 0;
				elapsed_sum = 0;
			}
		}
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
}
