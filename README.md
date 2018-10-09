# DijkstrasAlgorithm
------------------------------------------------------------------------------------------------------------------------------
*Source code from Professor Kristy Gardner, Amherst College*

*Description from Assignment:* "implement Dijkstra’s algorithm to find the shortest path from a single vertex to all other vertices in a graph"

Node.java: represents a vertex in the graph
* @primary author: Ana Verma
* *compareTo():* takes in another node (other), compares it with the current node (this) -- returns: negative number if this < other, 0 if this = other, and a positive number if this > other

Heap.java: heap implementation of a priority queue
* @primary author: Kristy Gardner
* @author of *decreaseKey():* Ana Verma

Dijkstra.java:
* @starter code from: Kristy Gardner
* @author of the methods *dijkstra* and *printPath*: Ana Verma
* *dijkstra*: takes in an adjacency matrix (graph) and a list of the graph's nodes -- runs a search to find the shortest path from Node 0 to every other node
* *printPath*: takes in a Node (this) and prints the nodes in the shortest path from Node 0 to this node
