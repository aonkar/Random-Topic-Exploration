package datastructures.linkedlist.singlelinkedlist.problems;

import datastructures.linkedlist.singlelinkedlist.Node;

public class PrintNodeValueFromTail {
	
	public void printNodeValue(Node<Integer>head, int positionFromTail) {

        Node<Integer> temp = head;
        int data = head.data;
        int count = 0;
        while(temp != null){
            if(count == positionFromTail){
                count = -1;
                head = head.next;
                data = head.data;
            }
            temp = temp.next;
            count++;
        }
        System.out.println(data);
	}

}
