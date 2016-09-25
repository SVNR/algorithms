package com.algs.test.binary.tree.level;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.algs.binary.tree.BTN;
import com.algs.binary.tree.level.LevelOrderTraversal;

public class LevelOrderTraversalTest {
	
	@Test
	public void testVerticalLevelOrder(){
		BTN root = new BTN();
		root.setValue(1);
		BTN left = new BTN();
		left.setValue(2);
		BTN right = new BTN();
		right.setValue(3);
		
		root.setLeftNode(left);
		root.setRightNode(right);
		
		BTN left1 = new  BTN();
		left1.setValue(4);
		BTN right1 = new BTN();
		right1.setValue(5);
		left.setLeftNode(left1);
		left.setRightNode(right1);
		BTN rightLeft=new BTN();
		rightLeft.setValue(6);
		BTN rightRight = new BTN();
		rightRight.setValue(7);
		right.setLeftNode(rightLeft);
		right.setRightNode(rightRight);
		LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
		Map<Integer,List<BTN>> levelMap = levelOrderTraversal.getVerticalLevelOrderMap(root);
		
		Assert.assertNotNull(levelMap);
		for(Integer key : levelMap.keySet()){
			
			List<BTN> btnList = levelMap.get(key);
			
			System.out.println("Values of Key::"+key);
			for(BTN b : btnList){
				System.out.print(b.getValue()+"   ");
			}
			System.out.println("");
		}
	}

}
