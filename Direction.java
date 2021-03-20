/*
 * using to control the direction of snake
 * 
 * */
public enum Direction{
	UP(0),
	RIGHT(1),
	DOWN(2),
	LEFT(3);
	
	private int directionCode;
	
	//method for directionCode; 
	public int getDirectionCode() {
		return directionCode;
	}
	
	//
	Direction (int directionCode){
		this.directionCode = directionCode; 
	}
	
}