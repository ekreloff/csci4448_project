import java.awt.Graphics;
import java.awt.*;

public class GameScene extends Scene{
  public void draw(Graphics g){
    drawBoard(g);
  }

  public void drawBoard(Graphics g){
		for(int i = 0; i <=7; i++){
			this.drawRows(g, i, GameBoard.size);
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
  ///*ARRAY OF CHEKERS, */
}
