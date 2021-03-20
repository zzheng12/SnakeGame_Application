//define Node;
//snake was connected by lots of nodes;
//represent node's location/status;

public class Node {
	private final int x;
    private final int y;	    
    public Node(int x, int y) {
        this.x = (x/10)*10;
        this.y = (y/10)*10;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    
    //
    public boolean equals(Node node) {
    	return (x == node.getX() && y == node.getY());
    	
    }
}
