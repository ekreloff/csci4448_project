import java.awt.Graphics;
import java.awt.*;

public class GameScene extends Scene{
  public void draw(Graphics g){
    drawBoard(g);
    drawCheckers(g);
  }

  public void drawBoard(Graphics g){
		for(int i = 0; i <=7; i++){
			this.drawRows(g, i, GameBoard.size);
		}
	}

	public void drawRows(Graphics g, int y, int size){
		for(int i = 0;i <= 7; i++){
			if((y+i)%2 == 1){
				g.setColor(Color.lightGray);
				g.fillRect(i*size, y*size, size, size);
			}else{
				g.setColor(Color.darkGray);
				g.fillRect(i*size, y*size, size, size);
			}
		}
	}

  public void drawCheckers(Graphics g){
    for(Checker checker : GameBoard.checkers){
      g.setColor(checker.color);
      g.fillOval((checker.x - 1)*GameBoard.size, (checker.y - 1)*GameBoard.size, GameBoard.size, GameBoard.size);
    }
  }
/*
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
  //ARRAY OF CHEKERS, */
}
