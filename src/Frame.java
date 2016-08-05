import javax.swing.JFrame;

public class Frame extends JFrame
{
	Panel game;
	
	public Frame()
	{
		game = new Panel();
		add(game);

		pack();
		setTitle("Pong");
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		java.awt.EventQueue.invokeLater(
			new Runnable()
			{
				public void run()
				{
					new Frame();
				}
			}
		);
	}
}
