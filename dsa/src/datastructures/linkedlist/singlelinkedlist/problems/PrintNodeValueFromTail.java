package datastructures.linkedlist.singlelinkedlist.problems;

import datastructures.linkedlist.singlelinkedlist.Node;

public class PrintNodeValueFromTail {
	
	public void printNodeValue(Node<Integer>head, int positionFromTail) {

        Node<Integer> temp = head;
        for(int i=0;i<positionFromTail;i++) {
        	temp = temp.next;
        }
        while(temp.next != null){
                head = head.next;
                temp = temp.next;
        }
        System.out.println(head.data);
	}

}
