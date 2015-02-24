import java.util.ArrayList;

public class Gameboard{
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
}
