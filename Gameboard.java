import java.util.ArrayList;
//import java.awt.*;
//import javax.swing.*;

public class GameBoard{
	//private int size = 40;
	private ArrayList<Checker> checkers = new ArrayList<Checker>(24);
	//private int red = 1;
	//private int black = 2;

 	//public Player player1;
  	//public Player player2;
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
							if(y < 4){
								//Player 1
								Checker checker = new Checker(x, y, 1);
							}else{
								//Player 2
								Checker checker = new Checker(x, y, 2);
							}
            	this.checkers.add(checker);
          	}
          }
        }
    	}
  	}
/*

	public void printCheckers(){
		for(Checker c : this.checkers){
        System.out.println("\nChecker: " + c.x + " " + c.y + " " + c.color);
		}
	}

	public void drawBoard(Graphics g){
		for(int i = 0; i <=7; i++){
			this.drawRows(g, i, size);
		}
	}

	public void drawRedCheckers(Graphics g){
		for(int i = 0; i < 3; i++){
			for(int j = 2; j <= 8; j+=2){
				if(i%2 == 0){
					Checker checker = new Checker(j*size, i*size, red);
					this.checkers.add(checker);
					g.setColor(Color.red);
					g.fillOval(j*size, i*size, size, size);
				}else{
					Checker checker = new Checker((j-1)*size, i*size, red);
					this.checkers.add(checker);
					g.setColor(Color.red);
					g.fillOval((j-1)*size, i*size, size, size);
				}
			}
		}
	}

	public void drawBlackCheckers(Graphics g){
		for(int i = 5; i < 8; i++){
			for(int j = 2; j <= 8; j+=2){
				if(i%2 == 0){
					Checker checker = new Checker(j*size, i*size, black);
					this.checkers.add(checker);
					g.setColor(Color.black);
					g.fillOval(j*size, i*size, size, size);
				}else{
					Checker checker = new Checker((j-1)*size, i*size, black);
					this.checkers.add(checker);
					g.setColor(Color.black);
					g.fillOval((j-1)*size, i*size, size, size);
				}
			}
		}
	}

	public void drawRows(Graphics g, int y, int size){
		for(int i = 1;i <= 8; i++){
			if((y+i)%2 == 1){
				g.setColor(Color.lightGray);
				g.fillRect(i*size, y*size, size, size);
			}else{
				g.setColor(Color.darkGray);
				g.fillRect(i*size, y*size, size, size);
			}
		}
	}
	*/
  //getter for checkers should return read only array.
}
