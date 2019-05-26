package Exam2;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MotorVehicleTest {
	
	MotorVehicle mv0;
	MotorVehicle mv1;
	MotorVehicle mv2;
	MotorVehicle mv3;
	MotorVehicle mv4;
	MotorVehicle mv5;
	MotorVehicle mv6;
	MotorVehicle mv7;
	MotorVehicle mv8;
	MotorVehicle mv9;
	MotorVehicle mv10;
	MotorVehicle[] mvs;

	
	// Methods annotated with @Before are repeatedly executed once before running each test method
	@Before
	public void setupTest() {
		mv0 = new MotorVehicle("Tesla","Roadster","AAA111",2018,5000,5,10000);
		mv1 = new MotorVehicle("Tesla","Model 3","AAA112",2017,2000,3,8000);
		mv2 = new MotorVehicle("Volkswagen","Beetle","VWB111",1970,150000,7,20000);
		mv3 = new MotorVehicle("Honda","Fit","AAZ501",2014,10000,2,15000);
		mv4 = new MotorVehicle("Tesla","Model 3","AAA200",2017,6000,3,7000);
		mv5 = new MotorVehicle("Tesla","Model 3","AEE000",2018,10000,10,100000);
		mv6 = new MotorVehicle("Toyota","Prius","GOH194",2011,50000,5,10000);
		mv7 = new MotorVehicle("Toyota","Yaris","FFF322",2008,100000,5,5000);
		mv8 = new MotorVehicle("Ford","Fiesta","AAA131",2014,5000,5,10000);
		mv9 = new MotorVehicle("Tesla","Roadster","AAA117",2017,3000,5,10000);
		mv10 = new MotorVehicle("Fiat","500","AAA119",2012,3000,5,10000);
		mvs = new MotorVehicle[]{mv0,mv1,mv2,mv3,mv4,mv5,mv6,mv7,mv8,mv9};
	}
	
	@Test
	public void testFindLeastMileage() {
		MotorVehicle result = MotorVehicle.findLeastMileage(mvs);
		assertFalse("The method returns null",result==null);
		assertFalse("The mv0 is not the vehicle with the least mileage (5000)",result==mv0);
		assertTrue("The mv1 is the vehicle with the least mileage (2000)",result==mv1);
		assertFalse("The mv2 is not the vehicle with the least mileage (150000)",result==mv2);
		assertFalse("The mv3 is not the vehicle with the least mileage (10000)",result==mv3);
		assertFalse("The mv4 is not the vehicle with the least mileage (6000)",result==mv4);
		assertFalse("The mv5 is not the vehicle with the least mileage (10000)",result==mv5);
		assertFalse("The mv6 is not the vehicle with the least mileage (50000)",result==mv6);
		assertFalse("The mv7 is not the vehicle with the least mileage (100000)",result==mv7);
		assertFalse("The mv8 is not the vehicle with the least mileage (5000)",result==mv8);
		assertFalse("The mv9 is not the vehicle with the least mileage (3000)",result==mv9);
		mvs[1].addMileage(5000);
		result = MotorVehicle.findLeastMileage(mvs);
		assertFalse("The mv0 is not the vehicle with the least mileage (5000)",result==mv0);
		assertFalse("The mv1 is not the vehicle with the least mileage (7000)",result==mv1);
		assertFalse("The mv2 is not the vehicle with the least mileage (20000)",result==mv2);
		assertFalse("The mv3 is not the vehicle with the least mileage (10000)",result==mv3);
		assertFalse("The mv4 is not the vehicle with the least mileage (6000)",result==mv4);
		assertFalse("The mv5 is not the vehicle with the least mileage (10000)",result==mv5);
		assertFalse("The mv6 is not the vehicle with the least mileage (50000)",result==mv6);
		assertFalse("The mv7 is not the vehicle with the least mileage (100000)",result==mv7);
		assertFalse("The mv8 is not the vehicle with the least mileage (5000)",result==mv8);
		assertTrue("The mv9 is the vehicle with the least mileage (3000)",result==mv9);
	}
	@Test
	public void testfilterByMakeModel() {
		MotorVehicle[] result;
		MotorVehicle[] comp = mvs;
		assertFalse("The method returns null",mv0.filterByMakeModel(mvs)==null);
		
		result = mv0.filterByMakeModel(mvs);
		MotorVehicle[] comp0 = {mv0,mv9};
		assertTrue("The mv0 has itself and other two with the same make and model",result.length==comp0.length);
		assertTrue("The first vehicle must be mv0",result[0]==comp0[0]);
		assertTrue("The second vehicle must be mv9",result[1]==comp0[1]);
		assertTrue("You modified the inventory",comp==mvs);
		
		result = mv1.filterByMakeModel(mvs);
		MotorVehicle[] comp1 = {mv1,mv4,mv5};
		assertTrue("The mv1 has itself and other one with the same make and model",result.length==comp1.length);
		assertTrue("The first vehicle must be mv1",result[0]==comp1[0]);
		assertTrue("The second vehicle must be mv4",result[1]==comp1[1]);
		assertTrue("The third vehicle must be mv5",result[2]==comp1[2]);
		assertTrue("You modified the inventory",comp==mvs);
		
		result = mv2.filterByMakeModel(mvs);
		MotorVehicle[] comp2 = {mv2};
		assertTrue("The mv1 has itself and other two with the same make and model",result.length==comp2.length);
		assertTrue("The first vehicle must be mv2",result[0]==comp2[0]);
		assertTrue("You modified the inventory",comp==mvs);
		
		result = mv3.filterByMakeModel(mvs);
		MotorVehicle[] comp3 = {mv3};
		assertTrue("The mv1 has itself with the same make and model",result.length==comp3.length);
		assertTrue("The first vehicle must be mv3",result[0]==comp3[0]);
		assertTrue("You modified the inventory",comp==mvs);
		
		result = mv4.filterByMakeModel(mvs);
		MotorVehicle[] comp4 = {mv1,mv4,mv5};
		assertTrue("The mv4 has itself and other one with the same make and model",result.length==comp4.length);
		assertTrue("The first vehicle must be mv1",result[0]==comp4[0]);
		assertTrue("The second vehicle must be mv4",result[1]==comp4[1]);
		assertTrue("The third vehicle must be mv5",result[2]==comp4[2]);
		assertTrue("You modified the inventory",comp==mvs);
		
		result = mv5.filterByMakeModel(mvs);
		MotorVehicle[] comp5 = {mv1,mv4,mv5};
		assertTrue("The mv4 has itself and other one with the same make and model",result.length==comp5.length);
		assertTrue("The first vehicle must be mv1",result[0]==comp5[0]);
		assertTrue("The second vehicle must be mv4",result[1]==comp5[1]);
		assertTrue("The third vehicle must be mv5",result[2]==comp5[2]);
		assertTrue("You modified the inventory",comp==mvs);
		
		result = mv6.filterByMakeModel(mvs);
		MotorVehicle[] comp6 = {mv6};
		assertTrue("The mv6 has itself with the same make and model",result.length==comp6.length);
		assertTrue("The first vehicle must be mv3",result[0]==comp6[0]);
		assertTrue("You modified the inventory",comp==mvs);
		
		result = mv7.filterByMakeModel(mvs);
		MotorVehicle[] comp7 = {mv7};
		assertTrue("The mv7 has itself with the same make and model",result.length==comp7.length);
		assertTrue("The first vehicle must be mv3",result[0]==comp7[0]);
		assertTrue("You modified the inventory",comp==mvs);
		
		result = mv8.filterByMakeModel(mvs);
		MotorVehicle[] comp8 = {mv8};
		assertTrue("The mv8 has itself with the same make and model",result.length==comp8.length);
		assertTrue("The first vehicle must be mv3",result[0]==comp8[0]);
		assertTrue("You modified the inventory",comp==mvs);
		
		result = mv9.filterByMakeModel(mvs);
		MotorVehicle[] comp9 = {mv0,mv9};
		assertTrue("The mv9 has itself and other two with the same make and model",result.length==comp9.length);
		assertTrue("The first vehicle must be mv0",result[0]==comp9[0]);
		assertTrue("The second vehicle must be mv9",result[1]==comp9[1]);
		assertTrue("You modified the inventory",comp==mvs);
	}

	@Test
	public void testAllHaveLessMileage() {
		//Test if method always returns false or true
		boolean allFalse = false;
		boolean allTrue = true;
		
		allFalse = allFalse||mv0.allHaveLessMileage(mvs);
		allFalse = allFalse||mv1.allHaveLessMileage(mvs);
		allFalse = allFalse||mv2.allHaveLessMileage(mvs);
		allFalse = allFalse||mv3.allHaveLessMileage(mvs);
		allFalse = allFalse||mv4.allHaveLessMileage(mvs);
		allFalse = allFalse||mv5.allHaveLessMileage(mvs);
		allFalse = allFalse||mv6.allHaveLessMileage(mvs);
		allFalse = allFalse||mv7.allHaveLessMileage(mvs);
		allFalse = allFalse||mv8.allHaveLessMileage(mvs);
		allFalse = allFalse||mv9.allHaveLessMileage(mvs);
		
		allTrue = allTrue&&mv0.allHaveLessMileage(mvs);
		allTrue = allTrue&&mv1.allHaveLessMileage(mvs);
		allTrue = allTrue&&mv2.allHaveLessMileage(mvs);
		allTrue = allTrue&&mv3.allHaveLessMileage(mvs);
		allTrue = allTrue&&mv4.allHaveLessMileage(mvs);
		allTrue = allTrue&&mv5.allHaveLessMileage(mvs);
		allTrue = allTrue&&mv6.allHaveLessMileage(mvs);
		allTrue = allTrue&&mv7.allHaveLessMileage(mvs);
		allTrue = allTrue&&mv8.allHaveLessMileage(mvs);
		allTrue = allTrue&&mv9.allHaveLessMileage(mvs);
		
		assertTrue("The method always returns false",allFalse);
		assertFalse("The method always returns true",allTrue);
		
		assertFalse("The mv0 is not the vehicle with the most mileage (5000)",mv0.allHaveLessMileage(mvs));
		assertFalse("The mv1 is not the vehicle with the most mileage (2000)",mv1.allHaveLessMileage(mvs));
		assertTrue("The mv2 is the vehicle with the most mileage (150000)",mv2.allHaveLessMileage(mvs));
		assertFalse("The mv3 is not the vehicle with the most mileage (10000)",mv3.allHaveLessMileage(mvs));
		assertFalse("The mv4 is not the vehicle with the most mileage (6000)",mv4.allHaveLessMileage(mvs));
		assertFalse("The mv5 is not the vehicle with the most mileage (10000)",mv5.allHaveLessMileage(mvs));
		assertFalse("The mv6 is not the vehicle with the most mileage (50000)",mv6.allHaveLessMileage(mvs));
		assertFalse("The mv7 is not the vehicle with the most mileage (100000)",mv7.allHaveLessMileage(mvs));
		assertFalse("The mv8 is not the vehicle with the most mileage (5000)",mv8.allHaveLessMileage(mvs));
		assertFalse("The mv9 is not the vehicle with the most mileage (3000)",mv9.allHaveLessMileage(mvs));
		MotorVehicle newMV = new MotorVehicle("Volkswagen","Beetle","VWB111",1970,1500,7,20000);
		mvs[2] = newMV;
		assertFalse("The mv0 is not the vehicle with the most mileage (5000)",mv0.allHaveLessMileage(mvs));
		assertFalse("The mv1 is not the vehicle with the most mileage (2000)",mv1.allHaveLessMileage(mvs));
		assertFalse("The newMV is not the vehicle with the most mileage (1500)",newMV.allHaveLessMileage(mvs));
		assertFalse("The mv3 is not the vehicle with the most mileage (10000)",mv3.allHaveLessMileage(mvs));
		assertFalse("The mv4 is not the vehicle with the most mileage (6000)",mv4.allHaveLessMileage(mvs));
		assertFalse("The mv5 is not the vehicle with the most mileage (10000)",mv5.allHaveLessMileage(mvs));
		assertFalse("The mv6 is not the vehicle with the most mileage (50000)",mv6.allHaveLessMileage(mvs));
		assertTrue("The mv7 is the vehicle with the most mileage (100000)",mv7.allHaveLessMileage(mvs));
		assertFalse("The mv8 is not the vehicle with the most mileage (5000)",mv8.allHaveLessMileage(mvs));
		assertFalse("The mv9 is not the vehicle with the most mileage (3000)",mv9.allHaveLessMileage(mvs));
	}

	@Test
	public void testBuy() {
		MotorVehicle[] newList = {null,null,null,null,null,null,null,null,null,null,};
		
		MotorVehicle[] result1 = mv0.buy(newList);
		assertFalse("The method returns null",result1==null);
		assertTrue("There needs to be an new car (mv0) at position 0",result1[0]==mv0);
		assertTrue("There needs to be only one car",countVehicles(result1)==1);
		MotorVehicle[] result2 = mv0.buy(mvs);
		assertTrue("The new inventory has 10 cars",result2.length==10);
		
		result1 = mv1.buy(newList);
		assertTrue("There needs to be an new car (mv1) at position 1",result1[1]==mv1);
		assertTrue("There needs to be two cars",countVehicles(result1)==2);
		result2 = mv1.buy(result2);
		assertTrue("The new inventory has 10 cars",result2.length==10);
		
		result1 = mv2.buy(newList);
		assertTrue("There needs to be an new car (mv2) at position 2",result1[2]==mv2);
		assertTrue("There needs to be three cars",countVehicles(result1)==3);
		result2 = mv2.buy(result2);
		assertTrue("The new inventory has 10 cars",result2.length==10);
		
		result1 = mv3.buy(newList);
		assertTrue("There needs to be an new car (mv3) at position 3",result1[3]==mv3);
		assertTrue("There needs to be four cars",countVehicles(result1)==4);
		result2 = mv3.buy(result2);
		assertTrue("The new inventory has 10 cars",result2.length==10);
		
		result1 = mv4.buy(newList);
		assertTrue("There needs to be an new car (mv4) at position 0",result1[4]==mv4);
		assertTrue("There needs to be five cars",countVehicles(result1)==5);
		result2 = mv4.buy(result2);
		assertTrue("The new inventory has 10 cars",result2.length==10);
		
		result1 = mv5.buy(newList);
		assertTrue("There needs to be an new car (mv5) at position 0",result1[5]==mv5);
		assertTrue("There needs to be six cars",countVehicles(result1)==6);
		result2 = mv5.buy(result2);
		assertTrue("The new inventory has 10 cars",result2.length==10);
		
		result1 = mv6.buy(newList);
		assertTrue("There needs to be an new car (mv6) at position 0",result1[6]==mv6);
		assertTrue("There needs to be seven",countVehicles(result1)==7);
		result2 = mv6.buy(result2);
		assertTrue("The new inventory has 10 cars",result2.length==10);
		
		result1 = mv7.buy(newList);
		assertTrue("There needs to be an new car (mv7) at position 0",result1[7]==mv7);
		assertTrue("There needs to be eight cars",countVehicles(result1)==8);
		result2 = mv7.buy(result2);
		assertTrue("The new inventory has 10 cars",result2.length==10);
		
		result1 = mv8.buy(newList);
		assertTrue("There needs to be an new car (mv8) at position 0",result1[8]==mv8);
		assertTrue("There needs to be nine cars",countVehicles(result1)==9);
		result2 = mv8.buy(result2);
		assertTrue("The new inventory has 10 cars",result2.length==10);
		
		result1 = mv9.buy(newList);
		assertTrue("There needs to be an new car (mv9) at position 0",result1[9]==mv9);
		assertTrue("There needs to be ten cars",countVehicles(result1)==10);
		result2 = mv9.buy(result2);
		assertTrue("The new inventory has 10 cars",result2.length==10);
		
		result1 = mv10.buy(newList);
		assertTrue("Must return null if inventory full",result1 == null);
	}
	
	// Returns number of MotorVehicles in array before first empty slot.
	// Returns -1 if non-empty slot found after empty slot.
	public int countVehicles(MotorVehicle[] a) {
		int count = 0;
		boolean nullFound = false;
		for (int i=0; i<a.length; i++) {
			if ((a[i] != null) && nullFound) return -1; // Array not compact
			if (a[i] != null) count++;
			if (a[i] == null) nullFound = true;
		}
		return count;
	}
}