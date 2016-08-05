import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle
{

	Panel panel;
	int xLocation;
	int yLocation;
	int paddleWidth;
	int paddleHeight;
	Color paddleColor;
	int score;

	public Paddle(Panel panel, int x, int y)
	{
		this.panel = panel;
		this.xLocation = x;
		this.yLocation = y;
		paddleWidth = 10;
		paddleHeight = 50;
		paddleColor = Color.WHITE;
		score = 0;
	}

	public void addScore()
	{
		score++;
	}

	public void setScore(int s)
	{
		score = s;
	}

	public int getScore()
	{
		return score;
	}

	public void setPaddleColor(Color c)
	{
		paddleColor = c;
	}

	public Rectangle getBounds()
	{
		return new Rectangle(xLocation,yLocation,paddleWidth,paddleHeight);
	}

	public void movePaddleUp()
	{
		if (yLocation > 0)
		yLocation = yLocation - 5;
	}

	public void movePaddleDown()
	{
		if (yLocation < (panel.getHeight()-paddleHeight))
		yLocation = yLocation + 5;
	}

	public void draw(Graphics g)
	{
		g.setColor(paddleColor);
		g.fillRect(xLocation,yLocation,paddleWidth,paddleHeight);

	}
}