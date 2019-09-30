package datastructures.linkedlist.singlelinkedlist;

import datastructures.linkedlist.singlelinkedlist.problems.PrintNodeValueFromTail;

public class LinkedListOperations {

	public static void main(String[] args) {

		LinkedList<Integer> l1 = new LinkedList<>();
		l1.addNode(1);
		l1.addNode(2);
		l1.addNode(3);
		l1.addNode(4);
		l1.addNode(5);
		l1.addNode(6);
		l1.addNode(7);
		l1.addNode(8);
		l1.addNode(9);
		l1.addNode(10);
		
		PrintNodeValueFromTail p = new PrintNodeValueFromTail();
		p.printNodeValue(l1.head, 3);
	}

}
