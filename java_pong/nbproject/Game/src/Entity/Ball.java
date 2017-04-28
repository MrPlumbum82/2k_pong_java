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
public class Ball  extends MapObject{
	public Ball(){

	}

	public void draw(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillOval((int) x, (int) y, 25, 25);
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
