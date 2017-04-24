/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;

//import TileMap.Background;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/**
 *
 * @author sadan
 */
public class MenuState extends GameState {

//	private Background bg;

	private int currentChoice = 0;
	private String[] options = {
		"Play",
		"Options",
		"Quit"
	};

	private Color titleColor;
	private Font titleFont;

	private Font font;

	public MenuState(GameStateManager gsm) {
		this.gsm = gsm;

		try {
//			bg = new Background("/res/menubg.gif", 1);
//			bg.setVector(-0.1, 0);

			titleColor = new Color(128, 0, 0);
			titleFont = new Font("Century Gothic", Font.PLAIN, 28);

			font = new Font("Arial", Font.PLAIN, 12);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
//		bg.update();
	}

	@Override
	public void draw(Graphics2D g) {
		//draw bg
//		bg.draw(g);

		//draw title
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("Pong", 70, 60);

		//draw menu options
		g.setFont(font);
		for (int i = 0; i < options.length; i++) {
			if (i == currentChoice) {
				g.setColor(Color.GRAY);
			} else {
				g.setColor(Color.WHITE);
			}
			g.drawString(options[i], 125, 140 + i * 15);
		}
	}

	private void select() {
		if (currentChoice == 0) {
//			gsm.setState(GameStateManager.LEVEL1STATE);
		}
		if (currentChoice == 1) {
//			gsm.setState(GameStateManager.LEVEL2STATE);
		}
		if (currentChoice == 2) {
			System.exit(0);
		}
	}

	@Override
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		if (k == KeyEvent.VK_ENTER) {
			select();
		}
		if (k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if (currentChoice == options.length) {
				currentChoice = 0;
			}
		}
		if (k == KeyEvent.VK_UP) {
			currentChoice--;
			if (currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		}
	}

	@Override
	public void keyReleased(int k) {
	}
}
