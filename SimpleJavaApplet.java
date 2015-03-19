import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;



public class SimpleJavaApplet extends JApplet implements MouseListener, ActionListener{
	GameBoard board;
	LeaderBoard lboard;
	String status;
	JTextArea mouseCoordinates;
	JScrollPane sp;
	JFrame menu;
	JButton start, instructions, settings, leaderBoardB;
	
	public void init(){
		//lboard = new LeaderBoard();
		board = new GameBoard();
		addMouseListener(this);
		this.mouseCoordinatesArea();
		this.createMenu();
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
		//repaint();
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

	/* Detect button presses */
	public void actionPerformed(ActionEvent ae){
		Object obj = ae.getSource();
		if(obj == leaderBoardB){
			lboard = new LeaderBoard();
		}
	}
	
	/* Creates the pop-up menu */
	public void createMenu(){
		menu = new JFrame("Menu");
		menu.setLayout(new GridLayout(3,1));
		menu.setLocation(200, 200);

		leaderBoardB = new JButton("Leaderboard");
		leaderBoardB.addActionListener(this);

		start = new JButton("Start");
		instructions = new JButton("Instructions");
		settings = new JButton("Settings");

		menu.add(leaderBoardB);
		menu.add(start);
		menu.add(instructions);
		menu.add(settings);
		
		menu.setSize(200, 200);
		menu.setVisible(true);
	}
}
