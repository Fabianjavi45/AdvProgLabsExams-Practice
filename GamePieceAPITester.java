package Exam1;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Point;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class GamePieceAPITester {

	@Test
	public void testChessPieceAbstract() {
		
		GamePieceAPI.Queen q1 = new GamePieceAPI.Queen(3,3);
		GamePieceAPI.Bishop b1 = new GamePieceAPI.Bishop(3,3);

		assertTrue("Queen should be instance of the AbstractChessClass", q1 instanceof GamePieceAPI.AbstractChessPiece);
		assertTrue("Bishop should be instance of the AbstractChessClass", b1 instanceof GamePieceAPI.AbstractChessPiece);
		
		GamePieceAPI.AbstractChessPiece qcp1 = (GamePieceAPI.AbstractChessPiece) q1;
		GamePieceAPI.AbstractChessPiece bcp1 = (GamePieceAPI.AbstractChessPiece) b1;
		
		boolean hasMethods = true;
		try {
    		Class c = Class.forName("GamePieceAPI");
    		Class cl[] = c.getDeclaredClasses();
    		for(Class cls : cl) {
    			if(cls.toString().contains("AbstractChessPiece")) {
    				Method[] methods = cls.getDeclaredMethods();
    				assertEquals("Should only contain 4 methods", 4, methods.length);
    				for(Method method: methods) {
	    				if(method.toString().contains("equals")) {
	    					assertTrue("The object is equal to itself", (Boolean) method.invoke(qcp1, qcp1));
	    					assertTrue("The objects from different classes share the same information.", (Boolean) method.invoke(qcp1, bcp1));
	    				}
	    						
	    				if(method.toString().contains("setPosition")) {
	    					method.invoke(qcp1, new Point(5, 5));
	    					assertEquals("The point wasn't updated", new Point(5, 5), qcp1.position);
	    					method.invoke(qcp1, new Point(3, 1));

	    				}
	    				
	    				if(method.toString().contains("getPosition")) {
	    					assertEquals("The point wasn't retrived", new Point(3, 3), method.invoke(bcp1));

	    				}
	    				if(method.toString().contains("canMove") && method.toString().contains("abstract")) {
	    					assertTrue("Queen can move to position (0,0).", (Boolean) method.invoke(qcp1, new Point(0,0)));
	    					assertFalse("Queen can't move to position (1,0).", (Boolean) method.invoke(qcp1, new Point(1,0)));
	    				}
	    				else {
	    					hasMethods = false;
	    					break;
	    				}
    				}
    			}
    		}

    	} catch (Exception e) {
    		fail(e.toString());
    	}
		assertFalse("These abstract class has missing methods", hasMethods);		
	}
	
	@Test
	public void testRefactoring() {
		boolean hasMethods = false;
		try {
    		Class c = Class.forName("GamePieceAPI");
    		Class cl[] = c.getDeclaredClasses();
    		for(Class cls : cl) {
    			if(cls.toString().contains("Bishop") || cls.toString().contains("Queen") || cls.toString().contains("Pawn")) {
    				Method[] methods = cls.getDeclaredMethods();
    				for(Method method: methods) {
	    				if(method.toString().contains("equals") || method.toString().contains("setPosition") 
	    						|| method.toString().contains("getPosition")) {
	    					hasMethods = true;
	    					break;
	    				}
    				}
    			}
    		}

    	} catch (Exception e) {
    		fail(e.toString());
    	}
		assertFalse("These clases still contain methods that should be in the abstract class", hasMethods);
	}
	
	@Test 
	public void testKillerInterface() {
		boolean hasMethods = false;
		try {
    		Class c = Class.forName("GamePieceAPI");
    		Class cl[] = c.getDeclaredClasses();
    		for(Class cls : cl) {
    			if(cls.toString().contains("Killer")) {
    				Method[] methods = cls.getDeclaredMethods();
    				assertEquals("Should only contain one method", 1, methods.length);
    				for(Method method: methods) {
	    				if(method.toString().contains("kill(GamePieceAPI$Killer)") ) {
	    					hasMethods = true;
	    					break;
	    				}
    				}
    			}
    		}

    	} catch (Exception e) {
    		fail(e.toString());
    	}
		assertTrue("This interface should contain abstract method kill", hasMethods);
	

	}
	
	@Test
	public void testBishopCanMove() {
		GamePieceAPI.Bishop b1 = new GamePieceAPI.Bishop(3,3);
		
		assertTrue("The bishop can move to this diagonal position.", b1.canMove(new Point(3,3)));
		assertTrue("The bishop can move to this diagonal position.", b1.canMove(new Point(1,1)));
		assertTrue("The bishop can move to this diagonal position.", b1.canMove(new Point(5,5)));
		assertTrue("The bishop can move to this diagonal position.", b1.canMove(new Point(2,4)));
		assertTrue("The bishop can move to this diagonal position.", b1.canMove(new Point(6,0)));

		assertFalse("The bishop can't move to this position.", b1.canMove(new Point(3,4)));
		assertFalse("The bishop can't move to this position.", b1.canMove(new Point(1,3)));
		assertFalse("The bishop can't move to this position.", b1.canMove(new Point(1,2)));
		assertFalse("The bishop can't move to this position.", b1.canMove(new Point(6,1)));
	}
	
	@Test
	public void testPawnKill() {
		GamePieceAPI.Pawn p1 = new GamePieceAPI.Pawn(3,3);
		GamePieceAPI.AbstractGamePiece gp1 = new GamePieceAPI.Pawn(4,4);
		GamePieceAPI.AbstractGamePiece gp2 = new GamePieceAPI.Queen(3,4);
		GamePieceAPI.AbstractGamePiece gp3 = new GamePieceAPI.Bishop(2,4);
		
		assertTrue("Piece should be alive", gp1.isAlive());
		assertTrue("Pawn can kill piece", p1.kill(gp1));
		assertFalse("Piece should be dead", gp1.isAlive());
		
		assertTrue("Piece should be alive", gp2.isAlive());
		assertFalse("Pawn can't kill piece", p1.kill(gp2));
		assertTrue("Piece should be alive", gp2.isAlive());
		
		assertTrue("Piece should be alive", gp3.isAlive());
		assertTrue("Pawn can kill piece", p1.kill(gp3));
		assertFalse("Piece should be dead", gp3.isAlive());
		
	}
	
	@Test
	public void testQueensGameSolution() {
		ArrayList _1BoardSolution = GamePieceAPI.ChessGame.getQueenPositionSolution(1);
		ArrayList _2BoardSolution = GamePieceAPI.ChessGame.getQueenPositionSolution(2);
		ArrayList _3BoardSolution = GamePieceAPI.ChessGame.getQueenPositionSolution(3);
		ArrayList _4BoardSolution = GamePieceAPI.ChessGame.getQueenPositionSolution(4);
		ArrayList _8BoardSolution = GamePieceAPI.ChessGame.getQueenPositionSolution(8);
		ArrayList _15BoardSolution = GamePieceAPI.ChessGame.getQueenPositionSolution(15);
	

		assertEquals("This should return one piece only", 1, _1BoardSolution.size());

		assertTrue("This result should come out as empty", _2BoardSolution.isEmpty());
		assertTrue("This result should come out as empty", _3BoardSolution.isEmpty());
		
		assertTrue("These queens should not collide (Size 4 has a solution)", correctQueens(_4BoardSolution, 4));
		assertTrue("These queens should not collide (Size 8 has a solution)", correctQueens(_8BoardSolution, 8));
		assertTrue("These queens should not collide (Size 15 has a solution)", correctQueens(_15BoardSolution, 15));
	}
	
	private static boolean correctQueens(ArrayList queens, int size) {
		for(int killer = 0; killer < queens.size() - 1; killer++) {
			if(((GamePieceAPI.Queen)queens.get(killer)).getPosition().getX() < 0 ||
					((GamePieceAPI.Queen)queens.get(killer)).getPosition().getX() >= size ||
					((GamePieceAPI.Queen)queens.get(killer)).getPosition().getY() < 0 ||
					((GamePieceAPI.Queen)queens.get(killer)).getPosition().getX() >= size) {
				return false;
			}
			for(int victim = killer + 1; victim < queens.size(); victim++) {
				if(((GamePieceAPI.Queen)queens.get(killer)).kill((GamePieceAPI.Queen)queens.get(victim))) {
					return false;
				}
			}
		}

		return true;
	}
	
	@Test
	public void testBishopClone() {
		GamePieceAPI.Bishop b1 = new GamePieceAPI.Bishop(0,0);
		GamePieceAPI.Bishop b2 = new GamePieceAPI.Bishop(10,-20);

		GamePieceAPI.AbstractChessPiece b1Copy = (GamePieceAPI.AbstractChessPiece) b1.clonePiece();
		GamePieceAPI.AbstractChessPiece b2Copy = (GamePieceAPI.AbstractChessPiece) b2.clonePiece();
		
		assertTrue("The copy generated must be an instance of the Bishop Class", b1Copy instanceof GamePieceAPI.Bishop);
		assertTrue("The copy generated must be an instance of the Bishop Class", b2Copy instanceof GamePieceAPI.Bishop);

		assertFalse("The copy should not share the same instance", b1 == b1Copy);
		assertFalse("The copy should not share the same instance", b2 == b2Copy);
		
		assertFalse("The copy should not share the same position instance", b1.getPosition() == ((GamePieceAPI.Bishop)b1Copy).getPosition());
		assertFalse("The copy should not share the same position instance", b2.getPosition() == ((GamePieceAPI.Bishop)b2Copy).getPosition());
		
		assertEquals("These copies should be identical", b1.position, b1Copy.position);
		assertEquals("These copies should be identical", b2.position, b2Copy.position);
	}
	
	@Test(expected = StackOverflowError.class)
	public void testFindQueenPosition() {
		GamePieceAPI.Queen q1 = new GamePieceAPI.Queen(3,3);
		GamePieceAPI.Queen q2 = new GamePieceAPI.Queen(4,6);
		GamePieceAPI.Bishop b1 = new GamePieceAPI.Bishop(2,3);
		GamePieceAPI.Bishop b2 = new GamePieceAPI.Bishop(0,0);
		GamePieceAPI.Bishop b3 = new GamePieceAPI.Bishop(8,5);
		GamePieceAPI.Pawn p1 = new GamePieceAPI.Pawn(0,1);
		GamePieceAPI.Pawn p2 = new GamePieceAPI.Pawn(2,5);
		GamePieceAPI.Pawn p3 = new GamePieceAPI.Pawn(4,6);
		
		GamePieceAPI.AbstractGamePiece[] noQueen = {b1, p1, b3, p3};
		GamePieceAPI.AbstractGamePiece[] oneQueenFront = {q1, b2, p1, b1, p3};
		GamePieceAPI.AbstractGamePiece[] oneQueenBack = {b1, p1, b3, p3, q2};
		GamePieceAPI.AbstractGamePiece[] oneQueenMiddle = {b3, p2, p1, q1, p3, q2};		
		GamePieceAPI.AbstractGamePiece[] twoQueen = { p2, q2, b1, p1, q1, b3, p3};
		GamePieceAPI.AbstractGamePiece[] hugeArray = new GamePieceAPI.AbstractGamePiece[100000];
		Arrays.fill(hugeArray, p2);

		
		assertEquals("There is no queen in list.", -1, GamePieceAPI.ChessGame.findQueenPosition(noQueen));
		assertEquals("There is one queen in list (Pos 0).", 0, GamePieceAPI.ChessGame.findQueenPosition(oneQueenFront));
		assertEquals("There is one queen in list (Pos 4).", 4, GamePieceAPI.ChessGame.findQueenPosition(oneQueenBack));
		assertEquals("There is one queen in list (Pos 3).", 3, GamePieceAPI.ChessGame.findQueenPosition(oneQueenMiddle));
		assertEquals("There are two queens in list, return first one (Pos 1).", 1, GamePieceAPI.ChessGame.findQueenPosition(twoQueen));
		assertEquals("", 1, GamePieceAPI.ChessGame.findQueenPosition(hugeArray));
		
	}

}