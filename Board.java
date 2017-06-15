import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Board implements ActionListener, Runnable{ //creating all of the global variables
	static JFrame frame = new JFrame("Snake!");
	Playarea playarea = new Playarea();
	Container south = new Container();
	JButton Easy = new JButton("Easy");
	JButton Medium = new JButton("Medium");
	JButton Hard = new JButton("Hard");
	JLabel scorel = new JLabel("Score: " + playarea.Score);
	final int undecided =0;
	final int easy = 1;
	final int med = 2;
	final int hard = 3;
	int dif = undecided;
	boolean running = false;
	
	
	public Board(){ //creating the board layout
		frame.setSize(500,500);
		frame.setLayout(new BorderLayout());
		frame.add(playarea, BorderLayout.CENTER);
		frame.add(south, BorderLayout.SOUTH);
		south.setLayout(new GridLayout());
		south.add(Easy);
		Easy.addActionListener(this);
		south.add(Medium);
		Medium.addActionListener(this);
		south.add(Hard); 
		Hard.addActionListener(this);
		frame.add(scorel, BorderLayout.NORTH);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Snake snake = new Snake((int)(10*(Math.round((Math.random()* 400))/10)),(int)(10*(Math.round((Math.random()* 400)/10))),10);
		Food food = new Food((int)(10*(Math.round((Math.random()* 400))/10)),(int)(10*(Math.round((Math.random()* 400)/10))));
		playarea.addsnake(snake);
		playarea.addfood(food);
		frame.repaint();
		
	}

	public static void main(String[] args) {
		new Board();

	}

	public void actionPerformed(ActionEvent e) {//when you chose the difficulty start playing the game
		if(e.getSource().equals(Easy)){//using easy difficulty
			dif = easy;
			Easy.setEnabled(false);
			Medium.setEnabled(false);
			Hard.setEnabled(false);
			if (running == false) {
				running = true;
				Thread t = new Thread(this);
				t.start();
			}
		}
		if(e.getSource().equals(Medium)){//using medium difficulty
			dif = med;
			Easy.setEnabled(false);
			Medium.setEnabled(false);
			Hard.setEnabled(false);
			if (running == false) {
				running = true;
				Thread t = new Thread(this);
				t.start();
			}
		}
		if(e.getSource().equals(Hard)){//using hard difficulty
			dif = hard;
			Easy.setEnabled(false);
			Medium.setEnabled(false);
			Hard.setEnabled(false);
			if (running == false) {
				running = true;
				Thread t = new Thread(this);
				t.start();
			}
		}
	}
	public void run() {//start running
		while(running == true){
			playarea.step();//call the play area and the step method
			scorel.setText(playarea.getScore());
			frame.repaint();
			try{
			if (dif == easy) {
				Thread.sleep(75);
				}
				else if (dif == med) {
					Thread.sleep(50);
				}
				else if (dif == hard) {
					Thread.sleep(25);
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
}
