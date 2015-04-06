import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

//Suppress warning about implementing serializable interface
@SuppressWarnings("serial")


public class Controller extends JApplet/* implements MouseListener*/{
  private GameBoard board;
  private GameScene nongenericscene;


  public void init(){
		board = new GameBoard();
		//addMouseListener(this);
  }

  public void paint(Graphics g){
    nongenericscene.draw(g);
  }

  /*
  //TESTING THE MODEL HERE FOR NOW
  public static void main(String[] args){
    Player test1 = new Player();
    Player test2 = new Player();
    Gameboard test3 = new Gameboard(test1, test2);
  }*/


}
