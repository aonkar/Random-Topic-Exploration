package datastructures.trees.binarytree;

public class BinaryNode<T> {

	private T nodeData;
	private BinaryNode<T> leftNode;
	private BinaryNode<T> rightNode;

	public BinaryNode(T nodeData) {
		this.nodeData = nodeData;
		this.leftNode = null;
		this.rightNode = null;
	}

	public T getNodeData() {
		return nodeData;
	}

	public void setNodeData(T nodeData) {
		this.nodeData = nodeData;
	}

	public BinaryNode<T> getLeftNode() {
		return leftNode;
	}

	public BinaryNode<T> setLeftNode(BinaryNode<T> leftNode) {
		this.leftNode = leftNode;
		return this;
	}

	public BinaryNode<T> getRightNode() {
		return rightNode;
	}

	public BinaryNode<T> setRightNode(BinaryNode<T> rightNode) {
		this.rightNode = rightNode;
		return this;
	}

}
