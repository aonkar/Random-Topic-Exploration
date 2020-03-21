package datastructures.trees.binarytree;

import general.CheckIfBST;

public class BinaryTreeOperations {

	public static void main(String[] args) {

		BinaryTree<Integer> binaryTree = new BinaryTree<>(10);
		binaryTree.addNode(1);
		binaryTree.addNode(2);
		binaryTree.addNode(3);
		binaryTree.addNode(4);
		binaryTree.addNode(5);
		binaryTree.addNode(6);
		binaryTree.addNode(7);
		binaryTree.addNode(8);
		binaryTree.addNode(9);

//		System.out.println("Level Order Traversal : ");
//		binaryTree.levelOrderTraversal(binaryTree.getRootNode());
//		System.out.println("In Order Traversal : ");
//		binaryTree.inOrder(binaryTree.getRootNode());
//		binaryTree.inOrderUsingRecursion(binaryTree.getRootNode());
//		System.out.println("Pre Order Traversal : ");
//		binaryTree.preOrder(binaryTree.getRootNode());
//		binaryTree.preOrderUsingRecursion(binaryTree.getRootNode());
//		System.out.println("Post Order Traversal : ");
//		binaryTree.postOrder(binaryTree.getRootNode());
//		System.out.println("Mirror image of a tree : ");
//		binaryTree.mirrorImageOfTree(binaryTree.getRootNode());
//		System.out.println(binaryTree.countInnerNodes(binaryTree.getRootNode()));
//		binaryTree.spiralPrint(binaryTree.getRootNode());
//		CheckIfBST bst = new CheckIfBST();
//		System.out.println(bst.isBST(binaryTree.getRootNode()));

		BinaryTreeView topView = new BinaryTreeView();
//		topView.printView(binaryTree.getRootNode(), VIEW.TOPVIEW);
		topView.printView(binaryTree.getRootNode(), VIEW.BOTTOMVIEW);

	}

}
