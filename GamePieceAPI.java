package Exam1;
import java.awt.Point;
import java.util.ArrayList;

public class GamePieceAPI {
	
	/**
	 * An interface to indicate that the class that implements it is a
	 * Cloneable game piece.
	 */
	public static interface ClonePiece {
		
		/**
		 * A method that returns a deep clone of the object.
		 * @return
		 */
		public abstract AbstractGamePiece clonePiece();
	}
	
	
	/**
	 * Ex 3
	 * An interface that supports that the target chess piece can kill
	 * another piece by calling the kill method.
	 *
	 */
	public static interface Killer {
		
		boolean kill(Killer enemy);
		}
	
	/**
	 * A class that represents a Game Piece which has a position
	 * and a status.
	 *
	 */
	public static abstract class AbstractGamePiece implements ClonePiece, Killer {
		
		private boolean alive;
		
		public AbstractGamePiece() {
			this.alive = true;
		}

		public boolean isAlive() {
			return alive;
		}
		
		protected void setAlive(boolean status) {
			this.alive = status;
		}
		
	}
	
	/**
	 * Ex 1 
	 * 
	 * An abstract class representing a chess piece.
	 * It contains all the instance methods that all classes that extend 
	 * AbstractChessPiece have in common: Pawn, Queen and Bishop. 
	 * The only method that is abstract is canMove().
	 *
	 */
	public static abstract class AbstractChessPiece extends AbstractGamePiece {
		
		protected Point position;

		public AbstractChessPiece(int x, int y) {
			super();
			position = new Point(x,y);
		}
		
		public Point getPosition() {
			return position;
		}
		
		public void setPosition(Point location) {
			position = location;
		}
		
		public boolean equals(Object obj) {
			if(obj instanceof Pawn) {
				Pawn cp = (Pawn) obj;
				return this.getPosition().equals(cp.position);
			}
			return false;
		}
		
		public abstract boolean canMove(Point destination);

	}
	
	
	
	/**
	 * Ex 2 (Part A)
	 * Remove all the methods in Pawn that were moved to the AbstractChessPiece class
	 * to avoid redundancy.
	 * 
	 * A class representing a pawn
	 *
	 */
	public static class Pawn extends AbstractChessPiece {

		public Pawn(int x, int y) {
			super(x, y);

		}

		@Override
		public AbstractGamePiece clonePiece() {
			// Do not implement
			return null;
		}

		/**
		 * Ex 4
		 * A method that which enables a target piece to kill the parameter
		 * piece.  The method will first check if the target piece can move to 
		 * the position of the parameter piece and if so it will set its 
		 * status (alive) to false and return true.
		 * If the parameter piece cannot be reached the method will not modify 
		 * the parameter piece and will return false.
		 */
		public boolean kill(Killer enemy) {
			if(enemy instanceof AbstractChessPiece) {
				AbstractChessPiece cp = (AbstractChessPiece) enemy;
				if(this.canMove(cp.position)) {
					cp.setAlive(false);
					return true;
				}
			}
			return false;// Dummy return		
		}

		public boolean canMove(Point destination) {
			int x = (int) destination.getX();
			int y = (int) destination.getY();
			
			return this.getPosition().getX()-1 == x && this.getPosition().getY()+1 == y ||
					this.getPosition().getX()+1 == x && this.getPosition().getY()+1 == y;
		}
		
	}
	
	/**
	 * Ex 2 (Part B)
	 * Remove all the methods in Bishop that were moved to the AbstractChessPiece class
	 * to avoid redundancy.
	 * 
	 * A class that represents a bishop
	 * 
	 */
	public static class Bishop extends AbstractChessPiece {

		public Bishop(int x, int y) {
			super(x, y);

		}
		/**
		 * A method that gets a game piece and checks if 
		 * the target can kill the parameter piece
		 */
		
		public boolean kill(Killer enemy) {
			if(enemy instanceof AbstractChessPiece) {
				AbstractChessPiece cp = (AbstractChessPiece) enemy;
				if(this.canMove(cp.position)) {
					cp.setAlive(false);
					return true;
				}
			}
			return false;
		}

		/**
		 * Ex 5
		 * A method that determines if the target piece can move to the parameter coordinates.
		 * Hint: The Bishop can only move to diagonal coordinates.  Two coordinates
		 * are diagonal if the slope between then is either 1 or -1.
		 * For instance coordinates (1,2) and (2,3) are diagonal since the slope of the line 
		 * between them is 1.  Coordinates (1,2) and (3,3) are not diagonal.
		 * If the piece is already at the destination position then the method returns true.
		 */
		
