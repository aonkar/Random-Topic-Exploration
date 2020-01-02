package datastructures.trees.binarytree;

public class BinaryTreeOperations {

	public static void main(String[] args) {

		BinaryTree<Integer> binaryTree = new BinaryTree<>(10);

		binaryTree.addNode(20);
		binaryTree.addNode(30);
		binaryTree.addNode(40);
		binaryTree.addNode(50);
		binaryTree.addNode(60);
		binaryTree.addNode(70);
		binaryTree.addNode(80);
		binaryTree.addNode(90);
		binaryTree.addNode(100);

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
		binaryTree.spiralPrint(binaryTree.getRootNode());

	}

}
