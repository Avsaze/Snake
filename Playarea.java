import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Playarea extends JPanel{
	ArrayList<Snake> snakes = new ArrayList<Snake>();
	ArrayList<Food> foodz = new ArrayList<Food>();
	public Playarea(){
		super();
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
}
