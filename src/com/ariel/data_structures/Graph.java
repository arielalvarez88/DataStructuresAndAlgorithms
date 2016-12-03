package com.ariel.data_structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.ariel.data_structures.enums.GraphNodeState;

public class Graph {

	List<GraphNode> nodes;

	public Graph(List<GraphNode> nodes) {
		super();
		this.nodes = nodes;
	}

	public Graph() {
		super();
		this.nodes = new ArrayList<GraphNode>();
	}

	public List<GraphNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<GraphNode> nodes) {
		this.nodes = nodes;
	}

	public void markAllUnvisited() {
		for (GraphNode node : nodes) {
			node.setState(GraphNodeState.UNVISITED);
		}

	}

	public void add(GraphNode... n) {
		nodes.addAll(Arrays.asList(n));
		this.markAllUnvisited();
	}

	public void removeRelationships(){
		
		for(GraphNode n : nodes){
			n.removeRelationships();
									
		}
		
	}

}
