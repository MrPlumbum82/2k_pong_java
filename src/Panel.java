import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.lang.Integer;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class Panel extends JPanel implements KeyListener, ActionListener
{
	int panelWidth = 500;
	int panelHeight = 500;
	int paddleOffset = 10;
	Paddle player1,player2;
	Dot dot;

	public Panel()
	{
		player1 = new Paddle(this,10,200);
		player2 = new Paddle(this,480,200);
		dot = new Dot(this,(double)((panelWidth/2) - 5),(double)((panelHeight/2) - 5),(double)10,(double)10);
		Timer t = new Timer(10, this);
		t.start();

		setPreferredSize(new Dimension(panelWidth,panelHeight));
		setBackground(Color.BLACK);
		addKeyListener(this);
		setFocusable(true);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        this.drawDottedLine(g2d);
		this.drawScore(g2d);
		player1.draw(g2d);
		player2.draw(g2d);
		dot.draw(g2d);
	}

	public void actionPerformed(ActionEvent e)
	{
		this.checkIntersection();
		this.moveDot();
		repaint();
	}

	public void keyPressed(KeyEvent e)
	{
		int code = e.getKeyCode();
		switch (code)
		{
			case KeyEvent.VK_W:
				player1.movePaddleUp();
				repaint();
				break;
			case KeyEvent.VK_S:
				player1.movePaddleDown();
				repaint();
				break;
			case KeyEvent.VK_UP:
				player2.movePaddleUp();
				repaint();
				break;
			case KeyEvent.VK_DOWN:
				player2.movePaddleDown();
				repaint();
				break;
		}
	}

	public void keyReleased(KeyEvent e)
	{

	}

	public void keyTyped(KeyEvent e)
	{

	}

	private void drawScore(Graphics2D g)
	{
		g.setColor(Color.WHITE);
		g.drawString(Integer.toString(player1.getScore()), 150, 50);
		g.setColor(Color.WHITE);
		g.drawString(Integer.toString(player2.getScore()), 350, 50);
	}

	private void drawDottedLine(Graphics2D g)
	{
		g.setColor(Color.WHITE);
		float dash[] = {10.0f};
		g.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_BUTT,
        BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
		g.drawLine((this.getWidth()/2), 0, (this.getWidth()/2) , this.getHeight());
	}

	private void checkIntersection()
	{
		if(player1.getBounds().intersects(dot.getBounds()))
		{
			int x = dot.getDotXVelocity();
			x *= -1;
			dot.setDotXVelocity(x);
		}
		if(player2.getBounds().intersects(dot.getBounds()))
		{
			int x = dot.getDotXVelocity();
			x *= -1;
			dot.setDotXVelocity(x);
		}
	}

	private void moveDot()
	{
		if ((dot.getY()+dot.getHeight())>this.getHeight() || dot.getY() < 0)
		{	
			int yv = dot.getDotYVelocity();
			yv *= -1;
			dot.setDotYVelocity(yv);
		}

		if ((dot.getX()+dot.getWidth())>this.getWidth() || dot.getX() < 0)
		{
			if (dot.getX() < 0)
				player1.addScore();
			if ((dot.getX()+dot.getWidth())>this.getWidth())
				player2.addScore();
			dot.setX((int)dot.getStartX());
			dot.setY((int)dot.getStartY());
			int xv = dot.getDotXVelocity();
			xv *= -1;
			dot.setDotXVelocity(xv);
		}
		
		int y = (int)dot.getY();
		y += dot.getDotYVelocity();
		dot.setY(y);
		int x = (int)dot.getX();
		x += dot.getDotXVelocity();
		dot.setX(x);
	}
}
