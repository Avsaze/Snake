import java.awt.Color;
import java.awt.Graphics;

public class Snake {//creating the class for the snake head
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
	public void paintMe(Graphics g) {//painting the snake
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
	}
	public int getX() {//getters and setters
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
