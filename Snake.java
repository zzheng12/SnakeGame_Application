import java.util.Iterator;
import java.util.LinkedList;

/*
 * This is snake class 
 * 
 * */
public class Snake {
	
		
	//using LinkedList because we need to add or remove items, 
	//which is too expensive for other list.    
	private LinkedList<Node> body = new LinkedList<>();
	
	//boolean Node in Snake body
	//
	public boolean hasNode(Node node) {
			Iterator<Node> ite = body.iterator();
			Node n = new Node(0,0);
			while(ite.hasNext()) {
	    		n = ite.next();
	    		if(n.getX() == node.getX() && n.getY() == node.getY()) {
	    			return true;
	    		}
	    	}
	    	return false;
		}
				
	//based on direction update body of snake
	//return the tail of Node before move; 
	public Node move(Direction direction) {
		Node n; 
		
		//use the switch statement to select one of many directions.  
		switch(direction) {
		
		//?don't understand what is DEAULT_NODE_SIZE
				
		//????+- 
		case UP: n = new Node(this.getHead().getX(), this.getHead().getY() + Setting.DEFAULT_NODE_SIZE); break;
		case DOWN: n = new Node(this.getHead().getX(), this.getHead().getY() - Setting.DEFAULT_NODE_SIZE); break;
		case RIGHT: n = new Node(this.getHead().getX()+Setting.DEFAULT_NODE_SIZE,this.getHead().getY()); break;
		default: n = new Node(this.getHead().getX()-Setting.DEFAULT_NODE_SIZE,this.getHead().getY());
		}
		
		Node r = this.body.getLast();
		this.body.addFirst(n);
		this.body.removeLast();
		
		return r;
		
	}
	
	
	
	//constructor: initialize objects 
	//linkedList getFirst was used;
	public Node getHead() {
		return body.getFirst();
	}
	
	//linkedList addLast was used;
	public Node addTail(Node area) {
		this.body.addLast(area);
		return area;		
	}
	
	//linkedList body-list;
	public LinkedList<Node> getBody(){
		return body;
	} 
	
	
}
