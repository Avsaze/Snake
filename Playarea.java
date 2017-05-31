import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Playarea extends JPanel{
	public Playarea(){
		super();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

	}
}
