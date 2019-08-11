package datastructures.linkedlist.singlelinkedlist.problems;

import datastructures.linkedlist.singlelinkedlist.Node;

public class CompareLinkedList<T> {

	public boolean compareList(Node<T> headNode1, Node<T> headNode2) {

		if (headNode1 == null && headNode2 == null) {
			return true;
		} else if (headNode1 == null || headNode2 == null) {
			return false;
		}
		while (headNode1.data == headNode2.data) {
			if(headNode1.next == null && headNode2.next == null){
                return true;
            } else if(headNode1.next == null || headNode2.next == null){
                return false;
            }
			headNode1 = headNode1.next;
			headNode2 = headNode2.next;
		}
		return false;

	}
}
