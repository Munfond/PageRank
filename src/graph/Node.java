package graph;
import java.util.ArrayList;

public class Node {
	private double point;
	private String nodeType;
	private String nodeName;
	private String nodeUsername;
	private ArrayList<Integer> listOutNodes;
	private int nodeIndex;
	
	
	public Node(String nodeName, double point, ArrayList<Integer> outNode, String nodeType, String nodeUsername, int index) {
		this.point = point;
		this.listOutNodes = outNode;
		this.nodeType = nodeType;
		this.nodeName = nodeName;
		this.nodeUsername = nodeUsername;
		this.nodeIndex = index;
	}
	
	
	
	public int getNodeIndex() {
		return nodeIndex;
	}

	public void setNodeIndex(int nodeIndex) {
		this.nodeIndex = nodeIndex;
	}

	public void addOutNode(int v) {
		this.listOutNodes.add(v);
	}
	
	public ArrayList<Integer> getListOutNodes() {
		return listOutNodes;
	}
	
	public void increasePoint(double x) {
		this.point = this.point + x;
	}
	
	
	public double getPoint() {
		return point;
	}	
	public void setPoint(double point) {
		this.point = point;
	}
	
	public String getNodeType() {
		return nodeType;
	}	
	
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getNodeUsername() {
		return nodeUsername;
	}

	public void setNodeUsername(String nodeUsername) {
		this.nodeUsername = nodeUsername;
	}	
	
}
