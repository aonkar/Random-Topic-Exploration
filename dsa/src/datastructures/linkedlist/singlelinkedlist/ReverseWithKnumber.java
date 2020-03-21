package datastructures.linkedlist.singlelinkedlist;

public class ReverseWithKnumber {

	public static void main(String[] args) {
		int k = 3;
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);
		list.addNode(7);
		list.addNode(8);
		list.addNode(9);
		list.addNode(10);
		list.addNode(11);
		list.addNode(12);
		list.addNode(13);
		reverse(list, k);
		Node<Integer> temp = list.head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private static void reverse(LinkedList<Integer> list, int k) {
		Node<Integer> curr = list.head;
		Node<Integer> next = null;
		Node<Integer> prev = null;
		Node<Integer> prevFirst = list.head;
		Node<Integer> currFirst = null;
		int count = 0;
		boolean headNotSet = true;
		while (curr != null) {
			count = 0;
			currFirst = curr;
			while (curr != null && count != k) {
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
				count++;
			}
			if (headNotSet) {
				list.head = prev;
				headNotSet = false;
			} else if(curr == null) {
				currFirst.next = null;
				prevFirst.next = prev;
			} else {
				prevFirst.next = prev;
				prevFirst = currFirst;

			}
		}
	}
}