		public boolean canMove(Point destination) {
			int x1 = (int) this.getPosition().x;
			int y1 = (int) this.getPosition().y;
			int x2 = (int) destination.getX();
			int y2 = (int) destination.getY();
		
			if(y2==y1 && x2==x1) {return true;}
			if(x2==x1) {
				return false;
			}
			if((y2-y1)/(x2-x1)==1 || (y2-y1)/(x2-x1)==-1 ) {
				return true;
			}
			return false;// Dummy return
		}
		
		/**
		 * Ex 6
		 * A method that returns a copy of the target object.
		 */
		@Override
		public AbstractGamePiece clonePiece() {
			Bishop clone= new Bishop(this.getPosition().x, this.getPosition().y);
		return  clone;
		} 
		
	}
	
	/**
	 * Ex 2 (Part C)
	 * Remove all the methods in Queen that were moved to the AbstractChessPiece class
	 * to avoid redundancy.
	 * 
	 * A class that represents a Queen
	 *
	 */
	public static class Queen extends AbstractChessPiece {

		public Queen(int x, int y) {
			super(x, y);

		}
		
		
		public boolean canMove(Point destination) {
			if(destination.equals(this.getPosition())) { return true; }
			if(destination.getX() == this.getPosition().getX() || 
					destination.getY() == this.getPosition().getY()) {
				return true;
			}
			double slope = Math.abs((destination.getY() - this.getPosition().getY())/
					(destination.getX() - this.getPosition().getX()));
			return Math.abs(slope - 1) <= 0.1;
		}

		
		public boolean kill(Killer enemy) {
			if(enemy instanceof AbstractChessPiece) {
				AbstractChessPiece cp = (AbstractChessPiece) enemy;
				if(this.canMove(cp.position)) {
					cp.setAlive(false);
					return true;
				}
			}
			return false;
		}
		
		@Override
		public AbstractGamePiece clonePiece() {
			// Do not implement.
			return null; 
		}
		
	}
	
	/**
	 * A class that contains chess games
	 *
	 */
	public static class ChessGame {
		
		/**
		 * A method that given a list of chesspieces returns the position 
		 * of the first found queen in the list.
		 * @param chessPieces
		 * @return
		 */
		public static int findQueenPosition(AbstractGamePiece[] chessPieces) {
			return findQueenPosition(chessPieces, 0);
		}
		
		/**
		 * Ex 7 
		 * A method that searches RECURSIVELY for the position of the first queen in the 
		 * parameter list of chess pieces and returns its position.  If no Queen exists
		 * in the list the method returns -1.
		 * @param chessPieces
		 * @param currPos
		 * @return
		 */
		private static int findQueenPosition(AbstractGamePiece[] chessPieces, int currPos) {
			if(currPos>=chessPieces.length) {
				return -1;
			}
			if(chessPieces[currPos] instanceof Queen) {
				return currPos;
			}
			return findQueenPosition(chessPieces, currPos+1);
		 // Dummy return
		}
		


		
		/**
		 * Ex 8
		 * A method that solves the N queens game. The goal of this game consists of
		 * placing N queens on each row of an N by N Chess board in such a way that 
		 * no queen can move to the position of another queen to kill it.  Queens
		 * can move any number of squares in horizontal, vertical and diagonal directions.
		 * 
		 * Each piece has a coordinate X and Y. Coordinates (0,0) represent the top
		 * left corner of the board.
		 * 
		 * This method will return an ArrayList<AbstractGamePiece> with the first 
		 * arrangement of the N queens that solves the problem.
		 * 
		 * If there is no way of placing the N queens in the board the the method will 
		 * return an empty ArrayList.
		 * 
		 *  HINT: Use your backtracking skills and other methods provided in this class
		 * 
		 * @param dimensions
		 * @param currRow
		 * @param queens
		 * @return
		 */
		public static ArrayList<AbstractGamePiece> getQueenPositionSolution(int dimension) {
			ArrayList<AbstractGamePiece> queens = new ArrayList<>();
			positionQueens(dimension, 0, queens);
			return queens;
		}
		
		/**
		 * Helper method for the above getQueenPositionSolution method
		 */
		private static boolean positionQueens(int dimensions, int currRow, ArrayList<AbstractGamePiece> queens) {
			if(currRow>dimensions) {
				
			}
			for (int i = 0; i <= dimensions; i++) {
				if(!checkCollision(queens)){
					return positionQueens(dimensions, currRow+1, queens);
				}
				
			}
			
			
			return false;
		}
		 
		/**
		 * A method that allows you to check if queens or other pieces in the
		 * parameter ArrayList can attack each other.
		 * 
		 * @param queens
		 * @return
		 */
		public static boolean checkCollision(ArrayList<AbstractGamePiece> queens) {
			for(int killer = 0; killer < queens.size() - 1; killer++) {
				for(int victim = killer + 1; victim < queens.size(); victim++) {
					if(((Queen)queens.get(killer)).kill((Queen)queens.get(victim))) {
						return true;
					}
				}
			}

			return false;
		}
		
	}

}