package com.algs.binary.tree;

public class BT {

	private BTN rootNode;
	
	public void add(int value){
		add(value,this.rootNode);
	}

	private void add(int value, BTN node) {
		if(node==null){
			node=new BTN();
			node.setValue(value);
		}else if(value>node.getValue()){
			add(value,node.getRightNode());
		}else{
			add(value,node.getLeftNode());
		}
	}
}
