import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Playarea extends JPanel implements KeyListener{
	ArrayList<Snake> snakes = new ArrayList<Snake>();
	ArrayList<Food> foodz = new ArrayList<Food>();
	public Playarea(){
		super();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	public void addsnake(Snake s){
		snakes.add(s);
	}
	public void addfood(Food f){
		foodz.add(f);
	}
	public void paintComponent(Graphics g){
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
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_W) {
			
		}
		else if (key == KeyEvent.VK_A) {
			
		}
		else if (key == KeyEvent.VK_S) {
			
		}
		else if (key == KeyEvent.VK_D) {
			
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {		
	}
	public void step(){
		for (int a = 0; a < snakes.size(); a++) {
			Snake s = snakes.get(a);
			if(collision){
				//do something
					}
				}
			}
			else{
				//move
		}
	}
}
