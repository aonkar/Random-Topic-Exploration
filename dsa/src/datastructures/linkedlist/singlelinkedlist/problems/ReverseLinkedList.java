package datastructures.linkedlist.singlelinkedlist.problems;

import datastructures.linkedlist.singlelinkedlist.Node;

public class ReverseLinkedList<T> {

	public Node<T> reverseList(Node<T> head) {

		if (head != null) {
			Node<T> next = null;
			Node<T> prev = null;

			while (head != null) {
				next = head.next;
				head.next = prev;
				prev = head;
				head = next;
			}
			return prev;
		}
		return null;
	}

}
