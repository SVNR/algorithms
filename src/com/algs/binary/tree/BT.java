package com.algs.binary.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

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
	
	public List<Integer> getInOrder_NonRecursive(){
		List<Integer> inOrderList = new ArrayList<Integer>();
		return getInOrder_NonRecursive(this.rootNode,inOrderList);
			
		
	}
	
	private List<Integer> getInOrder_NonRecursive(BTN parent,List<Integer> preOrderList) {
		Stack<BTN> stack = new Stack<BTN>();
		
		while(parent!=null || !stack.isEmpty()){
			
			if(parent!=null){
				stack.push(parent);
				parent=parent.getLeftNode();
			}else{
				BTN node=stack.pop();
				preOrderList.add(node.getValue());
				parent = node.getRightNode();
			}
						
		}
		
		return preOrderList;
	}
	
	public List<Integer> getPreOrder_NonRecursive(){
		List<Integer> preOrderList = new ArrayList<Integer>();
		return getPreOrder_NonRecursive(this.rootNode,preOrderList);
		
	}

	private List<Integer> getPreOrder_NonRecursive(BTN parent, List<Integer> preOrderList) {
		Stack<BTN> stack = new Stack<BTN>();
		stack.push(parent);
		
		while(!stack.isEmpty()){
			parent = stack.pop();
			if(parent!=null){
				preOrderList.add(parent.getValue());
				stack.push(parent.getRightNode());
				stack.push(parent.getLeftNode());
			}
		}

		
		return preOrderList;
	}

	public boolean hasNode(BTN findNode){
		
		return hasNode(this.rootNode,findNode);
	}
	
	public List<BTN> getPath(BTN node){
		List<BTN> path = new ArrayList<BTN>();
		boolean hasValue =  getPath(this.rootNode,node,path);
		if(hasValue)
			return path;
		else
			return null;
		
		
	}
	
	private boolean getPath(BTN parentNode, BTN node,List<BTN> path) {
		boolean hasValue=false;
		if(parentNode==null || node==null){
			return false ;
		}
		path.add(parentNode);
		if(parentNode.getValue()==node.getValue()){
			 return true;
		}else if(node.getValue()>parentNode.getValue()){
			//path = addNode(path,node);
			hasValue = getPath(parentNode.getRightNode(),node,path);
		}else{
			//path= addNode(path,node);
			hasValue = getPath(parentNode.getLeftNode(),node,path);
		}
		
		return hasValue;
	}

	private List<BTN> addNode(List<BTN> path, BTN node) {
		if(path==null){
			path = new ArrayList<BTN>();
			
		}
		path.add(node);
		
		return path;
		
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
	public List<Integer> getPostOrder_NonRecursive(){
		List<Integer> postOrderList = new ArrayList<Integer>();
		return getPostOrder_NonRecursive(this.rootNode,postOrderList);
	}
	private List<Integer> getPostOrder_NonRecursive(BTN parent, List<Integer> postOrderList) {
		Stack<BTN> s1 = new Stack<BTN>();
		Stack<BTN> s2=new Stack<BTN>();
		
		//push the root to stack1
		s1.push(parent);
		
		while(!s1.isEmpty()){
			BTN node = s1.pop();//take the root node from s1
			s2.push(node);
			if(node.getLeftNode()!=null){//does it contain left to process? add it to s1
				s1.push(node.getLeftNode());
			}
			if(node.getRightNode()!=null){//does it contain right node to process? add to s1
				s1.push(node.getRightNode());
			}
		}
		
		//s2 contains all the nodes
		while(!s2.isEmpty()){
			postOrderList.add(s2.pop().getValue());
		}
		
		
		return postOrderList;
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
	
	/*public Map<Integer,List<BTN>> getVertical(BTN parent){
		Map<Integer,List<BTN>> map = new HashMap<Integer, List<BTN>>();
		getVertical(parent,0,map);
		return null;
	}
*/
	
	/*private Map<Integer, List<BTN>> getVertical(BTN parent, int level, Map<Integer, List<BTN>> map) {
		//Do in order travel
		if(parent==null){
			return null;
		}
		
	
	}*/

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
