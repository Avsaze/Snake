import java.awt.Color;
import java.awt.Graphics;

public class Food {
	int x;
	int y;
	int width = 10;
	int height = 10;
	public Food(int newx, int newy) {
		x = newx;
		y = newy;
	}
	public void paintMe(Graphics g) {
		g.setColor(Color.RED);
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
