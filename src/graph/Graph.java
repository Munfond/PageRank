package graph;

import java.util.*;
public class Graph {
	
	private ArrayList<Node> listNodes;
	
	public Graph(ArrayList<Node> listNodes) {
		this.listNodes = listNodes;
		
	}
	
	public void addNode(Node node) {
		listNodes.add(node);
	}
	
	public Node getNode(int i) {
		return this.listNodes.get(i);
	}
	
	public ArrayList<Node> getListNodes() {
		return listNodes;
	}
	
}
