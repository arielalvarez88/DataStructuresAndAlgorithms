
package com.ariel.data_structures;

import java.util.ArrayList;
import java.util.List;

import com.ariel.data_structures.enums.GraphNodeState;

public class GraphNode {

	protected int value;
	protected List<GraphNode> pairs;
	protected GraphNodeState state;
	protected GraphNode parent;

	public GraphNode(int value, List<GraphNode> pairs) {
		super();
		this.value = value;
		this.pairs = pairs;
	}

	public GraphNode(int value, GraphNode left, GraphNode right) {

		this.value = value;
		this.pairs = new ArrayList<GraphNode>();
		if (left != null) {
			pairs.add(left);
			left.setParent(this);
		}
		if (right != null) {
			pairs.add(right);
			right.setParent(this);
		}

	}

	public GraphNodeState getState() {
		return state;
	}

	public void setState(GraphNodeState state) {
		this.state = state;
	}

	public GraphNode(int value) {
		super();
		this.value = value;
		this.pairs = new ArrayList<GraphNode>();
	}

	public void addPair(GraphNode pair) {
		if (pair != null) {
			this.pairs.add(pair);
			pair.setParent(this);
		}

	}

	public GraphNode getParent() {
		return parent;
	}

	public void setParent(GraphNode parent) {
		this.parent = parent;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<GraphNode> getPairs() {
		return pairs;
	}

	public void setPairs(List<GraphNode> pairs) {

		this.pairs = pairs;

		for (GraphNode p : pairs) {
			p.setParent(this);
		}
	}

	public void addPairDoubleDir(GraphNode p) {
		if (p == null) {
			return;
		}
		this.addPair(p);
		p.addPair(this);
	}
	
	public void removeRelationships(){
		this.setPairs(new ArrayList<GraphNode>());
		this.setParent(null);
	}

}
