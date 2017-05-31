import java.awt.Color;
import java.awt.Graphics;

public class Snake {
	int x = 0;
	int y = 0;
	int width = 10;
	int height = 10;
	int length;
	int xspeed;
	int yspeed;
	public Snake (int newx, int newy, int newxspeed, int newyspeed) {
		x = newx;
		y = newy;
		xspeed = newxspeed;
		yspeed = newyspeed;
	}
	public void paintMe(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}