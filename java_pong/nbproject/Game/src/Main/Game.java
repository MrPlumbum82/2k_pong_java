/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author primary
 */
public class Game {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		JFrame window = new JFrame();
		GamePanel pong = new GamePanel();

		window.add(pong);
		window.setTitle("Pong");
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
	}
}
