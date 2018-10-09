// @starter code from: Kristy Gardner
// @author of the methods dijkstra and printPath: Ana Verma

import java.lang.Math;
import java.util.Stack;

public class Dijkstra {

    public void run(int n) {
		int[][] graph = new int[n][n];
		fillRandomGraph(graph);

		Node[] myNodes = new Node[graph.length];
		for(int i = 0; i < graph.length; i++) {
		    myNodes[i] = new Node(i);
		}

		print(graph);
		dijkstra(graph, myNodes);

		printPath(myNodes[myNodes.length - 1]);


    }

    //dijkstra
    public void dijkstra(int[][] graph, Node[] nodes){
    	nodes[0].distance = 0;
    	Heap PQ = new Heap();

    	PQ.add(nodes[0]); //add source to the Priority Queue

    	for(int i = 1; i < nodes.length; i++){
    		nodes[i].distance = Integer.MAX_VALUE;
    		nodes[i].parent = null;

    		PQ.add(nodes[i]);
    	}

    	while(!PQ.isEmpty()){
    		Node x = PQ.remove();

    		int i = x.index;

    		for(int j = 0; j < graph.length; j++){
    			if(graph[i][j] != 0){
    				Node v = nodes[j];

    				if(v.inHeap){
    					int pathThroughX = x.distance + graph[i][j];

    					if(pathThroughX < v.distance){
    						PQ.decreaseKey(v, pathThroughX);
    						v.parent = x;
    					}
    				}
    			}
    		}
    	}

    }

    public void printPath(Node node){
    	Stack<Node> stack = new Stack<Node>();

    	Node toAdd = node;

    	while(toAdd != null){
    		stack.push(toAdd);
    		toAdd = toAdd.parent;
    	}

    	System.out.println("Path from Node 0 to Node" + node.index);

    	while(!stack.empty()){
    		System.out.print(" " + stack.pop().index + " ");
    	}

    	System.out.println();
    }


    public void print(int[][] graph) {
		for(int i = 0; i < graph.length; i++) {
		    for(int j = 0; j < graph.length; j++) {
				System.out.print(graph[i][j] + " ");
		    }
		    System.out.println();
		}	
    }

    public void fillRandomGraph(int[][] graph) {
		for(int i = 0; i < graph.length; i++) {
		    for(int j = i+1; j < graph.length; j++) {
				double rand = Math.random();
				if(rand < 0.8) {
				    graph[i][j] = (int)(Math.random() * 10);
				    graph[j][i] = graph[i][j];
				}
				else{
				    graph[i][j] = 0;
				    graph[j][i] = 0;
				}
		    }
		}

    }

    public static void main(String [] args) {
		if(args.length > 0) new Dijkstra().run(Integer.parseInt(args[0]));
		else new Dijkstra().run(10);
    }

}
