import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

//imports needed?

//Suppress warning about implementing serializable interface
@SuppressWarnings("serial")


public class Controller extends JApplet/* implements MouseListener*/{
  private GameBoard board;
  private Scene currentScene;


  public void init(){
    Player player1 = new HumanPlayer();
    Player player2 = new HumanPlayer(); // TODO: These need to be input taken from the main menu on which types of players are playing the game.
		board = new GameBoard(player1, player2);

    currentScene = new GameScene(); // GameScene to start.
		//addMouseListener(this);
  }

  public void paint(Graphics g){

    g.clearRect(0, 0, GameBoard.size, GameBoard.size); //clears a rectangle with dimansions size x size at the origin, so the whole screen.
    currentScene.draw(g); // whatever scene has been loaded call its draw method.
  }

  /*
  //TESTING THE MODEL HERE FOR NOW
  public static void main(String[] args){
    Player test1 = new Player();
    Player test2 = new Player();
    Gameboard test3 = new Gameboard(test1, test2);
  }*/


}
