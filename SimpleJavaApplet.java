//import java.applet.*;
import java.awt.*;
import javax.swing.*;

public class SimpleJavaApplet extends JApplet{
	GameBoard board;
	
	public void paint(Graphics g){
		board = new GameBoard();
		board.createBoard(g);
	}
}
