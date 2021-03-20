/*
 * this is interactive interactive window 
 * 
 * 
 * */

	import java.awt.BorderLayout;
	import java.awt.Dimension;
	import java.awt.event.ContainerListener;
	import java.awt.event.KeyListener;

	import javax.swing.*;


	public class SnakeApp {

		public void init() {
			
			JFrame window = new JFrame("Snake");
			
			//Grid size is ((50*10(nodes size))*(50*10))
			Grid myGrid = new Grid (50 *Setting.DEFAULT_NODE_SIZE, 50*Setting.DEFAULT_NODE_SIZE);
			
			GameView gameView = new GameView(myGrid);
			
			gameView.init();
			
			GameController gameController = new GameController(myGrid);	
			//setting the windows size  
			window.setPreferredSize(new Dimension(515, 535));	
			
			//add canvas and border in the windows  
			window.add(gameView.getCanvas(),BorderLayout.CENTER);
			
			//draw snake and grid
			GameView.draw();		
	
			//size of windows resizeable	
			window.setResizable(false);			
	
			//add key listener 	
			window.addKeyListener((KeyListener)gameController);
			//start thread 
			new Thread(gameController).start();			

			//windows closes	
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//
			window.pack();
			window.setVisible(true);
		}
		
		public static void main(String[] args) {
	        SnakeApp snakeApp = new SnakeApp();
	        snakeApp.init();
	        
	    }
		
}


