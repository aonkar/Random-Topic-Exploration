package general;

import datastructures.trees.binarytree.BinaryNode;

public class CheckIfBST {

	public boolean isBST(BinaryNode<Integer> root) {
		return checkForBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean checkForBst(BinaryNode<Integer> root, int minValue, int maxValue) {
		if(root == null) {
			return true;
		}
		if (root.getNodeData() < maxValue && root.getNodeData() > minValue) {
			return (checkForBst(root.getLeftNode(), minValue, root.getNodeData())
					&& checkForBst(root.getRightNode(), root.getNodeData(), maxValue));
		}
		return false;
	}
}
