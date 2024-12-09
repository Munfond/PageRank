package algorithm;

import java.util.ArrayList;
import graph.*;
//import matrix.*;


public class PageRank {
	
	private static final double epsilon = 1e-8;
	
	public static double[] compute(int iterations, double dampingFactor, Graph graph) {
		
		int numNodes = graph.getListNodes().size();
		
		double[] rank = new double[numNodes];
		
		double[] newRank = new double[numNodes];
		
		for (int i = 0 ; i < numNodes; ++i) {
			rank[i] = newRank[i] = 0.0;
		}
		
		for (int i = 0; i < numNodes; ++i) {
			rank[i] = 1.0 / numNodes;
		}
		
		for (int i = 0; i < iterations; ++i) {
			for (int j = 0; j < numNodes; ++j) {
				newRank[j] = (1.0 - dampingFactor) / numNodes;
			}
			for (Node node : graph.getListNodes()) {
				ArrayList<Integer> outNodes = node.getListOutNodes();
				double sharePoint = rank[node.getNodeIndex()] / (outNodes.isEmpty() ? 1 : outNodes.size());
				for (int outNode : outNodes) {
					newRank[outNode] = newRank[outNode] + dampingFactor * sharePoint;
				}
			}
			
			if (checkEqual(numNodes, rank, newRank)) {
				return newRank;
			}
			
			for (int j = 0; j < numNodes; ++j) {
				rank[j] = newRank[j];
			}
		}
		
		return rank;
	}
	
	private static boolean checkEqual(int numNodes, double[] rank, double newRank[]) {
		for (int i = 0; i < numNodes; ++i) {
			if (Math.abs(rank[i] - newRank[i]) > epsilon) {
				return false;
			}
		}
		return true;
	}

}
