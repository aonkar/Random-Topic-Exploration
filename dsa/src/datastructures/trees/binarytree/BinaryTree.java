package datastructures.trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

	public void inOrderUsingRecursion(BinaryNode<T> node) {

		Stack<BinaryNode<T>> stack = new Stack<>();
		BinaryNode<T> temp = node;
		while (!stack.isEmpty() || temp != null) {
			if (temp == null) {
				BinaryNode<T> stackTop = stack.pop();
				temp = stackTop.getRightNode();
				System.out.println(stackTop.getNodeData());

			} else {
				stack.push(temp);
				temp = temp.getLeftNode();
			}
		}

	}

	public void preOrderUsingRecursion(BinaryNode<T> node) {

		Stack<BinaryNode<T>> stack = new Stack<>();
		BinaryNode<T> temp = node;
		while (!stack.isEmpty() || temp != null) {
			if (temp == null) {
				BinaryNode<T> stackTop = stack.pop();
				temp = stackTop.getRightNode();
			} else {
				System.out.println(temp.getNodeData());
				stack.push(temp);
				temp = temp.getLeftNode();
			}
		}

	}

	public int countNodes(BinaryNode<T> node) {

		if (node == null) {
			return 0;
		}
		return countNodes(node.getLeftNode()) + countNodes(node.getRightNode()) + 1;
	}

	public int sumNodes(BinaryNode<T> node) {

		if (node == null) {
			return 0;
		}
		return sumNodes(node.getLeftNode()) + sumNodes(node.getRightNode()) + (Integer) node.getNodeData();
	}

	public int countInnerNodes(BinaryNode<T> node) {

		if (node != null && (node.getLeftNode() != null || node.getRightNode() != null)) {
			return countInnerNodes(node.getLeftNode()) + countInnerNodes(node.getRightNode()) + 1;
		}
		return 0;
	}

	public void spiralPrint(BinaryNode<T> node) {
		Stack<BinaryNode<T>> leftToRightStack = new Stack<>();
		Stack<BinaryNode<T>> rightToLeftStack = new Stack<>();

		rightToLeftStack.push(node);
		while (!rightToLeftStack.isEmpty() || !leftToRightStack.isEmpty()) {
			while (!rightToLeftStack.isEmpty()) {
				BinaryNode<T> currentPoppedNode = rightToLeftStack.pop();
				System.out.println(currentPoppedNode.getNodeData());
				if (currentPoppedNode.getLeftNode() != null) {
					leftToRightStack.push(currentPoppedNode.getLeftNode());
				}
				if (currentPoppedNode.getRightNode() != null) {
					leftToRightStack.push(currentPoppedNode.getRightNode());
				}
			}

			while (!leftToRightStack.isEmpty()) {
				BinaryNode<T> currentPoppedNode = leftToRightStack.pop();
				System.out.println(currentPoppedNode.getNodeData());
				if (currentPoppedNode.getRightNode() != null) {
					rightToLeftStack.push(currentPoppedNode.getRightNode());
				}
				if (currentPoppedNode.getLeftNode() != null) {
					rightToLeftStack.push(currentPoppedNode.getLeftNode());
				}
			}
		}
	}
}
