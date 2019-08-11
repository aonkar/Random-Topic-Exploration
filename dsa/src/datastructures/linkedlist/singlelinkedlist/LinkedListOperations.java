package datastructures.linkedlist.singlelinkedlist;

import datastructures.linkedlist.singlelinkedlist.problems.ReverseLinkedList;

public class LinkedListOperations {

	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.deleteNode(4);
		list.printElements();
		ReverseLinkedList<Integer> listReverse = new ReverseLinkedList<Integer>();
		list.head = listReverse.reverseList(list.head);
		list.printElements();
		

	}

}
