package Exam1;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class WeaponTest {



	Weapon weapon1 = new Weapon("Shotgun", 'A', 50, 200);

	Weapon weapon2 = new Weapon("Rifle", 'M', 85, 130);

	Weapon weapon3 = new Weapon("Bazooka", 'M', 115, 63);

	Weapon weapon4 = new Weapon("Grenade", 'M', 39, 178);

	Weapon weapon5 = new Weapon("AK-47", 'S', 76, 379);

	Weapon weapon6 = new Weapon("AK-47", 'S', 76, 379);

	Weapon weapon7 = new Weapon("Shotgun", 'A', 50, 200);

	Weapon weapon8 = new Weapon("Rifle", 'M', 85, 130);



	@Test

	public void testConstructorAndGetters() {

		assertEquals("Shotgun", weapon1.getName());

		assertEquals('A', weapon1.getType());

		assertEquals(50, weapon1.getDamage());

		assertEquals(200, weapon1.getAmmo());



		assertEquals("Rifle", weapon2.getName());

		assertEquals('M', weapon2.getType());

		assertEquals(85, weapon2.getDamage());

		assertEquals(130, weapon2.getAmmo());



		assertEquals("Bazooka", weapon3.getName());

		assertEquals('M', weapon3.getType());

		assertEquals(115, weapon3.getDamage());

		assertEquals(63, weapon3.getAmmo());

	}



	@Test

	public void testSetters() {

		weapon1.setName("Handgun");

		weapon1.setType('M');

		weapon1.setDamage(30);

		weapon1.setAmmo(150);

		assertEquals("Handgun", weapon1.getName());

		assertEquals('M', weapon1.getType());

		assertEquals(30, weapon1.getDamage());

		assertEquals(150, weapon1.getAmmo());



		weapon2.setName("Machine Gun");

		weapon2.setType('A');

		weapon2.setDamage(130);

		weapon2.setAmmo(400);

		assertEquals("Machine Gun", weapon2.getName());

		assertEquals('A', weapon2.getType());

		assertEquals(130, weapon2.getDamage());

		assertEquals(400, weapon2.getAmmo());



		weapon3.setName("Grenade Launcher");

		weapon3.setType('S');

		weapon3.setDamage(48);

		weapon3.setAmmo(125);

		assertEquals("Grenade Launcher", weapon3.getName());

		assertEquals('S', weapon3.getType());

		assertEquals(48, weapon3.getDamage());

		assertEquals(125, weapon3.getAmmo());

	}



	@Test

	public void testCraftACopy() {

		Weapon copy1 = weapon4.craftACopy();

		assertTrue(weapon4 != copy1);

		assertEquals(weapon4.getName(), copy1.getName());

		assertEquals(weapon4.getType(), copy1.getType());

		assertEquals(weapon4.getDamage(), copy1.getDamage());

		assertEquals(weapon4.getAmmo(), copy1.getAmmo());



		Weapon copy2 = weapon5.craftACopy();

		assertTrue(weapon5 != copy2);

		assertEquals(weapon5.getName(), copy2.getName());

		assertEquals(weapon5.getType(), copy2.getType());

		assertEquals(weapon5.getDamage(), copy2.getDamage());

		assertEquals(weapon5.getAmmo(), copy2.getAmmo());

	}



	@Test

	public void testEquals() {

		assertFalse(weapon1.equals(weapon2));

		assertFalse(weapon2.equals(weapon3));

		assertFalse(weapon3.equals(weapon4));

		assertFalse(weapon4.equals(weapon5));

		assertTrue(weapon5.equals(weapon6));

	}

	

	@Test

	public void testToString() {

		assertEquals("Name: Grenade, Type: M, Damage: 39, Ammo: 178", weapon4.toString());

		assertEquals("Name: AK-47, Type: S, Damage: 76, Ammo: 379", weapon5.toString());

		assertEquals("Name: Shotgun, Type: A, Damage: 50, Ammo: 200", weapon7.toString());

		assertEquals("Name: Rifle, Type: M, Damage: 85, Ammo: 130", weapon8.toString());

	}

	

	@Test

	public void testReload() {

		weapon4.reload(5, 2.0);

		assertEquals(203, weapon4.getAmmo());

		weapon4.reload(25, 0.5);

		assertEquals(208, weapon4.getAmmo());

		weapon4.reload(30, -2);

		assertEquals(208, weapon4.getAmmo());

		weapon4.reload(3, 10);

		assertEquals(59257, weapon4.getAmmo());

	}

}