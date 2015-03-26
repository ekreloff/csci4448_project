import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;



public class SimpleJavaApplet extends JApplet implements MouseListener{
	GameBoard board;
	MainMenu mainMenu;
	String status;
	JTextArea mouseCoordinates;
	JScrollPane sp;
	JFrame menu;
	JButton start, instructions, settings, leaderBoardB;
	
	public void init(){
		board = new GameBoard();
		mainMenu = MainMenu.getInstance();
		addMouseListener(this);
		this.mouseCoordinatesArea();
	}
	
	
	public void paint(Graphics g){
		board.drawBoard(g);
		board.drawRedCheckers(g);
		board.drawBlackCheckers(g);
		board.printCheckers();
	}
	
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}

	/* Outputs the mouse coordinates the the mouse texarea */
	public void mousePressed(MouseEvent me){
		status = "Mouse button pressed at: x=" + me.getX() + " y=" + me.getY() + "\n";
		mouseCoordinates.append(status);
		repaint();
	}
	public void mouseReleased(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	
	/* Creates the text area that shows the mouse coordinates */	
	public void mouseCoordinatesArea(){
		setLayout(new BorderLayout());
		mouseCoordinates = new JTextArea(5, 5);
		sp = new JScrollPane(mouseCoordinates);
		add(sp, BorderLayout.SOUTH);
	}
}
