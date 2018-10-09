// @starter code from Kristy Gardner
// @author: Ana Verma

public class Node implements Comparable<Node>{

    int index;

    int distance; //how far is this node from the source node

    int posInHeap; //keep track of where the node is in the priority queue, if it is there at all (if -1, then the node is
    	//not in the PQ)

    Node parent;

    boolean inHeap; //keeps track of whether this node is still in the PQ or not 

    public int compareTo(Node other) {
    	if(distance < other.distance) return -1;
    	else if(distance > other.distance) return 1;

		return 0;
    }

    public Node(int i) {
		index = i;
    }

}
