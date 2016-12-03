package com.ariel.data_structures;

import java.util.ArrayList;

public class BinaryTreeNode extends GraphNode {

	BinaryTreeNode left, right;

	public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
		super(value, left, right);
		this.left = left;
		this.right = right;

	}

	public BinaryTreeNode(int value) {
		super(value);
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
		if(left!= null){
			left.setParent(this);
		}
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
		if(right!= null){
			right.setParent(this);
		}
	}

	public boolean isLeaf() {
		return this.left == null && this.right == null;
	}

	public String toString() {
		return "" + this.value;
	}

	public BinaryTreeNode getParent() {
		GraphNode parent = super.getParent();
		return (BinaryTreeNode) parent;
	}
	
	public void removeRelationships(){
		super.removeRelationships();
		this.left=null;
		this.right =null;
	}

}
