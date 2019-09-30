package datastructures.stack.stackarray;

public class Stack<T> {

	int size;
	int top;
	T[] stackArray;
	
	@SuppressWarnings("unchecked")
	public Stack(int size) {
		this.stackArray = (T[]) new Object[size];
	}
}
