package datastructures.linkedlist.singlelinkedlist.problems;

import datastructures.linkedlist.singlelinkedlist.Node;

public class CycleDetection<T> {

	public boolean detectCycle(Node<T> head) {
		if (head == null) {
			return false;
		} else {
			Node<T> temp1 = head;
			Node<T> temp2 = head;
			while (temp2.next != null) {
				temp1 = temp1.next;
				temp2 = temp2.next;
				if (temp2.next != null) {
					temp2 = temp2.next;
				} else {
					return false;
				}
				if (temp1 == temp2) {
					return true;
				}
			}
			return false;
		}

	}
}
