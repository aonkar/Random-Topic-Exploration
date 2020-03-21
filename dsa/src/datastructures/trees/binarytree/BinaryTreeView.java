package datastructures.trees.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeView {

	public void printView(BinaryNode<Integer> root, VIEW view) {
		Map<Integer, List<Integer>> nodeMap = new HashMap<>();
		List<Integer> levelTraversalList = new ArrayList<>();
		view(root, 0, nodeMap);
		levelOrderTraversal(root, levelTraversalList);
		if (view.equals(VIEW.TOPVIEW)) {
			nodeMap.keySet().stream().forEach(key -> {
				if (nodeMap.get(key).size() == 1) {
					System.out.println(nodeMap.get(key));
				} else {
					List<Integer> indexList = nodeMap.get(key);
					for (Integer currElement : levelTraversalList) {
						if (indexList.contains(currElement)) {
							System.out.println(currElement);
							break;
						}
					}
				}
			});
		} else if (view.equals(VIEW.BOTTOMVIEW)) {
			nodeMap.keySet().stream().forEach(key -> {
				if (nodeMap.get(key).size() == 1) {
					System.out.println(nodeMap.get(key));
				} else {
					List<Integer> indexList = nodeMap.get(key);
					for (int i = levelTraversalList.size() - 1; i >= 0; i--) {
						if (indexList.contains(levelTraversalList.get(i))) {
							System.out.println(levelTraversalList.get(i));
							break;
						}
					}
				}
			});
		}
	}

	private void levelOrderTraversal(BinaryNode<Integer> root, List<Integer> levelTraversalList) {
		Queue<BinaryNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode<Integer> currentNode = queue.remove();
			levelTraversalList.add(currentNode.getNodeData());
			if (currentNode.getLeftNode() != null) {
				queue.add(currentNode.getLeftNode());
			}
			if (currentNode.getRightNode() != null) {
				queue.add(currentNode.getRightNode());
			}
		}

	}

	private void view(BinaryNode<Integer> root, int index, Map<Integer, List<Integer>> nodeMap) {

		if (root == null) {
			return;
		}
		nodeMap.compute(index, (key, value) -> {
			if (value != null) {
				value.add(root.getNodeData());
				return value;
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(root.getNodeData());
				return list;
			}
		});
		if (root.getLeftNode() != null) {
			view(root.getLeftNode(), index - 1, nodeMap);
		}
		if (root.getRightNode() != null) {
			view(root.getRightNode(), index + 1, nodeMap);
		}
	}
}
