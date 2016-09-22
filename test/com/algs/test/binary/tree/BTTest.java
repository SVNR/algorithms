package com.algs.test.binary.tree;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.algs.binary.tree.BT;
import com.algs.binary.tree.BTN;

public class BTTest {
	private BT bt;
	
	@BeforeClass
	private void setUp(){
		bt= new BT();
		bt.add(40);
		bt.add(25);
		bt.add(78);
		bt.add(10);
		bt.add(32);
		/*bt.add(50);
		bt.add(93);
		bt.add(3);
		bt.add(17);
		bt.add(30);
		bt.add(38);*/
		
	}
	
  @Test
  public void PreOrderTraversal() {
	  
	  List<Integer> preOrderList = bt.traversePreOrder();
	  for (Integer val : preOrderList) {
		  System.out.println(val);
			  
	}
	  
	Assert.assertNotNull(preOrderList);
	Assert.assertEquals(preOrderList.size(), 5);
	Assert.assertEquals(preOrderList.get(0).intValue(), 40);
	Assert.assertEquals(preOrderList.get(1).intValue(), 25);
	Assert.assertEquals(preOrderList.get(4).intValue(), 78);
	
	List<Integer> preOrder_nonRecursive = bt.getPreOrder_NonRecursive();
	Assert.assertNotNull(preOrder_nonRecursive);
	Assert.assertEquals(preOrder_nonRecursive.size(), 5);
	Assert.assertEquals(preOrder_nonRecursive.get(0).intValue(), 40);
	Assert.assertEquals(preOrder_nonRecursive.get(1).intValue(), 25);
	Assert.assertEquals(preOrder_nonRecursive.get(4).intValue(), 78);
  }
  
  @Test
  public void testPostOrderTraversal() {
	  
	  List<Integer> postOrderList = bt.traversePostOrder();
	  for (Integer val : postOrderList) {
		  System.out.println(val);
			  
	}
	  
	Assert.assertNotNull(postOrderList);
	Assert.assertEquals(postOrderList.size(), 5);
	Assert.assertEquals(postOrderList.get(0).intValue(), 10);
	Assert.assertEquals(postOrderList.get(1).intValue(), 32);
	Assert.assertEquals(postOrderList.get(4).intValue(), 40);
	
	//
	List<Integer> postOrderNonRecursive=bt.getPostOrder_NonRecursive();
	
	Assert.assertNotNull(postOrderNonRecursive);
	Assert.assertEquals(postOrderNonRecursive.size(), 5);
	Assert.assertEquals(postOrderNonRecursive.get(0).intValue(), 10);
	Assert.assertEquals(postOrderNonRecursive.get(1).intValue(), 32);
	Assert.assertEquals(postOrderNonRecursive.get(4).intValue(), 40);
	
  }
  
  @Test
  public void testInOrderTraversal() {
	  
	  List<Integer> inOrderList = bt.traverseInOrder();
	  for (Integer val : inOrderList) {
		  System.out.println(val);
			  
	}
	  
	Assert.assertNotNull(inOrderList);
	Assert.assertEquals(inOrderList.size(), 5);
	Assert.assertEquals(inOrderList.get(0).intValue(), 10);
	Assert.assertEquals(inOrderList.get(1).intValue(), 25);
	Assert.assertEquals(inOrderList.get(4).intValue(), 78);
	
	List<Integer> nonRecursiveList = bt.getInOrder_NonRecursive();
	Assert.assertNotNull(nonRecursiveList);
	Assert.assertEquals(nonRecursiveList.size(), 5);
	Assert.assertEquals(nonRecursiveList.get(0).intValue(), 10);
	Assert.assertEquals(nonRecursiveList.get(1).intValue(), 25);
	Assert.assertEquals(nonRecursiveList.get(4).intValue(), 78);
  }
  
  @Test
  public void testHeight(){
	  
	  Assert.assertEquals(bt.getHeight(), 2);
	  
  }
  
  @Test
  public void testExists(){
	  BTN findNode=new BTN();
	  findNode.setValue(10);
	  boolean nodeExists = bt.hasNode(findNode);
	  Assert.assertTrue(nodeExists);
	  
  }
  
  @Test
  public void testNotExists(){
	  BTN findNode=new BTN();
	  findNode.setValue(11);
	  boolean nodeExists = bt.hasNode(findNode);
	  Assert.assertFalse(nodeExists);
	  
  }
  
  @Test
  public void testNodePath(){
	  BTN findNode=new BTN();
	  findNode.setValue(10);
	 List<BTN> path = bt.getPath(findNode);
	 for (BTN btn : path) {
		System.out.println(btn.getValue());
	}
	  Assert.assertNotNull(path);
	  
  }
  
  @Test
  public void testNodePath_NotFound(){
	  BTN findNode=new BTN();
	  findNode.setValue(11);
	 List<BTN> path = bt.getPath(findNode);
	
	  Assert.assertNull(path);
	  
  }
  
}
