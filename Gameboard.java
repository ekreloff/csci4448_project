import java.util.ArrayList;
import java.applet.*;
import java.awt.*;
import javax.swing.*;

public class GameBoard extends SimpleJavaApplet{
	private int squaresize = 40;
	/*
  public Player player1;
  public Player player2;
  private ArrayList<Checker> checkers;

  public Gameboard(Player player1, Player player2){
    this.player1 = player1;
    this.player2 = player2;
    this.checkers = new ArrayList<Checker>(24);

    for(int y = 1; y <= 8; y++){
      for(int x = 1; x <= 8; x++){
        //No pieces in rows 4 or 5
        if(y != 4 && y != 5){
          //Interesting pattern here, if x and y are both
          //even or odd, then there should be a piece placed
          if((x%2) == (y%2)){
            Checker checker = new Checker(x, y);

            //we should probably mark the checkers somehow
            //to be for player 1 or player 2
            this.checkers.add(checker);
          }
        }
      }
    }
    //Check the checkers, we can remove this once we finish the class
    for(Checker c : this.checkers){
      System.out.println(c.x + " " + c.y);
    }
  }
	  */
  
	public void createBoard(Graphics g){
		for (int i = 0; i <=7; i++){
			this.drawRows(g, i, squaresize);
		}
	}
	
	public void drawRows(Graphics g, int y, int size){
		for (int i = 1;i <= 8; i++){
			if((y+i)%2 == 1){
				g.setColor(Color.lightGray);
				g.fillRect(i*size, y*size, size, size);
			}else{
				g.setColor(Color.darkGray);
				g.fillRect(i*size, y*size, size, size);
			}
		}
	}
	

  //getter for checkers should return read only array.
}
