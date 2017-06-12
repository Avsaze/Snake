import java.awt.Color;
import java.awt.Graphics;

public class Snake {
	int x;
	int y;
	int width = 10;
	int height = 10;
	int speed;
	public Snake (int newx, int newy, int newspeed) {
		x = newx;
		y = newy;
		speed = newspeed;
		
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
}
