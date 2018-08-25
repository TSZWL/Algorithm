package leetcode;

import java.util.*;

public class Solutionb133 {
	
	public static void main(String args[]){
	}
	Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) return null;
		UndirectedGraphNode r = new UndirectedGraphNode(node.label);
		map.put(node.label, r);
		for (UndirectedGraphNode u : node.neighbors)
			if (!map.containsKey(u.label)) r.neighbors.add(cloneGraph(u));
			else r.neighbors.add(map.get(u.label));
		return r;
	}
}