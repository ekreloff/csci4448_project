import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Random;

//imports needed?

//Suppress warning about implementing serializable interface
@SuppressWarnings("serial")


public class Controller extends JApplet implements MouseListener, MouseMotionListener{
  private GameBoard board;
  private Scene currentScene;
  private String mouseMovedCoordinates = "";
  private String mouseDraggedDebugInfo = "";
  private String mouseClickedDebugInfo = "";
  private String mousePressedDebugInfo = "";
  private String eventType = "None";
  private boolean playerTurn;
  private Checker savedChecker;

  public void init(){
    Random rand = new Random();
    playerTurn = rand.nextBoolean();
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

    g.clearRect(0, 0, boardWidth + 150, boardHeight + 150); //Clear whole screen including text at the bottom.
/*
    //What type of Mouse Event just happened and what to do in response
    switch(eventType){
      case "MouseMoved":
      {
        g.clearRect(0, boardHeight, boardWidth, GameBoard.size + 10); //clear just the bottom text. Its +10 just to make sure it gets all of the text.
        break;
      }
      case "MouseDragged":
      {

        break;
      }
      case "MouseClicked":
      {

      }
    }*/
    g.drawString(mouseMovedCoordinates, 0, boardHeight + 20); //Draw mouse coordinate string to bottom of screen.
    g.drawString(mouseDraggedDebugInfo, 0, boardHeight + 40); //Draw mouse coordinate string to bottom of screen.
    g.drawString(mouseClickedDebugInfo, 0, boardHeight + 60); //Draw mouse coordinate string to bottom of screen.
    g.drawString(mousePressedDebugInfo, 0, boardHeight + 80);
    currentScene.draw(g); // whatever scene has been loaded call its draw method.
  }


  //Methods required to implement Mouse Listener interfaces
  public void mouseEntered(MouseEvent me){}
  public void mouseExited(MouseEvent me){}
  public void mousePressed(MouseEvent me){
    //Save coordinates
    mousePressedDebugInfo = "Mouse pressed debug - mousex: " + me.getX() + " mousey: " + me.getY();
  }
  public void mouseReleased(MouseEvent me){
    //Reset coordinates
    savedChecker = null;
    repaint();
  }

  public void mouseClicked(MouseEvent me){
    mouseClickedDebugInfo = "Mouse clicked debug - mousex: " + me.getX() + " mousey: " + me.getY();
  /*  int mouseX = me.getX();
    int mouseY = me.getY();
    int tileSize = GameBoard.size;
    for(Checker checker : GameBoard.checkers){
      if((mouseX >= checker.x) && (mouseX <= (checker.x + tileSize))){
        if((mouseY >= checker.y) && (mouseY <= checker.y + tileSize)){
          //this checker is underneath mouse.
          savedChecker = checker;
        }
      }
    }*/
    int tileSize = GameBoard.size;
    int mouseX = me.getX() / tileSize + 1;
    int mouseY = me.getY() / tileSize + 1;
    for(Checker checker : GameBoard.checkers){
      if((mouseX == checker.x) && (mouseY == checker.y)){
        savedChecker = checker;
      }
    }
  }
  public void mouseMoved(MouseEvent me){
    eventType = "MouseMoved";
    mouseMovedCoordinates = "Mouse moved: (" + me.getX() + ", " + me.getY() + ")";
    repaint();
  }
  public void mouseDragged(MouseEvent me){
    eventType = "MouseDragged";
    //mouseDraggedDebugInfo = "Mouse dragged debug - mousex: " + me.getX() + "mousey: " + me.getY() + "checkerx: " + savedChecker.x + "checkery: " + savedChecker.y;
    mouseDraggedDebugInfo = "Mouse dragged debug - mousex: " + me.getX() + " mousey: " + me.getY();

    int tileSize = GameBoard.size;
    int mouseX = me.getX() / tileSize + 1;
    int mouseY = me.getY() / tileSize + 1;
    /*int tileSize = GameBoard.size;
    int mouseX = me.getX() / tileSize;
    int mouseY = me.getY() / tileSize;
    for(Checker checker : GameBoard.checkers){
      if((mouseX == checker.x) && (mouseY == checker.y)){

      }
    }

    //this checker is underneath mouse.
    eventType = "MouseDragged";
    checker.x = me.getX();
    checker.y = me.getY();
    //mouseMovedCoordinates = "Mouse dragged: (" + me.getX() + ", " + me.getY() + ")";
    repaint();
    */
    //Check saved coordinates to see if a players piece is underneath, and if it is continuously redraw it at the drag position
    if(savedChecker != null){ //Check to make sure savedChecker isnt null
      eventType = "MouseDragged";
      savedChecker.x = mouseX;
      savedChecker.y = mouseY;
      //mouseMovedCoordinates = "Mouse dragged: (" + me.getX() + ", " + me.getY() + ")";
      repaint();
    }
  }
}
