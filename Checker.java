import java.awt.*;

public class Checker{
  public boolean king;
  public int x;
  public int y;
  public int player;
  public Color color;
  //public int color;

  public Checker(int x, int y, int player){
    this.x = x;
    this.y = y;
	  this.player = player;
	  this.king = false;
  }
}
