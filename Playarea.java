import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Playarea extends JPanel implements KeyListener {
	ArrayList<Snake> snakes = new ArrayList<Snake>();
	ArrayList<Food> foodz = new ArrayList<Food>();
	ArrayList<Body> body = new ArrayList<Body>();
	boolean left = false;
	boolean right = false;
	boolean up = false;
	boolean down = false;
	int score = 0;
	String Score = Integer.toString(score);

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
	public void addBody(Body b) {
		body.add(b);
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
		for (int i = 0; i < body.size(); i++) {
			body.get(i).paintMe(g);
		}
	}

	public void step() {
		for (int a = 0; a < snakes.size(); a++) {
			Snake s = snakes.get(a);
			Food f = foodz.get(a);
			Body b = null;
			if (s.getX() == f.getX() && s.getY() == f.getY()) {
				Food food = new Food((int)(10*(Math.round((Math.random()* getWidth())/10))),(int)(10*(Math.round((Math.random()* getHeight())/10))));
				if (body.isEmpty() == true) {
					System.out.println("array list is null");
					if (up == true) {
						b = new Body(s.getX(),s.getY()+s.getSpeed());
					}
					else if (down == true) {
						b = new Body(s.getX(),s.getY()-s.getSpeed());
					}
					else if (left == true) {
						b = new Body(s.getX()+s.getSpeed(),s.getY());
					}
					else if (right == true) {
						b = new Body(s.getX()-s.getSpeed(),s.getY());
					}
				}
				else {
					if (up == true) {
						b = new Body(body.get(body.size()-1).getX(),body.get(body.size()-1).getY() + s.getSpeed());
					}
					else if (down == true) {
						b = new Body(body.get(body.size()-1).getX(),body.get(body.size()-1).getY() - s.getSpeed());
					}
					else if (right == false) {
						b = new Body(body.get(body.size()-1).getX() + s.getSpeed(),body.get(body.size()-1).getY());
					}
					else if (left == false) {
						b = new Body(body.get(body.size()-1).getX() - s.getSpeed(),body.get(body.size()-1).getY());
					}
					body.add(b);
				}
				foodz.remove(a);
				foodz.add(food);
				body.add(b);
				score = score + 3;
				Score = Integer.toString(score);
				System.out.println("collsion man");
			}
			if ((s.getX() <= -10) || (s.getX() >= getWidth()-5) || (s.getY() <= -10) || (s.getY() >= getHeight()+10)) {
				System.out.println("game over man");
			}
			// else if (collision with self) {

			// }
			else {
				Body u = null;
				if (up == true) {
					s.setY(s.getY() - s.getSpeed());
					if (body.isEmpty() == false) {
						for (int i = 1; i < body.size(); i++) {
							u = body.get(i);
							u.setX(body.get(i-1).getX());
							u.setY(body.get(i-1).getY());
						}
						u = body.get(0);
						u.setX(s.getX());
						u.setY(s.getY()+s.getSpeed());
						
					}
				} 
				else if (down == true) {
					s.setY(s.getY() + s.getSpeed());
					if (body.isEmpty() == false) {
						for (int i = 1; i < body.size(); i++) {
							u = body.get(i);
							u.setX(body.get(i-1).getX());
							u.setY(body.get(i-1).getY());
						}
						u = body.get(0);
						u.setX(s.getX());
						u.setY(s.getY()-s.getSpeed());						
					}
				} 
				else if (right == true) {
					s.setX(s.getX() + s.getSpeed());
					if (body.isEmpty() == false) {
						for (int i = 1; i < body.size(); i++) {
							u = body.get(i);
							u.setX(body.get(i-1).getX());
							u.setY(body.get(i-1).getY());
						}
						u = body.get(0);
						u.setX(s.getX() - s.getSpeed());
						u.setY(s.getY());
					}
				} 
				else if (left == true) {
					s.setX(s.getX() - s.getSpeed());
					if (body.isEmpty() == false) {
						for (int i = 1; i < body.size(); i++) {
							u = body.get(i);
							u.setX(body.get(i-1).getX());
							u.setY(body.get(i-1).getY());
						}
						u = body.get(0);
						u.setX(s.getX() + s.getSpeed());
						u.setY(s.getY());
					}
				}
			}
		}
	}

	public String getScore() {
		return Score;
	}

	public void setScore(String score) {
		Score = score;
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
