package datastructures.heaps;

public class HeapOperations {

	public static void main(String[] args) {
		MinHeap heap = new MinHeap();
		heap.addElement(20);
		heap.addElement(30);
		heap.addElement(10);
		heap.addElement(50);
		heap.addElement(40);
		heap.addElement(60);
		heap.addElement(70);
		heap.addElement(5);
		
		heap.deleteElement();
		heap.displayElements();
		heap.deleteElement();
		heap.displayElements();
		heap.deleteElement();
		heap.displayElements();
		heap.deleteElement();
		heap.displayElements();
		heap.deleteElement();
		heap.displayElements();
		heap.deleteElement();
		heap.displayElements();
		heap.deleteElement();
		heap.displayElements();
		heap.deleteElement();
		heap.displayElements();
		heap.deleteElement();
		heap.displayElements();
	}

}
