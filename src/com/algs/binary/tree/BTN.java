package com.algs.binary.tree;

public class BTN {
	private int value;
	
	private BTN leftNode,rightNode;
	
	public int getValue() {
		return this.value;
	}

	public void setValue(int val) {
		this.value = val;
		
	}
	
	public BTN getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(BTN leftNode) {
		this.leftNode = leftNode;
	}
	public BTN getRightNode() {
		return rightNode;
	}
	public void setRightNode(BTN rightNode) {
		this.rightNode = rightNode;
	}
	
}
