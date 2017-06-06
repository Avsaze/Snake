import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Playarea extends JPanel implements KeyListener {
	ArrayList<Snake> snakes = new ArrayList<Snake>();
	ArrayList<Food> foodz = new ArrayList<Food>();
	boolean left = false;
	boolean right = false;
	boolean up = false;
	boolean down = false;

	public Playarea() {
		super();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	public void addsnake(Snake s) {
		snakes.add(s);
	}

	public void addfood(Food f) {
		foodz.add(f);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		for (int a = 0; a < snakes.size(); a++) {
			snakes.get(a).paintMe(g);
		}
		for (int a = 0; a < foodz.size(); a++) {
			foodz.get(a).paintMe(g);
		}
	}

	public void step(){
		for (int a = 0; a < snakes.size(); a++) {
			Snake s = snakes.get(a);
			if((snakes.get(0).getX() <= 0)||
					(snakes.get(0).getX() >= getWidth())||
					(snakes.get(0).getY() <= 0)||
					(snakes.get(0).getY() >= getHeight())){
					
					}
			else if (collision with self) {
				
			}
			else {
					if (up == true) {
						snakes.get(a).setY(snakes.get(a).getY() + snakes.get(a).getSpeed());
					}
					else if (down == true) {
						snakes.get(a).setY(snakes.get(a).getY() - snakes.get(a).getSpeed());
					}
						else if (right == true) {
							snakes.get(a).setX(snakes.get(a).getX() + snakes.get(a).getSpeed());
						}
						else if (left == true) {
							snakes.get(a).setX(snakes.get(a).getX() - snakes.get(a).getSpeed());
					
						}
					}
				}
		}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_W) {
			up = true;
			left = false;
			down = false;
			right = false;
		} else if (key == KeyEvent.VK_A) {
			up = false;
			left = true;
			down = false;
			right = false;
		} else if (key == KeyEvent.VK_S) {
			up = false;
			left = false;
			down = true;
			right = false;
		} else if (key == KeyEvent.VK_D) {
			up = false;
			left = false;
			down = false;
			right = true;
		}

	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}
}
