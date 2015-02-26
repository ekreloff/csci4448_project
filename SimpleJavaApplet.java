import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SimpleJavaApplet extends JApplet implements MouseListener{
	GameBoard board;
	String status;
	
	public void init(){
		addMouseListener(this);
	}
	
	public void paint(Graphics g){
		board = new GameBoard();
		board.drawBoard(g);
		board.drawRedCheckers(g);
		board.drawBlackCheckers(g);
		g.clearRect(100, 400, 300, 150);
		g.drawString(status, 100, 450);
		//board.printCheckers();
	}
	
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseClicked(MouseEvent me){
		status = "Mouse button pressed at: x=" + me.getX() + " y=" + me.getY();
		repaint();
	}			
}
