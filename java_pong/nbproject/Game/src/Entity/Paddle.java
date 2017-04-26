/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author sadan
 */
public class Paddle extends MapObject {

	public Paddle() {

	}

	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 320, 240);

		g.setColor(Color.WHITE);
		g.fillRect((int) x, (int) y, 50, 100);
	}

	public void update() {
		if (left) {
			x -= 5;
		} if (right) {
			x += 5;
		} if (up) {
			y -= 5;
		} if (down) {
			y += 5;
		}
	}
}
