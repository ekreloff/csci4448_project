public class AI{

	private int myColor;

///*Checker[] checkers*/
	public void determineMove(List<Checker> checkers){
	//Minimax
	}

	private InternalRepresentation maxi(InternalRepresentation internalRep){

	}

	private InternalRepresentation mini(InternalRepresentation internalRep){

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
			for (int i; i++; i < 8){
				for (int j; j++; j < 8){
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

		private calculateValue(){
			this.value = meCount - opCount;
		}

		private determineValidMoves(){

		}

		public isTerminal(){
			return meCount == 0 || opCount == 0 || len(validMoves) == 0
		}
	}

	private class Move{
		public int newX;
		public int newY;

		public int oldX;
		public int oldY;

		public Move(int nX, int nY, int oX, int, oY){
			this.newX = nX;
			this.newY = nY;
			this.oldX = oX;
			this.oldY = oy;
		}
	}

}
