package com.ariel.problems.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ariel.data_structures.BinaryTreeNode;
import com.ariel.data_structures.Graph;
import com.ariel.data_structures.GraphNode;
import com.ariel.problems.GraphsProblems;

public class GraphsProblemsTest {

	BinaryTreeNode n1, n2, n3, n4, n5, n6, n7;

	@Before
	public void init() {
		n1 = new BinaryTreeNode(1, null, null);
		n2 = new BinaryTreeNode(2, null, null);
		n3 = new BinaryTreeNode(3, null, null);
		n4 = new BinaryTreeNode(4, null, null);
		n5 = new BinaryTreeNode(5, null, null);
		n6 = new BinaryTreeNode(6, null, null);
		n7 = new BinaryTreeNode(7, null, null);
	}

	@Test
	public void testGetMaxHeight() {

		n1.setLeft(n2);
		n2.setLeft(n3);
		n2.setRight(n5);
		n3.setLeft(n4);
		n3.setRight(n6);

		assertTrue(GraphsProblems.getMaxHeight(n1) == 3);
	}

	@Test
	public void testIsTreeBalanced() {

		n1.setLeft(n2);
		assertTrue(GraphsProblems.isTreeBalanced(n1));
		n2.setLeft(n3);
		assertFalse(GraphsProblems.isTreeBalanced(n1));
		n1.setRight(n4);
		assertTrue(GraphsProblems.isTreeBalanced(n1));
		n4.setRight(n5);
		assertTrue(GraphsProblems.isTreeBalanced(n1));
		n5.setRight(n6);
		assertFalse(GraphsProblems.isTreeBalanced(n1));
		n4.setLeft(n7);
		assertTrue(GraphsProblems.isTreeBalanced(n1));

		/*
		 * 
		 * A / \ B C <-- difference = 2 / / D E / G
		 * 
		 */

		n1.setLeft(n2);
		n1.setRight(n3);
		n2.setLeft(n4);
		n2.setRight(null);
		n3.setLeft(n5);
		n3.setRight(null);
		n5.setLeft(n6);
		n5.setRight(null);
		n6.setLeft(null);
		n6.setRight(null);
		assertFalse(GraphsProblems.isTreeBalanced(n1));

	}

	@Test
	public void testIsBalanced() {

		n1.setLeft(n2);
		assertTrue(GraphsProblems.isBalancedSlow(n1));
		n2.setLeft(n3);
		assertFalse(GraphsProblems.isBalancedSlow(n1));
		n1.setRight(n4);
		assertTrue(GraphsProblems.isBalancedSlow(n1));
		n4.setRight(n5);
		assertTrue(GraphsProblems.isBalancedSlow(n1));
		n5.setRight(n6);
		assertFalse(GraphsProblems.isBalancedSlow(n1));
		n4.setLeft(n7);
		assertTrue(GraphsProblems.isBalancedSlow(n1));

		/*
		 * 
		 * A / \ B C <-- difference = 2 / / D E / G
		 * 
		 */

		n1.setLeft(n2);
		n1.setRight(n3);
		n2.setLeft(n4);
		n2.setRight(null);
		n3.setLeft(n5);
		n3.setRight(null);
		n5.setLeft(n6);
		n5.setRight(null);
		n6.setLeft(null);
		n6.setRight(null);
		assertFalse(GraphsProblems.isBalancedSlow(n1));

	}

	@Test
	public void testHasValue() {

		assertTrue(GraphsProblems.hasValue(n1, 1));

		n1.setLeft(n6);
		assertTrue(GraphsProblems.hasValue(n1, 1));
		assertTrue(GraphsProblems.hasValue(n1, 6));

		n1.setRight(n2);

		n2.setRight(n3);

		n6.setLeft(n5);
		n6.setRight(n4);

		n5.setLeft(n7);

		assertTrue(GraphsProblems.hasValue(n1, 7));
		assertFalse(GraphsProblems.hasValue(n1, 10));
		assertFalse(GraphsProblems.hasValue(n1, 0));
		assertTrue(GraphsProblems.hasValue(n1, 1));
		assertTrue(GraphsProblems.hasValue(n1, 2));
		assertTrue(GraphsProblems.hasValue(n1, 3));
		assertTrue(GraphsProblems.hasValue(n1, 4));
		assertTrue(GraphsProblems.hasValue(n1, 5));
		assertTrue(GraphsProblems.hasValue(n1, 6));
		assertTrue(GraphsProblems.hasValue(n1, 7));

	}

