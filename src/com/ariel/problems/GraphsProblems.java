package com.ariel.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import com.ariel.data_structures.BinaryTreeNode;
import com.ariel.data_structures.Graph;
import com.ariel.data_structures.GraphNode;
import com.ariel.data_structures.enums.GraphNodeState;

public class GraphsProblems {

	HashSet<GraphNode> visitedA = new HashSet<GraphNode>();
	HashSet<GraphNode> visitedB = new HashSet<GraphNode>();

	public static boolean isBalancedSlow(BinaryTreeNode node) {
		if (node == null) {
			return true;
		}
		int diff = GraphsProblems.getHeight(node.getLeft()) - GraphsProblems.getHeight(node.getRight());
		if (Math.abs(diff) > 1) {
			return false;
		} else {
			return isBalancedSlow(node.getLeft()) && isBalancedSlow(node.getRight());
		}

	}

	public static boolean isBalancedFast(BinaryTreeNode node) {
		int height = GraphsProblems.checkHeight(node);
		if (height == -1) {
			return false;
		} else {
			return true;
		}

	}

	public static int getHeight(BinaryTreeNode node) {
		if (node == null) {
			return 0;
		}

		return Math.max(GraphsProblems.getHeight(node.getLeft()), GraphsProblems.getHeight(node.getRight())) + 1;

	}

	/**
	 * Implement a function to check if a binary tree is balanced. For the
	 * purposes of this question, a balanced tree is defined to be a tree such
	 * that the heights of the two subtrees of any node never differ by more
	 * than one. (Page 95).
	 * 
	 * @param BinaryTreeNode
	 *            root
	 * @return boolean
	 */
	public static boolean isTreeBalanced(BinaryTreeNode root) {
		boolean result = true;

		boolean thisIsBalanced = GraphsProblems.isBalanced(root, true);
		boolean leftSubTree = GraphsProblems.isBalanced(root.getLeft(), true);
		boolean rightSubTree = GraphsProblems.isBalanced(root.getRight(), true);

		return rightSubTree && leftSubTree && thisIsBalanced;

	}

	public static boolean isBalanced(BinaryTreeNode root, boolean response) {

		if (root == null || root.isLeaf()) {
			return true;
		}

		int leftHeight = GraphsProblems.getLeftHeight(root, 0);
		int rightHeight = GraphsProblems.getRightHeight(root, 0);
		boolean balanced = Math.abs(leftHeight - rightHeight) <= 1;
		response = response && balanced;

		if (response == false) {
			return false;
		}

		return GraphsProblems.isBalanced(root.getLeft(), response)
				&& GraphsProblems.isBalanced(root.getRight(), response);

	}

	public static int getLeftHeight(BinaryTreeNode n, int accumaltiveHeight) {
		if (n.isLeaf()) {
			return 0;
		}
		if (n.getLeft() == null) {
			return 0;
		}

		return GraphsProblems.getMaxHeight(n.getLeft()) + 1;

	}

	public static int getRightHeight(BinaryTreeNode n, int accumaltiveHeight) {
		if (n.isLeaf()) {
			return 0;
		}
		if (n.getRight() == null) {
			return 0;
		}

		return GraphsProblems.getMaxHeight(n.getRight()) + 1;
	}

	public static int getMaxHeight(BinaryTreeNode n) {

		if (n == null || n.isLeaf()) {
			return 0;
		}

		int leftMaxHeight = getMaxHeight(n.getLeft()) + 1, rightMaxHeight = getMaxHeight(n.getRight()) + 1;

		return Math.max(leftMaxHeight, rightMaxHeight);

	}

	public static boolean hasValue(BinaryTreeNode n, int value) {

		if (n == null) {
			return false;
		}

		if (n.getValue() == value) {
			return true;
		}

		return hasValue(n.getLeft(), value) || hasValue(n.getRight(), value);

	}

	public boolean areConected(GraphNode a, GraphNode b) {

		boolean result = false;
		if (a == b) {
			return true;
		}

		visitedA.add(a);
		visitedB.add(b);

		if (visitedB.contains(a)) {
			return true;
		}

		if (visitedA.contains(b)) {
			return true;
		}

		for (GraphNode n : a.getPairs()) {

			if (visitedA.contains(n)) {
				break;
			}
			visitedA.add(n);
			result = result || areConected(n, b);
		}

		for (GraphNode n : b.getPairs()) {

			if (visitedB.contains(n)) {
				break;
			}
			visitedB.add(n);

			result = result || areConected(a, n);
		}

		return result;
	}

