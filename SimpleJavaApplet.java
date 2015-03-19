import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;



public class SimpleJavaApplet extends JApplet implements MouseListener{
	GameBoard board;
	LeaderBoard lboard;
	String status;
	JTextArea mouseCoordinates;
	JScrollPane sp;
	JFrame menu;
	JButton start, instructions, settings;
	
	public void init(){
		lboard = new LeaderBoard();
		board = new GameBoard();
		addMouseListener(this);
		this.mouseCoordinatesArea();
		this.createMenu();
	}
	
	
	public void paint(Graphics g){
		//lboard = new LeaderBoard();
		//board = new GameBoard();
		board.drawBoard(g);
		board.drawRedCheckers(g);
		board.drawBlackCheckers(g);
		board.printCheckers();
	}
	
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mousePressed(MouseEvent me){
		status = "Mouse button pressed at: x=" + me.getX() + " y=" + me.getY() + "\n";
		mouseCoordinates.append(status);
		//repaint();
	}
	public void mouseReleased(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
		
	public void mouseCoordinatesArea(){
		// Output mousePressed to text area with scroll bars at bottom of window
		setLayout(new BorderLayout());
		mouseCoordinates = new JTextArea(5, 5);
		sp = new JScrollPane(mouseCoordinates);
		add(sp, BorderLayout.SOUTH);
	}
	
	public void createMenu(){
		// Creates the menu pop-up frame
		menu = new JFrame("Menu");
		menu.setLayout(new GridLayout(3,1));
		menu.setLocation(200, 200);
		start = new JButton("Start");
		instructions = new JButton("Instructions");
		settings = new JButton("Settings");
		menu.add(start);
		menu.add(instructions);
		menu.add(settings);
		//menu.pack();
		menu.setSize(200, 200);
		menu.setVisible(true);
	}
}
