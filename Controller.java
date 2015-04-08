import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

//imports needed?

//Suppress warning about implementing serializable interface
@SuppressWarnings("serial")


public class Controller extends JApplet implements MouseListener, MouseMotionListener{
  private GameBoard board;
  private Scene currentScene;
  private String mouseMovedCoordinates = "";
  private String eventType = "None";


  public void init(){
    Player player1 = new HumanPlayer();
    Player player2 = new HumanPlayer(); // TODO: These need to be input taken from the main menu on which types of players are playing the game.
    player1.selectedColor = Color.red;
    player2.selectedColor = Color.black; // TODO: These need to be chosen at the setup screen for the game.
    board = new GameBoard(player1, player2);

    currentScene = new GameScene(); // GameScene to start.

		addMouseListener(this); //Controller handles Mouse events.
    addMouseMotionListener(this); //Controller handles continuous Mouse events.
  }

  public void paint(Graphics g){
    int boardWidth = GameBoard.size*8; //Width of board
    int boardHeight = GameBoard.size*8; //Height of board

    //What type of Mouse Event just happened and what to do in response
    switch(eventType){
      case "MouseMoved":
      {
        g.clearRect(0, boardHeight, boardWidth, GameBoard.size*2); //clear just the bottom text. Its x2 just to make sure it gets all of it.
        break;
      }
    }
    g.drawString(mouseMovedCoordinates, 0, boardHeight + GameBoard.size); //Draw mouse coordinate string to bottom of screen.

    currentScene.draw(g); // whatever scene has been loaded call its draw method.
  }


  //Methods required to implement Mouse Listener interfaces
  public void mouseEntered(MouseEvent me){}
  public void mouseExited(MouseEvent me){}
  public void mousePressed(MouseEvent me){}
  public void mouseReleased(MouseEvent me){
    repaint();
  }
  public void mouseClicked(MouseEvent me){}
  public void mouseMoved(MouseEvent me){
    eventType = "MouseMoved";
    mouseMovedCoordinates = "Mouse moved: (" + me.getX() + ", " + me.getY() + ")";
    repaint();
  }
  public void mouseDragged(MouseEvent me){}


  /*
  //TESTING THE MODEL HERE FOR NOW
  public static void main(String[] args){
    Player test1 = new Player();
    Player test2 = new Player();
    Gameboard test3 = new Gameboard(test1, test2);
  }*/


}
