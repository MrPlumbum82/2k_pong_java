/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;

//import TileMap.Background;
//import TileMap.TileMap;
//import Main.GamePanel;
import Entity.*;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/**
 *
 * @author sadan
 */
public class PlayState extends GameState {

//	private TileMap tileMap;
//	private Background bg;
	private Paddle paddle;
	private Ball ball;

	public PlayState(GameStateManager gsm) {
//		this.gsm = gsm;
		init();

	}

	@Override
	public void init() {

//		tileMap = new TileMap(30);
//		tileMap.loadTiles("/res/grasstileset.gif");
//		tileMap.loadMap("/res/level1-1.map");
//		tileMap.setPosition(0, 0);
//		bg = new Background("/res/grassbg1.gif", 0.1);
//		player = new Player(tileMap);
//		player.setPosition(100, 100);
		paddle = new Paddle();
		paddle.setPosition(100, 100);
		ball = new Ball();
		ball.setPosition(15, 15);
	}

	@Override
	public void update() {
		//update player
		paddle.update();
		ball.update();
//		tileMap.setPosition(GamePanel.WIDTH / 2 - player.getx(), GamePanel.HEIGHT / 2 - player.gety());
	}

	@Override
	public void draw(Graphics2D g) {

		// draw background
//		bg.draw(g);
		// draw tilemap
//		tileMap.draw(g);
		// draw player
		paddle.draw(g);
		ball.draw(g);
	}

	@Override
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		if (k == KeyEvent.VK_LEFT) {
			paddle.setLeft(true);
		}
		if (k == KeyEvent.VK_RIGHT) {
			paddle.setRight(true);
		}
		if (k == KeyEvent.VK_UP) {
			paddle.setUp(true);
		}
		if (k == KeyEvent.VK_DOWN) {
			paddle.setDown(true);
		}
		if (k == KeyEvent.VK_W) {
//			player.setJumping(true);
		}
		if (k == KeyEvent.VK_E) {
//			player.setGliding(true);
		}
		if (k == KeyEvent.VK_R) {
//			player.setScratching();
		}
		if (k == KeyEvent.VK_F) {
//			player.setFiring();
		}
	}

	@Override
	public void keyReleased(int k) {
		if (k == KeyEvent.VK_LEFT) {
			paddle.setLeft(false);
		}
		if (k == KeyEvent.VK_RIGHT) {
			paddle.setRight(false);
		}
		if (k == KeyEvent.VK_UP) {
			paddle.setUp(false);
		}
		if (k == KeyEvent.VK_DOWN) {
			paddle.setDown(false);
		}
		if (k == KeyEvent.VK_W) {
//			player.setJumping(false);
		}
		if (k == KeyEvent.VK_E) {
//			player.setGliding(false);
		}
		if (k == KeyEvent.VK_R) {
//			player.setScratching();
		}
		if (k == KeyEvent.VK_F) {
//			player.setFiring();
		}
	}
}
