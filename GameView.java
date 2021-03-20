import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameView {

    private final Grid grid;
    private static JPanel canvas;

    
    public void init() {
        	canvas = new JPanel() {
            //@Override
            public void paintComponent(Graphics graphics) {
            	//super.paintComponent(graphics);
            	
            	//draw background 
                drawGridBackground(graphics);
                //draw snake
                drawSnake(graphics, grid.getSnake());
                //draw food 
                drawFood(graphics, grid.getFood());
            }
        };
    }
     
    public void drawSnake(Graphics graphics, Snake snake) {
    	//write it as iterator to represent snake body(green)
    	//snake head is red
    	Iterator<Node> it = snake.getBody().iterator();
    	Node n = new Node(0,0);
    	n = it.next();
		this.drawSquare(graphics, n, Color.red );     
    	while(it.hasNext()) {
    		n = it.next();
    		this.drawSquare(graphics, n, Color.green );
    		}  	
    }
    
    //food is blue
    public void drawFood(Graphics graphics, Node squareArea) {
    	this.drawCircle(graphics, squareArea, Color.blue);
    }
    /*
    public static void showGameOverMessage() {
    	int willContinue = JOptionPane.showConfirmDialog(null, "Gave over, do you want play again?", null, JOptionPane.YES_NO_OPTION);
    	if (willContinue == 0) {
    		SnakeApp snakeGame = new SnakeApp();
    		snakeGame.init();
    	}else {
    		System.exit(0);
    	}
    }
    */

    public void drawGridBackground(Graphics graphics) {
    	graphics.setColor(Color.gray);
    	for(int i=0 ; i <= 50 ; i++) {
    		graphics.drawLine(0, i*Setting.DEFAULT_NODE_SIZE, this.grid.getWidth(), i*Setting.DEFAULT_NODE_SIZE);
    	}
    	for(int i=0 ; i <= 50 ; i++) {
    		graphics.drawLine(i*Setting.DEFAULT_NODE_SIZE, 0,  i*Setting.DEFAULT_NODE_SIZE , this.grid.getHeight());
    	}	
 
    }

    /*
     * 
     * */	
    private void drawSquare(Graphics graphics, Node squareArea, Color color) {
        graphics.setColor(color);
        int size = Setting.DEFAULT_NODE_SIZE;
        graphics.fillRect(squareArea.getX() , squareArea.getY(), size, size );      
    }

    private void drawCircle(Graphics graphics, Node squareArea, Color color) {
        graphics.setColor(color);
        int size = Setting.DEFAULT_NODE_SIZE;
        graphics.fillOval(squareArea.getX() , squareArea.getY() , size, size);
    }
    
    public static void draw() {
        canvas.repaint();
    }

    public JPanel getCanvas() {
        return canvas;
    }
    
    public GameView(Grid grid) {
        this.grid = grid;
    }

	public static void showGameOverMessage() {
		JOptionPane.showMessageDialog(null,"Game Over", "Game Over", JOptionPane.INFORMATION_MESSAGE);
		
	}

}