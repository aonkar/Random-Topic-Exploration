package datastructures.linkedlist.singlelinkedlist.problems;

import datastructures.linkedlist.singlelinkedlist.Node;

public class MergeTwoLinkedListAsc {

	public Node<Integer> mergeTwoList(Node<Integer> node1, Node<Integer> node2) {
		Node<Integer> head = null;
		if (node1 == null) {
			return node2;
		} else if (node2 == null) {
			return node1;
		} else {
			if (node1.data > node2.data) {
				head = new Node<>(node2.data);
				node2 = node2.next;
			} else {
				head = new Node<>(node1.data);
				node1 = node1.next;
			}
			Node<Integer> temp = head;
			
			while (node1 != null && node2 != null) {
				if (node1.data > node2.data) {
					head.next = new Node<>(node2.data);
					head = head.next;
					node2 = node2.next;
				} else {
					head.next = new Node<>(node1.data);
					head = head.next;
					node1 = node1.next;
				}
			}
			if (node1 == null) {
				head.next = node2;
			} else {
				head.next = node1;
			}
			return temp;
		}
	}
}
