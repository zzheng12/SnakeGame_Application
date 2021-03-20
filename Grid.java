/*
 * Grid(int width , int height) 
 * 1.This grid should hold snake
 * if hold the snake, return true; or else 
 * 2.randomly produce food.
 * 3.move direction of snake 
 * */
public class Grid {
	
	private Snake snake; 
	private Node food;
	//define grid's width and height
	private final int width, height;	
	//default direction is left, if no operation keep straight 
	private Direction snakeDirection = Direction.LEFT;
	
	//initialization
	public Grid(int w, int h) {
		this.width = w; 
		this.height = h;	
		//status = new boolean [width][height];		
		initSnake();
		food = createFood();
	}
	
	private Snake initSnake() {
		//create snake object
		snake = new Snake();
		// set Snake's body, position(Node[width/2][height/2])
		//Original length is 3
		//update the status of grid and snake
		int x , y; 
		x = width/2;
		y = height/2;
		for (int i = 0; i<4; i++) {
			snake.addTail(new Node(x,y));
			x = x + Setting.DEFAULT_NODE_SIZE;
		}
		return snake;
	}
	
	private Node createFood() {
		//using "random" in java to set 'x'and 'y'
		//ZiHan
		int x, y;
		do {
			x = (int)(Math.random()*100);
			y = (int)(Math.random()*100);
		}while(x>=this.width || y>=this.height);
		
		food = new Node(x, y);
		return food;		
	}
	
	
	public boolean eatFood() {
		//store the previous tail 
		Node preTail; 		
		//move snake with current (direction)
		preTail = snake.move(snakeDirection);		
		//snake in the grid
		if (snake.getHead().getX() >=0 && snake.getHead().getX()<= width && snake.getHead().getY()>=0 && snake.getHead().getY()<=height) {
			if (snake.getHead().equals(food)) {
				//add the preTail back,and create a new food;    
				snake.addTail(preTail);				
				food = this.createFood();
			}
			return true;
		}
		return false;  
	}
	
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
	public Snake getSnake() {
		return this.snake;
	}
	public Node getFood() {
		return this.food;
	}	
	public void changeDirection(Direction d) {
		this.snakeDirection = d;		
	}
	
	
	
}
