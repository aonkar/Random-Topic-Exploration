package datastructures.linkedlist.singlelinkedlist;

public class LinkedListSum {

	public static void main(String[] args) {
		Node<Integer> node1 = new Node<Integer>(2);
		Node<Integer> node2 = new Node<Integer>(4);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(5);
		Node<Integer> node5 = new Node<Integer>(6);
		Node<Integer> node6 = new Node<Integer>(6);
		node2.next = node3;
		node1.next = node2;
		node5.next = node6;
		node4.next = node5;
		Node<Integer> output = addTwoNumbers(node1, node4);
		while (output != null) {
			System.out.println(output.data);
			output = output.next;
		}

	}

	public static Node<Integer> addTwoNumbers(Node<Integer> l1, Node<Integer> l2) {
		Node<Integer> temp1 = l1;
		Node<Integer> temp2 = l2;
		Node<Integer> output = new Node<>((temp1.data + temp2.data) % 10);
		int carry = (temp1.data + temp2.data + 0) /10;
		Node<Integer> temp = output;
		temp1 = temp1.next;
		temp2 = temp2.next;
		while (temp1 != null && temp2 != null) {
			output.next = new Node<Integer>((temp1.data + temp2.data + carry) % 10);
			carry = (temp1.data + temp2.data + carry) /10;
			temp1 = temp1.next;
			temp2 = temp2.next;
			output = output.next;
			
		}
		if(carry != 0){
            output.next = new Node<>(carry);
        }
		return temp;
	}
}
