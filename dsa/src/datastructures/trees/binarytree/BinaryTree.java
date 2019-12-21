package datastructures.trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {

	private BinaryNode<T> rootNode;

	public BinaryTree(T data) {
		BinaryNode<T> node = new BinaryNode<>(data);
		this.rootNode = node;
	}

	public BinaryNode<T> getRootNode() {
		return rootNode;
	}

	public void setRootNode(T data) {
		BinaryNode<T> node = new BinaryNode<>(data);
		this.rootNode = node;
	}

	public void levelOrderTraversal(BinaryNode<T> rootNode) {
		Queue<BinaryNode<T>> queue = new LinkedList<>();
		queue.add(rootNode);
		while (!queue.isEmpty()) {
			if (queue.peek().getLeftNode() != null) {
				queue.add(queue.peek().getLeftNode());
			}
			if (queue.peek().getRightNode() != null) {
				queue.add(queue.peek().getRightNode());
			}
			System.out.println(queue.remove().getNodeData());
		}
	}

	public void inOrder(BinaryNode<T> node) {
		if (node != null) {
			inOrder(node.getLeftNode());
			System.out.println(node.getNodeData());
			inOrder(node.getRightNode());
		}
	}

	public void preOrder(BinaryNode<T> node) {
		if (node != null) {
			System.out.println(node.getNodeData());
			preOrder(node.getLeftNode());
			preOrder(node.getRightNode());
		}
	}

	public void postOrder(BinaryNode<T> node) {
		if (node != null) {
			postOrder(node.getLeftNode());
			postOrder(node.getRightNode());
			System.out.println(node.getNodeData());
		}
	}

	public void addNode(T nodeData) {
		BinaryNode<T> node = new BinaryNode<>(nodeData);
		BinaryNode<T> tempNode = rootNode;
		Queue<BinaryNode<T>> queue = new LinkedList<>();
		if (this.rootNode == null) {
			this.rootNode = node;
		} else {
			queue.add(tempNode);
			while (!queue.isEmpty()) {
				if (queue.peek().getLeftNode() == null) {
					queue.peek().setLeftNode(node);
					return;
				} else if (queue.peek().getRightNode() == null) {
					queue.peek().setRightNode(node);
					return;
				}
				queue.add(queue.peek().getLeftNode());
				queue.add(queue.peek().getRightNode());
				queue.remove();
			}
		}
	}
	
	public void mirrorImageOfTree(BinaryNode<T> rootNode) {
		Queue<BinaryNode<T>> queue = new LinkedList<>();
		queue.add(rootNode);
		while (!queue.isEmpty()) {
			if (queue.peek().getRightNode() != null) {
				queue.add(queue.peek().getRightNode());
			}
			if (queue.peek().getLeftNode() != null) {
				queue.add(queue.peek().getLeftNode());
			}
			System.out.println(queue.remove().getNodeData());
		}
	}
}
