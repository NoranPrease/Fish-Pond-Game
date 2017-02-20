package fishTesting;

import cmsc131Utilities.Random131;

import static org.junit.Assert.*;

import org.junit.Test;

import fishPond.Fish;
import fishPond.Model;
import fishPond.Plant;


public class StudentTests {

	@Test
	public void testConstructor(){
		Fish f = new Fish(1,2,3,Fish.LEFT);
		assertEquals(1, f.getRow());
		assertEquals(2, f.getCol());
		assertEquals(3, f.getSize());
		assertEquals(Fish.LEFT, f.getDirection());
		
		//Also tests copy constructor
		Fish f2 = new Fish(f);
		assertEquals(1, f2.getRow());
		assertEquals(2, f2.getCol());
		assertEquals(3, f2.getSize());
		assertEquals(Fish.LEFT, f2.getDirection());
		
	}
	@Test
	public void testPlantGrow() {
		Plant p = new Plant(2, 2, 50);
		p.grow();
		assertEquals(51, p.getSize());
	}

	@Test
	public void testBasicMoveFishTest() {
		Fish f1 = new Fish(0, 0, 100, Fish.DOWN);
		f1.move();
		assertEquals(Fish.DOWN,f1.getDirection());
	}

	@Test
	public void testTurnOneFish() {
		Random131.setDeterministic(1027);
		Model m = new Model(6, 6, 0, 0, 0);
		m.addFish(new Fish(1, 1, 2, Fish.LEFT));
		m.turnFish();
		assertEquals(Fish.RIGHT,m.getFish().get(0).getDirection());
	}

	@Test
	public void testMoveOneFish() {
		Random131.setDeterministic(1027);
		Model m = new Model(5, 5, 0, 0, 0);
		m.addFish(new Fish(1, 1, 2, Fish.LEFT));
		m.turnFish();
		assertEquals(Fish.RIGHT,m.getFish().get(0).getDirection());
		m.addPlant(new Plant(1,2,4));
		m.moveFish();
		assertEquals(6,m.getFish().get(0).getSize());
	}
	
	@Test
	public void testFight(){
		Fish f1 = new Fish (2,2,2,Fish.UP);
		Fish f2 = new Fish (3,3,3,Fish.UP);
		Fish f3 = new Fish (1,1,5,Fish.DOWN);
		Fish f4 = new Fish (4,4,5,Fish.LEFT);
		
		f2.fight(f1);
		assertFalse(f1.isAlive());
		assertEquals(f2.getSize(), 5);
		//If fish are same size, the current object should win
		f3.fight(f4);
		assertEquals(10, f3.getSize());
	}
	
	@Test
	public void testMove(){
		Fish f1 = new Fish (1,1,1,Fish.DOWN);
		f1.move();
		assertEquals(2, f1.getRow());
	}
}
