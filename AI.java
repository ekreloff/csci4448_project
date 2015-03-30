import java.util.*;

public class AI{

	private int myColor;

///*Checker[] checkers*/
	public void determineMove(List<Checker> checkers){
	//Minimax
	}

	private InternalRepresentation maxi(InternalRepresentation internalRep){
		return null;
	}

	private InternalRepresentation mini(InternalRepresentation internalRep){
		return null;
	}

	public void setColor(int color){
		this.myColor = color;
	}

//*************************************************************************************	
//*************************************************************************************
//*************************************************************************************
// classes to use for internal representation of minimax
	private class InternalRepresentation{
		public int me;
		public int meCount;
		public int opCount;
		public int value;
		public Integer[][] board;
		public List<Move> validMoves;

		public InternalRepresentation(List<Checker> checkers, int myColor){
			board = new Integer[8][8];
			for (int i = 0; i < 8; i++ ){
				for (int j = 0; j < 8; j++ ){
					board[i][j] = 0;
				}
			}
			this.me = myColor;
			for (Checker c : checkers){
				board[c.x][c.y] = c.color;
				if (c.color == me){
					meCount ++;
				} else {
					opCount ++;
				}
			}
			calculateValue();
			determineValidMoves();
		}

		public InternalRepresentation(InternalRepresentation oldR, Move move){
			board = oldR.board;

		}

		private void calculateValue(){
			this.value = meCount - opCount;
		}

		private void  determineValidMoves(){

		}

		public boolean isTerminal(){
			return meCount == 0 || opCount == 0 || validMoves.size() == 0;
		}
	}

	private class Move{
		public int newX;
		public int newY;

		public int oldX;
		public int oldY;

		public Move(int nX, int nY, int oX, int oY){
			this.newX = nX;
			this.newY = nY;
			this.oldX = oX;
			this.oldY = oY;
		}
	}

}
