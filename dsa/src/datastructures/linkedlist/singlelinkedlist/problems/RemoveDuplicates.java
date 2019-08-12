package datastructures.linkedlist.singlelinkedlist.problems;

import datastructures.linkedlist.singlelinkedlist.Node;

public class RemoveDuplicates {

	public Node<Integer> removeDuplicatesFromList(Node<Integer> head) {
	
		Node<Integer> temp = head;
		while(temp.next != null) {
			if(temp.data != temp.next.data) {
				temp = temp.next;
			} else {
				temp.next = temp.next.next;
			}
		}
		return head;
	}
}
