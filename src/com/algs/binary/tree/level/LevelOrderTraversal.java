package com.algs.binary.tree.level;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.algs.binary.tree.BTN;

public class LevelOrderTraversal {
	
	public Map<Integer,List<BTN>> getVerticalLevelOrderMap(BTN root){
		
		Map<Integer,List<BTN>> levelOrderMap = new TreeMap<Integer,List<BTN>>();
		
		getVerticalLevelOrderMap(root,0,levelOrderMap);
		
		return levelOrderMap;
		
	}

	private Map<Integer,List<BTN>> getVerticalLevelOrderMap(BTN parent, int level, Map<Integer, List<BTN>> levelOrderMap) {
		List<BTN> levelList=null;
		if(parent == null)
			return null;
		
		Map<Integer,List<BTN>> map = getVerticalLevelOrderMap(parent.getLeftNode(),--level,levelOrderMap);
		
	
		if(map==null){
			++level;
			 levelList = levelOrderMap.get(level);
			if(levelList==null){
				levelList = new ArrayList<BTN>();
			}
			levelList.add(parent);
			
			levelOrderMap.put(level, levelList);
		}
		
		return getVerticalLevelOrderMap(parent.getRightNode(),++level,levelOrderMap);
		

	}

}
