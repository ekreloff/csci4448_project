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
}