	public void clearVisited() {
		visitedA.clear();
		visitedB.clear();

	}

	public static int checkHeight(BinaryTreeNode n) {

		if (n == null) {
			return 0;
		}

		int leftHeight = checkHeight(n.getLeft());
		if (leftHeight == -1) {
			return -1;
		}

		int rightHeight = checkHeight(n.getRight());
		if (rightHeight == -1) {
			return -1;
		}

		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}

	}

	public static boolean routeExist(Graph g, GraphNode a, GraphNode b) {
		g.markAllUnvisited();

		LinkedList<GraphNode> q = new LinkedList<GraphNode>();
		GraphNode curr;
		q.addLast(a);
		while (!q.isEmpty()) {
			curr = q.removeFirst();
			if (curr != null) {
				for (GraphNode pair : curr.getPairs()) {
					if (pair.getState() == GraphNodeState.VISITED) {
						continue;
					}
					pair.setState(GraphNodeState.VISITING);
					if (pair == b) {
						return true;
					}
					q.addLast(pair);

				}
				curr.setState(GraphNodeState.VISITED);
			}

		}
		return false;

	}

	public static BinaryTreeNode minHeightTree(int[] arr, int min, int max, BinaryTreeNode n) {
		int middle = (int) (Math.ceil((max - min) / 2) + min);
		int leftHalf = (middle - min) / 2 + min;
		int rightHalf = (int) (Math.ceil((max - middle) / 2) + middle);

		BinaryTreeNode left = new BinaryTreeNode(arr[leftHalf], null, null);
		BinaryTreeNode right = new BinaryTreeNode(arr[rightHalf], null, null);

		if (n == null) {
			n = new BinaryTreeNode(arr[middle], null, null);
		} else if (max - middle <= 1) {
			n.setRight(right);
		}

		if (n.getRight() == null) {
			n.setRight(right);
		}
		n.setLeft(left);

		if (max - min <= 1) {
			return n;
		}

		minHeightTree(arr, min, middle, left);
		minHeightTree(arr, middle, max, right);
		return n;

	}

	public static List<LinkedList<BinaryTreeNode>> listPerLevel(BinaryTreeNode n) {
		LinkedList<BinaryTreeNode> i = new LinkedList<BinaryTreeNode>();
		List<LinkedList<BinaryTreeNode>> result = new LinkedList<LinkedList<BinaryTreeNode>>();

		LinkedList<BinaryTreeNode> levelList = new LinkedList<BinaryTreeNode>();
		i.add(n);
		BinaryTreeNode curr = null;
		int counter = 0, levelCounter = 1;
		while (!i.isEmpty()) {
			curr = i.removeFirst();
			levelList.add(curr);

			if (counter == levelCounter || i.isEmpty()) {
				counter = levelCounter;
				levelCounter *= 2;
				result.add(levelList);
				levelList = new LinkedList<BinaryTreeNode>();

			} else {
				counter++;
			}

			if (curr.getLeft() != null) {
				i.addLast(curr.getLeft());

			}
			if (curr.getRight() != null) {
				i.addLast(curr.getRight());
			}
		}

		return result;
	}

	public static boolean isBinarySearch(BinaryTreeNode n) {
		if (n == null) {
			return false;
		}
		if (n.getState() == GraphNodeState.VISITED) {
			return true;
		}
		BinaryTreeNode left = n.getLeft(), right = n.getRight();
		boolean thisNodeIsBinarySearch = true;
		n.setState(GraphNodeState.VISITED);
		if(left != null  && left.getValue()>n.getValue()){
			return false;
		}
		if(right != null && right.getValue()<n.getValue()){
			return false;
		}
		if(left != null){
			thisNodeIsBinarySearch = thisNodeIsBinarySearch && isBinarySearch(left);
		}
		if(right != null){
			thisNodeIsBinarySearch = thisNodeIsBinarySearch && isBinarySearch(right);
		}
		return thisNodeIsBinarySearch;
	}

}
