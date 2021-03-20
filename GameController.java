/*
 * controller's duty is to receive some evens which were passed from SnakeApp;
 * like: user input(up, down, left, right)
 * then pass to "Grid", let Grid update the Snake's status, simultaneously pass the newest status to let SnakeApp to display;    
 * */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements KeyListener, Runnable {
    
	private Grid grid;
	
	//decide 
	private boolean running;   
	private boolean over = false;
	
	GameController(Grid g) {
		this.grid = g;
		this.running = true;
	}
	
	//using listener interface for receiving keyboard events 
	//a keyboard event is generated when a key is pressed, released, or typed.  
	@Override
    public void keyPressed(KeyEvent k) {
       //getKeyCode will return a virtual key code(which keyboard key has been pressed)
    	int keyCode = k.getKeyCode();
        switch(keyCode) {
        case KeyEvent.VK_UP:	grid.changeDirection(Direction.UP); break;
        case KeyEvent.VK_DOWN:	grid.changeDirection(Direction.DOWN); break;
        case KeyEvent.VK_LEFT:	grid.changeDirection(Direction.LEFT); break;
        case KeyEvent.VK_RIGHT:	grid.changeDirection(Direction.RIGHT); break;        
        }        
        isOver(grid.eatFood());
        GameView.draw();
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    
    //when game over, show the "game over message", and exit. 
    public void isOver(boolean o) {
    	if(!o) {
    		this.running = false;
    		GameView.showGameOverMessage();
    		System.exit(0);
    	}
    }
    
	@Override
	public void run() {
		
		while (running) {
            try {
            	//used to pause the execution of current thread for seconds (No sleep at all) 
                Thread.sleep(Setting.DEFAULT_MOVE_INTERVAL);
                //if eatFood is true, then keep going and draw a new game 
                //if false, then game over              
                isOver(grid.eatFood());
                GameView.draw();
            } catch (InterruptedException e) {
                break;
            }          
        }
        running = false;
    }

	public boolean isOver() {
		return over;
	}

	public void setOver(boolean over) {
		this.over = over;
	}
		
}