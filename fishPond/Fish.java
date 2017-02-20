package fishPond;

import cmsc131Utilities.Random131;

/**
 * The state of a fish consists of its position in the pond (row and         
 * column), it's size, and the direction in which it is moving (UP, DOWN,    
 * LEFT, or RIGHT).                                                          
 * <p>                                                                 
 * A fish moves, eats other fish, eats plants, and shrinks over time.        
 * <p>                                                                          
 * STUDENTS MAY NOT ADD ANY FIELDS OR PUBLIC METHODS!  (You may add private  
 * methods of your own, if you wish.)                                        
 *                                                                           
 * @author Nolan Kraynak        
 */

public class Fish {

	/** Initial size of each fish when simulation begins */
	public static final int FISH_STARTING_SIZE = 100;
	
	/** Maximum size for a fish */
	public static final int MAX_FISH_SIZE = 1000;
	
	/** Code for "Left" fish direction */
	public static final int LEFT = 10;
	
	/** Code for "Right" fish direction */
	public static final int RIGHT = 11;
	
	/** Code for "Up" fish direction */
	public static final int UP = 12;
	
	/** Code for "Down" fish direction */
	public static final int DOWN = 13;
	
	/*State of this fish */
	private int row, col, size, direction;
	
	/** Simply initializes the state of the fish with these parameters */
	public Fish(int row, int col, int size, int direction) {
		this.col = col;
		this.row = row;
		this.size = size;
		this.direction = direction;
	}
	
	/** Standard copy constructor -- just copies the fields */
	public Fish(Fish x) {
		this.col = x.col;
		this.row = x.row;
		this.size = x.size;
		this.direction = x.direction;
	}
	
	/** Fish size increased by nutritionalValue. */
	public void eat(int nutritionalValue) {
		this.size += nutritionalValue;
	}
	
	/** Returns true if size is greater than zero, false otherwise */
	public boolean isAlive() {
		return (this.size>0) ? true : false;
	}
	
	/** Size is decreased by TWO.  */
	public void shrink() { 
		this.size -= 2;
	}
	
	/* This fish eats the other fish.  I.e. This fish's size is increased by
	 * the size of the fish "other".  The size of "other" is set to 0. */
	private void eat(Fish other) {
		this.size += other.getSize();
		other.size = 0;
	}
	
	/** Implement this however you want -- it's for your own purposes while debugging */
	public String toString() {
		return " Row:"+row+" Col:"+col+" Size:"+size+" Direction:"+direction;
	}
	
	/** The current object battles the parameter (other).  Whichever one is larger
	 * eats the other by calling the private "eat" method.  In cases where the
	 * sizes of the two fish are exactly the same, have the current object win! */
	public void fight(Fish other) {
		if(this.getSize() >= other.getSize()){
			this.eat(other);
		}else other.eat(this);
	}
	
	/**The fish's location (row or col) is adjusted by ONE unit, depending on the 
	 * fish's current direction.  For example, if the current direction is "UP", then
	 * the fish's row should be decremented.
	 * <p>
	 * If the fish's current direction is not equal to one of the static constants UP, 
	 * DOWN, LEFT, or RIGHT, then this method will throw an 
	 * IllegalFishDirectionException, passing the fish's direction to the constructor. 
	 */
	public void move() {
		if(isAlive()==true){
			switch(this.direction){
			case LEFT: this.col-=1;
				break;
			case RIGHT: this.col+=1;
				break;
			case UP: this.row-=1;
				break;
			case DOWN: this.row+=1;
				break;
			default: throw new IllegalFishDirectionException(this.direction);
			}
		}
	}
	
	/**The fish's direction is randomly determined (UP, DOWN, LEFT or RIGHT).  
	 * Sometimes the resulting direction will be the same as the original one.
	 * <p>
	 * YOU MUST FOLLOW THE INSTRUCTIONS BELOW OR YOU WILL NOT PASS OUR TESTS!
	 * <p>
	 * Call Random131.getRandomInteger(4).
	 * <p>
	 * If the value is 0, set the direction to UP.  If 1, set to DOWN.  If 2, set to 
	 * LEFT.  If 3, set to RIGHT.  IMPORTANT:  DO NOT SET THE DIRECTION TO THE VALUES 
	 * 0, 1, 2, OR 3 -- directions must be set using the static constants (UP, DOWN, 
	 * LEFT, RIGHT). */
	public void setRandomDirection() {
		int newDirection = Random131.getRandomInteger(4);
		switch (newDirection){
		case 0: this.direction = UP;
			break;
		case 1: this.direction = DOWN;
			break;
		case 2: this.direction = LEFT;
			break;
		case 3: this.direction = RIGHT;
			break;	
		}
	}
	
	/** Returns size */
	public int getSize() {
		return size;
	}
	
	/** Returns row */
	public int getRow() {
		return row;
	}
	
	/** Returns column */
	public int getCol() {
		return col;
	}
	
	/** Returns direction (UP, DOWN, LEFT, or RIGHT) */
	public int getDirection() {
		switch(direction){
		case 10: direction = LEFT;
			break;
		case 11: direction =  RIGHT;
			break;
		case 12: direction = UP;
			break;
		case 13: direction = DOWN;
		}
		return direction;
	}
}
