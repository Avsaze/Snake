import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel{
	JFrame frame = new JFrame("Snake!");
	Playarea playarea = new Playarea();
	Container south = new Container();
	JButton Easy = new JButton("Easy");
	JButton Medium = new JButton("Medium");
	JButton Hard = new JButton("Hard");
	
	public Board(){
		frame.setSize(1000,1000);
		frame.setLayout(new BorderLayout());
		frame.add(playarea, BorderLayout.CENTER);
		frame.add(south, BorderLayout.SOUTH);
		south.setLayout(new GridLayout());
		south.add(Easy);
		south.add(Medium);
		south.add(Hard);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.repaint();
		
	}

	public static void main(String[] args) {
		new Board();

	}

}