	@Test
	public void testAreConected() {
		GraphNode n1 = new GraphNode(1), n2 = new GraphNode(2), n3 = new GraphNode(3), n4 = new GraphNode(4),
				n5 = new GraphNode(5), n6 = new GraphNode(6);
		GraphsProblems gp = new GraphsProblems();

		n1.addPair(n2);
		assertTrue(gp.areConected(n1, n2));
		gp.clearVisited();
		assertTrue(gp.areConected(n2, n1));

		gp.clearVisited();
		n1.addPair(n3);
		assertTrue(gp.areConected(n1, n3));
		gp.clearVisited();
		assertTrue(gp.areConected(n3, n1));

		gp.clearVisited();
		n2.addPair(n4);
		n3.addPair(n4);
		assertTrue(gp.areConected(n1, n4));
		gp.clearVisited();
		assertTrue(gp.areConected(n4, n1));

		gp.clearVisited();
		n5.addPair(n4);
		assertTrue(gp.areConected(n1, n5));
		gp.clearVisited();
		assertTrue(gp.areConected(n5, n1));

		gp.clearVisited();
		n5.addPair(n4);
		assertTrue(gp.areConected(n1, n5));
		gp.clearVisited();
		assertTrue(gp.areConected(n5, n1));

	}

	@Test
	public void testRouteExist() {
		GraphNode n1 = new GraphNode(1), n2 = new GraphNode(2), n3 = new GraphNode(3), n4 = new GraphNode(4),
				n5 = new GraphNode(5), n6 = new GraphNode(6);
		Graph g = new Graph();

		n1.addPair(n2);
		g.add(n1, n2);
		assertTrue(GraphsProblems.routeExist(g, n1, n2));
		g.markAllUnvisited();
		assertFalse(GraphsProblems.routeExist(g, n2, n1));

		/*
		 * gp.clearVisited(); n1.addPair(n3); assertTrue(gp.areConected(n1,n3));
		 * gp.clearVisited(); assertTrue(gp.areConected(n3,n1));
		 * 
		 * gp.clearVisited(); n2.addPair(n4); n3.addPair(n4);
		 * assertTrue(gp.areConected(n1,n4)); gp.clearVisited();
		 * assertTrue(gp.areConected(n4,n1));
		 * 
		 * gp.clearVisited(); n5.addPair(n4); assertTrue(gp.areConected(n1,n5));
		 * gp.clearVisited(); assertTrue(gp.areConected(n5,n1));
		 * 
		 * gp.clearVisited(); n5.addPair(n4); assertTrue(gp.areConected(n1,n5));
		 * gp.clearVisited(); assertTrue(gp.areConected(n5,n1));
		 */

	}

	@Test
	public void testListPerLevel() {
		List<LinkedList<BinaryTreeNode>> r, expected;

		r = GraphsProblems.listPerLevel(n1);
		expected = new LinkedList<LinkedList<BinaryTreeNode>>();
		expected.add(new LinkedList<BinaryTreeNode>(Arrays.asList(n1)));
		assertTrue(r.equals(expected));
		n1.setLeft(n2);
		;
		n1.setRight(n3);
		n2.setLeft(n4);
		n3.setRight(n5);
		double a = 21.1;
		Double b = new Double(a);
		Double c = new Double(b);

		n5.setRight(n6);
		r = GraphsProblems.listPerLevel(n1);
		assertTrue(r.size() == 4);
		assertTrue(r.get(0).equals(new LinkedList<BinaryTreeNode>(Arrays.asList(n1))));
		assertTrue(r.get(1).equals(new LinkedList<BinaryTreeNode>(Arrays.asList(n2, n3))));
		assertTrue(r.get(2).equals(new LinkedList<BinaryTreeNode>(Arrays.asList(n4, n5))));
		assertTrue(r.get(3).equals(new LinkedList<BinaryTreeNode>(Arrays.asList(n6))));

	}

	@Test
	public void testIsBinarySearch() {
		Graph g = new Graph(Arrays.asList(n1, n2, n3, n4, n5, n6, n7));
		g.markAllUnvisited();

		assertTrue(GraphsProblems.isBinarySearch(null) == false);
		n3.setLeft(n2);
		n3.setRight(n5);
		assertTrue(GraphsProblems.isBinarySearch(n3) == true);
		g.markAllUnvisited();
		n2.setLeft(n1);

		n5.setRight(n6);

		assertTrue(GraphsProblems.isBinarySearch(n3) == true);
		g.markAllUnvisited();
		n5.setLeft(n7);

		assertFalse(GraphsProblems.isBinarySearch(n3) == true);
	}

	@Test
	public void testGetCommonParent() {
		n1.setLeft(n2);
		n1.setLeft(n3);
		assertTrue(GraphsProblems.getCommonParent(n2, n3) == n1);
		n2.setRight(n5);
		n2.setLeft(n4);
		n4.setRight(n7);
		;
		assertTrue(GraphsProblems.getCommonParent(n7, n3) == n1);
		assertTrue(GraphsProblems.getCommonParent(n5, n7) == n2);
		assertTrue(GraphsProblems.getCommonParent(n1, n2) == null);
		assertTrue(GraphsProblems.getCommonParent(n3, n3) == n1);
	}

}
