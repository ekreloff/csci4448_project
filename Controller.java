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
  private boolean playerOneTurn;
  private Checker savedChecker;

  public void init(){
    Random rand = new Random();
    playerOneTurn = rand.nextBoolean();
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

    //Clear whole screen including text at the bottom.
    g.clearRect(0, 0, boardWidth + 150, boardHeight + 150);
    //Draw mouse debug strings on bottom of window
    g.drawString(mouseMovedCoordinates, 0, boardHeight + 20);
    g.drawString(mouseDraggedDebugInfo, 0, boardHeight + 40);
    g.drawString(mouseClickedDebugInfo, 0, boardHeight + 60);
    g.drawString(mousePressedDebugInfo, 0, boardHeight + 80);

    // whatever scene has been loaded call its draw method.
    currentScene.draw(g);
  }
  
  public boolean validMove(int mouseX, int mouseY){
  	// GameBoard.checkers
  	//for(Checker checker : GameBaord.checkers){
  		
  	//}
  }
  
/*
  // Checks if a move is valid.
    public boolean validMove(int movefrom, int moveto) {

	// Gets array indeces corresponding to the move, from parameters.
	int xfrom = movefrom/10 - 1;
	int yfrom = movefrom%10 - 1;
	int xto = moveto/10 - 1;
	int yto = moveto%10 - 1;

	// Check if indeces in range, if not, return false.
	if (xfrom < 0 || xfrom > 7 || yfrom < 0 || yfrom > 7 ||
	    xto < 0 || xto > 7 || yto < 0 || yto > 7)
	    return false;

	// Check to see you are moving your piece to a blank square.
	else if (board[xfrom][yfrom]==whosemove && board[xto][yto]=='_') {

	    // Checks case of simple move
	    if (Math.abs(xfrom-xto)==1) {
		if ((whosemove == 'r') && (yto - yfrom == 1))
		    return true;
		else if ((whosemove == 'b') && (yto - yfrom == -1))
		    return true;
	    }

	    // Checks case of a jump
	    else if (Math.abs(xfrom-xto)==2) {
		if (whosemove == 'r' && (yto - yfrom == 2) &&
		    board[(xfrom+xto)/2][(yfrom+yto)/2] == 'b')
		    return true;
		else if (whosemove == 'b' && (yto - yfrom == -2) &&
		    board[(xfrom+xto)/2][(yfrom+yto)/2] == 'r')
		    return true;
	    }
	}
	// If move is neither a simple one or a jump, it is not legal.
	return false;
}*/

  //Methods required to implement Mouse Listener interfaces
  public void mousePressed(MouseEvent me){
    int tileSize = GameBoard.size;
    int mouseX = me.getX() / tileSize + 1;
    int mouseY = me.getY() / tileSize + 1;

    mousePressedDebugInfo = "Mouse pressed debug - mousex: " + me.getX() + " mousey: " + me.getY();
    for(Checker checker : GameBoard.checkers){
      if(playerOneTurn){
        if((checker.player == 1) && (mouseX == checker.x) && (mouseY == checker.y)){
          savedChecker = checker;
        }
      }else{
        if((checker.player == 2) && (mouseX == checker.x) && (mouseY == checker.y)){
          savedChecker = checker;
        }
      }

    }
  }

  public void mouseDragged(MouseEvent me){
    int tileSize = GameBoard.size;
    int mouseX = me.getX() / tileSize + 1;
    int mouseY = me.getY() / tileSize + 1;

    mouseDraggedDebugInfo = "Mouse dragged debug - mousex: " + me.getX() + " mousey: " + me.getY();
    //Check saved coordinates to see if a players piece is underneath, and if it is continuously redraw it at the drag position
    if(savedChecker != null){
      savedChecker.x = mouseX;
      savedChecker.y = mouseY;
      repaint();
    }
  }

  public void mouseReleased(MouseEvent me){
    //Reset checker
    savedChecker = null;
    repaint();
  }

  public void mouseMoved(MouseEvent me){} //stub

  public void mouseClicked(MouseEvent me){} //stub

  public void mouseEntered(MouseEvent me){} //stub

  public void mouseExited(MouseEvent me){} //stub
}
