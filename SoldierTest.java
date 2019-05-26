package Exam1;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertNotEquals;

import static org.junit.Assert.assertTrue;



import java.awt.Point;

import java.awt.Rectangle;



import org.junit.Test;



public class SoldierTest {



	Soldier soldier1 = new Soldier("Juan", "Perez", "123456", "Captain", new Point(0,0));

	Soldier soldier2 = new Soldier("Pedro", "Rivera", "654321", "Sergeant", new Point(10,10));

	Soldier soldier3 = new Soldier("Christian", "Rodriguez", "135791", "Major", new Point(2,10));

	Soldier soldier4 = new Soldier("Jose", "Santiago", "246824", "Sergeant", new Point(8,2));

	Soldier soldier5 = new Soldier("Maria", "Ruiz", "321654", "Captain", new Point(800,3000));

	

	Point battle1 = new Point(0, 0);

	Point battle2 = new Point(1, 1);

	Point battle3 = new Point(2, 25);

	Point battle4 = new Point(25, 2);

	Point battle5 = new Point(7500, 8000);

	

	Rectangle enemyZone1 = new Rectangle(0, 0, 25, 25);

	Rectangle enemyZone2 = new Rectangle(0, 0, 10, 10);

	Rectangle enemyZone3 = new Rectangle(2, 0, 25, 25);

	Rectangle enemyZone4 = new Rectangle(0, 2, 10, 10);

	Rectangle enemyZone5 = new Rectangle(400, 0, 400, 4000);

	Rectangle enemyZone6 = new Rectangle(-10, -10, 20, 20);

	Rectangle enemyZone7 = new Rectangle(0, 0, 20, 10);

	Rectangle enemyZone8 = new Rectangle(0, 0, 2, 10);

	Rectangle enemyZone9 = new Rectangle(8, 0, 5, 2);

	Rectangle enemyZone10 = new Rectangle(10, 10, 25, 25);



	@Test

	public void testDistanceFromBattle() {

		assertEquals(0.0, soldier1.distanceToBattle(battle1), 1e-5);

		assertEquals(12.72792, soldier2.distanceToBattle(battle2), 1e-5);

		assertEquals(15.0, soldier3.distanceToBattle(battle3), 1e-5);

		assertEquals(17.0, soldier4.distanceToBattle(battle4), 1e-5);

		assertEquals(8360.02392, soldier5.distanceToBattle(battle5), 1e-5);

	}



	@Test

	public void testInDanger() {

		assertTrue(soldier1.inDanger(enemyZone1));

		assertTrue(soldier2.inDanger(enemyZone2));

		assertTrue(soldier3.inDanger(enemyZone3));

		assertTrue(soldier4.inDanger(enemyZone4));

		assertTrue(soldier5.inDanger(enemyZone5));

		assertTrue(soldier1.inDanger(enemyZone6));

		assertTrue(soldier2.inDanger(enemyZone7));

		assertTrue(soldier3.inDanger(enemyZone8));

		assertTrue(soldier4.inDanger(enemyZone9));

		assertFalse(soldier5.inDanger(enemyZone10));

	}



	@Test

	public void testGetRadioFrequency() {

		assertEquals(0.0, soldier1.getRadioFrequency(0.0, 5.0, 6.0, 0.0), 1e-5);

		assertEquals(-0.12124, soldier2.getRadioFrequency(5.0, -5.0, 6.0, 3.0), 1e-5);

		assertEquals(0.31047, soldier3.getRadioFrequency(7.0, 14.0, 30.0, -58.0), 1e-5);

		assertEquals(0.01774, soldier4.getRadioFrequency(1.0, 4.0, 83.0, -9.0), 1e-5);

		assertEquals(-0.10283, soldier5.getRadioFrequency(5.0, 5.0, 1.5, 2.54), 1e-5);

	}



	@Test

	public void testNewTag() {

		soldier1.newTag();

		assertTrue(soldier1.getTag().length() == 6);

		assertEquals("123", soldier1.getTag().substring(0, 3));

		assertNotEquals("456", soldier1.getTag().substring(3));

		assertNotEquals("123456", soldier1.getTag());

		

		soldier2.newTag();

		assertTrue(soldier2.getTag().length() == 6);

		assertEquals("654", soldier2.getTag().substring(0, 3));

		assertNotEquals("321", soldier2.getTag().substring(3));

		assertNotEquals("654321", soldier2.getTag());

		

		soldier3.newTag();

		assertTrue(soldier3.getTag().length() == 6);

		assertEquals("135", soldier3.getTag().substring(0, 3));

		assertNotEquals("791", soldier3.getTag().substring(3));

		assertNotEquals("135791", soldier3.getTag());

	}

	

	@Test

	public void testTeamLeader() {

		assertEquals(soldier1.getLastName(), soldier1.teamLeader(soldier3.getRank(), soldier3.getFirstName().charAt(0) + "." + soldier3.getLastName()));

		assertEquals(soldier1.getLastName(), soldier1.teamLeader(soldier2.getRank(), soldier2.getFirstName().charAt(0) + "." + soldier2.getLastName()));

		assertEquals(soldier3.getLastName(), soldier3.teamLeader(soldier4.getRank(), soldier4.getFirstName().charAt(0) + "." + soldier4.getLastName()));

		assertEquals(soldier5.getLastName(), soldier3.teamLeader(soldier5.getRank(), soldier5.getFirstName().charAt(0) + "." + soldier5.getLastName()));

		assertEquals(soldier5.getLastName(), soldier4.teamLeader(soldier5.getRank(), soldier5.getFirstName().charAt(0) + "." + soldier5.getLastName()));

		assertEquals(soldier3.getLastName(), soldier2.teamLeader(soldier3.getRank(), soldier3.getFirstName().charAt(0) + "." + soldier3.getLastName()));

	}

}