// @primary author: Kristy Gardner
// @author of decreaseKey(): Ana Verma

public class Heap {

    Node[] my_heap;
    int count = 0;


    //change the key of a node
    public void decreaseKey(Node node, int key){
    	if(key < node.distance){
    		node.distance = key;
    		siftUp(node.posInHeap);
    	}
    }

    public boolean isEmpty() {
		return (count == 0);
    }

    public void add(Node value) {
		if(count == my_heap.length - 1) resize();

		count++;
		my_heap[count] = value;

		value.posInHeap = count;
		value.inHeap = true;

		siftUp(count);
	}

	public int size() {
		return count;
    }

    private void resize() {
		Node[] temp = new Node[count * 2 + 1];

		for(int i = 1; i <= count; i++) {
		    temp[i] = my_heap[i];
		}
		my_heap = temp;
    }

    public void siftUp(int pos) {
		if(pos != 1 && my_heap[pos].compareTo(my_heap[pos/2]) < 0) {
		    swap(pos, pos/2);
		    siftUp(pos/2);
		}
    }

    public Node remove() {
		if(count == 0) return null;

		Node temp = my_heap[1];
		temp.inHeap = false;
		
		my_heap[1] = my_heap[count];
		count--;
		siftDown(1);
		return temp;
    }

    public void siftDown(int pos) {
		if(2 * pos > count) return;

		if(2 * pos == count) {
		    if(my_heap[2 * pos].compareTo(my_heap[pos]) < 0) {
			swap(pos, 2 * pos);
		    }
		}
		else {
		    int smaller;
		    if(my_heap[2 * pos].compareTo(my_heap[2 * pos + 1]) <= 0) smaller = 2 * pos;
		    else smaller = 2 * pos + 1;
		    
		    if(my_heap[pos].compareTo(my_heap[smaller]) > 0) {
				swap(pos, smaller);
				siftDown(smaller);
		    }
		}
    }

    public void swap(int i, int j) {
		Node temp = my_heap[i];
		my_heap[i] = my_heap[j];
		my_heap[j] = temp;

		//record the change in positions 
		my_heap[i].posInHeap = i;
		my_heap[j].posInHeap = j;
    }

    public void print() {
		for(int i = 1; i <= count; i++) {
		    System.out.println(my_heap[i]);
		}
    }

    public Heap() {
		my_heap = new Node[2];
    }

} 
