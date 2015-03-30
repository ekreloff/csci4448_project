import java.util.*;

public class AI{

	private int myColor;
	private int opColor;

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

	public void setOpColor(int color){
		this.opColor = color;
	}

//*************************************************************	
//*************************************************************
// classes to use for internal representation of minimax ******
//*************************************************************
//*************************************************************
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
				if (c.king) board[c.x][c.y] = c.color * 10; 
				else board[c.x][c.y] = c.color;
				if (c.color == me){
					meCount ++;
				} else {
					opCount ++;
				}
			}
			calculateValue();
			determineValidMoves(me);
		}

		public InternalRepresentation(InternalRepresentation oldR, Move move, int who){
			board = oldR.board;

		}

		private void calculateValue(){
			this.value = meCount - opCount;
		}

		private void  determineValidMoves(int whoseMove){
			if (whoseMove == 1){
				determineRedMoves();
			}
			if (whoseMove == 2){
				determineBlackMoves();
			}
		}

		private void determineRedMoves(){
			boolean takeMove = false;
			for (int i = 0; i < 8; i++ ){
				for (int j = 0; j < 8; j++ ){
					if (board[i][j] != 0 && (board[i][j]) == 1){
						if (takeMove){
							if (board[i+1][j+1] == 2 && board[i+2][j+2] == 0){
								validMoves.add(new Move(i,j,i+2,j+2,true));
							}
							if (board[i-1][j+1] == 2 && board[i-2][j+2] == 0){
								validMoves.add(new Move(i,j,i-2,j+2,true));
							}
						} else{
							if (board[i+1][j+1] == 2 && board[i+2][j+2] == 0){
								takeMove = true;
								validMoves.clear();
								validMoves.add(new Move(i,j,i+2,j+2,true));
							}
							if (board[i-1][j+1] == 2 && board[i-2][j+2] == 0){
								if (!takeMove){
									takeMove = true;
									validMoves.clear();
									validMoves.add(new Move(i,j,i-2,j+2,true));
								} else{
									validMoves.add(new Move(i,j,i-2,j+2,true));
								}
							}
							if (board[i+1][j+1] == 0 && !takeMove){
								validMoves.add(new Move(i,j,i+1,j+1,false));
							}
							if (board[i-1][j+1] == 0 && !takeMove){
								validMoves.add(new Move(i,j,i-1,j+1,false));
							}
						}
					}

					if (board[i][j] != 0 && board[i][j] == 10){
						if (takeMove){
							if (board[i+1][j+1] == 2 && board[i+2][j+2] == 0){
								validMoves.add(new Move(i,j,i+2,j+2,true));
							}
							if (board[i-1][j+1] == 2 && board[i-2][j+2] == 0){
								validMoves.add(new Move(i,j,i-2,j+2,true));
							}
							if (board[i+1][j-1] == 2 && board[i+2][j-2] == 0){
								validMoves.add(new Move(i,j,i+2,j-2,true));
							}
							if (board[i-1][j-1] == 2 && board[i+2][j-2] == 0){
								validMoves.add(new Move(i,j,i+2,j-2,true));
							}
						} else{
							if (board[i+1][j+1] == 2 && board[i+2][j+2] == 0){
								takeMove = true;
								validMoves.clear();
								validMoves.add(new Move(i,j,i+2,j+2,true));
							}
							if (board[i-1][j+1] == 2 && board[i-2][j+2] == 0){
								if (!takeMove){
									takeMove = true;
									validMoves.clear();
									validMoves.add(new Move(i,j,i-2,j+2,true));
								} else{
									validMoves.add(new Move(i,j,i-2,j+2,true));
								}
							}
							if (board[i+1][j-1] == 2 && board[i+2][j-2] == 0){
								if (!takeMove){
									takeMove = true;
									validMoves.clear();
									validMoves.add(new Move(i,j,i+2,j-2,true));
								} else{
									validMoves.add(new Move(i,j,i+2,j-2,true));
								}
							}
							if (board[i-1][j-1] == 2 && board[i-2][j-2] == 0){
								if (!takeMove){
									takeMove = true;
									validMoves.clear();
									validMoves.add(new Move(i,j,i-2,j-2,true));
								} else{
									validMoves.add(new Move(i,j,i-2,j-2,true));
								}
							}
							if (board[i+1][j+1] == 0 && !takeMove){
								validMoves.add(new Move(i,j,i+1,j+1,false));
							}
							if (board[i-1][j+1] == 0 && !takeMove){
								validMoves.add(new Move(i,j,i-1,j+1,false));
							}
							if (board[i+1][j-1] == 0 && !takeMove){
								validMoves.add(new Move(i,j,i-1,j+1,false));
							}
							if (board[i-1][j-1] == 0 && !takeMove){
								validMoves.add(new Move(i,j,i-1,j+1,false));
							}
						}
					}
				}
			}
		}

		private void determineBlackMoves(){
			boolean takeMove = false;
			for (int i = 0; i < 8; i++ ){
				for (int j = 0; j < 8; j++ ){
					if (board[i][j] != 0 && (board[i][j]) == 2){
						if (takeMove){
							if (board[i+1][j-1] == 1 && board[i+2][j-2] == 0){
								validMoves.add(new Move(i,j,i+2,j-2,true));
							}
							if (board[i-1][j-1] == 2 && board[i-2][j-2] == 0){
								validMoves.add(new Move(i,j,i-2,j-2,true));
							}
						} else{
							if (board[i+1][j-1] == 2 && board[i+2][j-2] == 0){
								takeMove = true;
								validMoves.clear();
								validMoves.add(new Move(i,j,i+2,j-2,true));
							}
							if (board[i-1][j-1] == 2 && board[i-2][j-2] == 0){
								if (!takeMove){
									takeMove = true;
									validMoves.clear();
									validMoves.add(new Move(i,j,i-2,j-2,true));
								} else{
									validMoves.add(new Move(i,j,i-2,j-2,true));
								}
							}
							if (board[i+1][j-1] == 0 && !takeMove){
								validMoves.add(new Move(i,j,i+1,j-1,false));
							}
							if (board[i-1][j-1] == 0 && !takeMove){
								validMoves.add(new Move(i,j,i-1,j-1,false));
							}
						}
					}

					if (board[i][j] != 0 && board[i][j] == 20){
						if (takeMove){
							if (board[i+1][j+1] == 2 && board[i+2][j+2] == 0){
								validMoves.add(new Move(i,j,i+2,j+2,true));
							}
							if (board[i-1][j+1] == 2 && board[i-2][j+2] == 0){
								validMoves.add(new Move(i,j,i-2,j+2,true));
							}
							if (board[i+1][j-1] == 2 && board[i+2][j-2] == 0){
								validMoves.add(new Move(i,j,i+2,j-2,true));
							}
							if (board[i-1][j-1] == 2 && board[i+2][j-2] == 0){
								validMoves.add(new Move(i,j,i+2,j-2,true));
							}
						} else{
							if (board[i+1][j+1] == 2 && board[i+2][j+2] == 0){
								takeMove = true;
								validMoves.clear();
								validMoves.add(new Move(i,j,i+2,j+2,true));
							}
							if (board[i-1][j+1] == 2 && board[i-2][j+2] == 0){
								if (!takeMove){
									takeMove = true;
									validMoves.clear();
									validMoves.add(new Move(i,j,i-2,j+2,true));
								} else{
									validMoves.add(new Move(i,j,i-2,j+2,true));
								}
							}
							if (board[i+1][j-1] == 2 && board[i+2][j-2] == 0){
								if (!takeMove){
									takeMove = true;
									validMoves.clear();
									validMoves.add(new Move(i,j,i+2,j-2,true));
								} else{
									validMoves.add(new Move(i,j,i+2,j-2,true));
								}
							}
							if (board[i-1][j-1] == 2 && board[i-2][j-2] == 0){
								if (!takeMove){
									takeMove = true;
									validMoves.clear();
									validMoves.add(new Move(i,j,i-2,j-2,true));
								} else{
									validMoves.add(new Move(i,j,i-2,j-2,true));
								}
							}
							if (board[i+1][j+1] == 0 && !takeMove){
								validMoves.add(new Move(i,j,i+1,j+1,false));
							}
							if (board[i-1][j+1] == 0 && !takeMove){
								validMoves.add(new Move(i,j,i-1,j+1,false));
							}
							if (board[i+1][j-1] == 0 && !takeMove){
								validMoves.add(new Move(i,j,i-1,j+1,false));
							}
							if (board[i-1][j-1] == 0 && !takeMove){
								validMoves.add(new Move(i,j,i-1,j+1,false));
							}
						}
					}
				}
			}
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

		public boolean take;

		public Move( int oX, int oY, int nX, int nY, boolean t){
			this.newX = nX;
			this.newY = nY;
			this.oldX = oX;
			this.oldY = oY;
			this.take = t;
		}
	}

}
