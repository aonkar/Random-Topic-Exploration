package datastructures.linkedlist.singlelinkedlist.problems;

import datastructures.linkedlist.singlelinkedlist.Node;

public class ReverseLinkedList<T> {

	public void reverseList(Node<T> head) {

		if (head != null) {
			Node<T> curr = head;
			Node<T> next = null;
			Node<T> prev = null;

			while (curr != null) {
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			}
			head = prev;
		}

	}

}
