package datastructures.linkedlist.singlelinkedlist;

public class LinkedList<T> {

	Node<T> head;
	Node<T> tail;

	public void addNode(T data) {

		Node<T> node = new Node<>(data);
		if (isEmpty()) {
			head = node;
			tail = node;
		} else {
			Node<T> temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
			tail = node;
		}
	}

	public void deleteNode(int index) {

		if (!isEmpty() && index >= 0) {
			if (index == 0) {
				if (head.next == null) {
					head = null;
					tail = null;
				} else {
					head = head.next;
				}
			} else {
				int count = 0;
				Node<T> temp = head;
				while (temp != null && count < index) {
					if (count == index - 1) {
						if (temp.next == null) {
							tail = temp;
						} else {
							temp.next = temp.next.next;
						}
						break;
					}
					temp = temp.next;
					count++;
				}
			}
		}
	}

	public void printElements() {
		Node<T> temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}
}
