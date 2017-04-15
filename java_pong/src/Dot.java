import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Dot
{

	double startX;
	double startY;
	double x;
	double y;
	double width;
	double height;
	int dotYVelocity;
	int dotXVelocity;
	Color dotColor;
	Panel panel;

	public Dot(Panel p, double x, double y, double width, double height)
	{
		this.panel = p;
		this.startX = x;
		this.startY = y;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		dotColor = Color.WHITE;

		dotYVelocity = 2; //pixels per interval of time
		dotXVelocity = 2; //pixels per interval of time
	}

	public double getStartY()
	{
		return startY;
	}

	public double getStartX()
	{
		return startX;
	}

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public double getWidth()
	{
		return width;
	}

	public double getHeight()
	{
		return height;
	}

	public int getDotXVelocity()
	{
		return dotXVelocity;
	}

	public int getDotYVelocity()
	{
		return dotYVelocity;
	}

	public void setStartX(int x)
	{
		startX = x;
	}

	public void setStartY(int y)
	{
		startY = y;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public void setDotXVelocity(int x)
	{
		dotXVelocity = x;
	}

	public void setDotYVelocity(int y)
	{
		dotYVelocity = y;
	}

	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,(int)width,(int)height);
	}

	public void draw(Graphics2D g)
	{
		g.setColor(dotColor);
		Ellipse2D.Double dot = new Ellipse2D.Double(x,y,width,height);
		g.fill(dot);
	}
}