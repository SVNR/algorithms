package com.algs.binary.tree;

import java.util.ArrayList;
import java.util.List;

public class BT {

	private BTN rootNode;

	public void add(int value) {
		BTN node = createNode(value);
		if (this.rootNode == null) {
			this.rootNode = node;
		} else {
			add(this.rootNode, node);
		}
	}

	private void add(BTN parentNode, BTN node) {
		if (parentNode.getValue() > node.getValue()) {
			if (parentNode.getLeftNode() == null) {
				parentNode.setLeftNode(node);
				return;
			} else {

				add(parentNode.getLeftNode(), node);
			}
		} else {
			if (parentNode.getRightNode() == null) {
				parentNode.setRightNode(node);
				return;
			} else {
				add(parentNode.getRightNode(), node);
			}
		}
	}

	/**
	 * Visit the node, left subtree followed by right subtree.
	 * 
	 * @return
	 */
	public List<Integer> traversePreOrder() {
		List<Integer> preOrderList = new ArrayList<Integer>();
		// if(this.rootNode!=null){
		// preOrderList.add(this.rootNode.getValue());
		// }

		return getPreOrderList(this.rootNode, preOrderList);

	}
	
	public boolean hasNode(BTN findNode){
		
		return hasNode(this.rootNode,findNode);
	}
	
	private boolean hasNode(BTN rootNode,BTN findNode){
		
		boolean foundNode=false;
		
		if(rootNode ==null || findNode==null){
			return false;
		}
		if(rootNode.getValue()==findNode.getValue()){
			return true;
		}
		else if(findNode.getValue()>rootNode.getValue()){
			foundNode = hasNode(rootNode.getRightNode(),findNode);
			
		}else
		{
			foundNode = hasNode(rootNode.getLeftNode(),findNode);
		}
		
		return foundNode;
		
	}

	public List<Integer> traversePostOrder() {
		List<Integer> postOrderList = new ArrayList<Integer>();

		return getPostOrderList(this.rootNode, postOrderList);

	}

	public List<Integer> traverseInOrder() {
		List<Integer> inOrderList = new ArrayList<Integer>();

		return getInOrderList(this.rootNode, inOrderList);

	}
	
	public int getHeight(){
		return getHeight(this.rootNode);
	}
	
	public BTN getLCA(BTN root,BTN node1,BTN node2){
		if(root == null)
			return null;
		
		if(root.getValue()==node1.getValue() || root.getValue()==node2.getValue()){
			return root;
		}
		
		BTN left = getLCA(root.getLeftNode(),node1,node2);
		BTN right = getLCA(root.getRightNode(),node1,node2);
		if(left!= null && right != null){
			return root;
		}else if(left==null && right==null)
			return null;
		return left==null?right:left;
		
	}
	
	public void getPath(int element){
		//initialize 2 arrays
		int[] left = new int[10];
		int[] right = new int[10];
		
		//traverse left
	}

	
	/**
	 * Gets the height of the tree
	 * @param node
	 * @return  0 if only root node.
	 */
	private int getHeight(BTN node) {
		
		if(node==null)
			return -1;
		else{
			System.out.println("Get Height:: node value"+node.getValue());
			if(node.getLeftNode()!=null){
				System.out.println("Left node value="+node.getLeftNode().getValue());
			}
			if(node.getRightNode()!=null){
				System.out.println("Right node value="+node.getRightNode().getValue());
			}
		}
		return 1+ Math.max(getHeight(node.getLeftNode()), getHeight(node.getRightNode()));
	}

	private List<Integer> getPreOrderList(BTN node, List<Integer> list) {
		if (node == null) {
			return list;
		} else {
			list.add(node.getValue());
		}
		getPreOrderList(node.getLeftNode(), list);
		getPreOrderList(node.getRightNode(), list);

		return list;

	}

	/**
	 * 
	 * @param node
	 * @param list
	 * @return
	 */
	private List<Integer> getPostOrderList(BTN node, List<Integer> list) {
		if(node==null)
			return list;

		getPostOrderList(node.getLeftNode(), list);

		getPostOrderList(node.getRightNode(), list);

		list.add(node.getValue());

		return list;

	}

	private List<Integer> getInOrderList(BTN node, List<Integer> list) {
		if(node==null)
			return list;

		getInOrderList(node.getLeftNode(), list);
		list.add(node.getValue());

		getInOrderList(node.getRightNode(), list);

		return list;

	}

	private BTN createNode(int value) {
		BTN node = new BTN();
		node.setValue(value);
		return node;
	}
}
