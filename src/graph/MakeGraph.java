package graph;
import java.util.ArrayList;
import java.util.HashMap;

import kol_information.*;

public class MakeGraph extends Graph{
	
	public MakeGraph(ArrayList<Node> listNodes) {
		super(listNodes);
	}
	
	public static Graph makeGraph(ArrayList<KOL> listKOLs) {
		Graph result = new Graph(new ArrayList<>());
		HashMap<String, Integer> map = new HashMap<>();
		
		ArrayList<Integer> outNodes = new ArrayList<>();
		
		int cntNode = 0;
		for (int i = 0; i < listKOLs.size(); ++i) {
			map.put(listKOLs.get(i).getKolUrl(), cntNode++);
			result.addNode(new Node(listKOLs.get(i).getKolUrl(), 0, outNodes, "KOL", listKOLs.get(i).getKolUsername(), cntNode - 1));
		}
		
		for (int i = 0; i < listKOLs.size(); ++i) {
			ArrayList<String> listFollowers = listKOLs.get(i).getListFollowers();
			int v = map.get(listKOLs.get(i).getKolUrl());
			for (int j = 0; j < listFollowers.size(); ++j) {
				if (!map.containsKey(listFollowers.get(j))) {
					map.put(listFollowers.get(j), cntNode++);
					result.addNode(new Node(listFollowers.get(j), 0, outNodes, "Follower", "", cntNode - 1));
				}
				int u = map.get(listFollowers.get(j));
				result.getListNodes().get(u).addOutNode(v);
			}
		}
		
		for (int i = 0; i < listKOLs.size(); ++i) {
			ArrayList<Tweet> listTweets = listKOLs.get(i).getListTweets();
			int v = map.get(listKOLs.get(i).getKolUrl());
			for (int j = 0; j < listTweets.size(); ++j) {
				if (!map.containsKey(listTweets.get(j).getTweetLink())) {
					map.put(listTweets.get(j).getTweetLink(), cntNode++);
					result.addNode(new Node(listTweets.get(j).getTweetLink(), 0, outNodes, "Tweet", "", cntNode - 1));
				}
				int u = map.get(listTweets.get(j).getTweetLink());
				if (listKOLs.get(i).getKolUrl().equals(listTweets.get(j).getTweetOwner())) {
					result.getListNodes().get(u).addOutNode(v);
				} else {
					result.getListNodes().get(v).addOutNode(u);
				}
			}
		}
		
		
		return result;
	}
	
	
}
