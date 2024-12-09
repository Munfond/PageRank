package data_reader_and_printer;

import java.util.ArrayList;

import kol_information.KOL;
import kol_information.Tweet;

public class DataProcessor {
	
	public static ArrayList<KOL> runDataProcessor(ArrayList<String[]> lines) {
		ArrayList<KOL> listKOL = new ArrayList<>();
		int index = 1;
    	
    	while (index < lines.size()) {
    		ArrayList<String> listFollowers = new ArrayList<>();
    		ArrayList<Tweet> listTweets = new ArrayList<>();
    		
    		String[] line = lines.get(index++);
    		
    		
    		String kolURL = line[0], kolUsername = line[1];
    		
    		if (Integer.parseInt(line[2]) != 0) {
	    		String followersStr = line[3] + " ";
	    		String follower = "";
	    		
	    		for (int i = 0; i < followersStr.length(); ++i) {
	    			char c = followersStr.charAt(i);
	    			if (c == ' ') {
	    				listFollowers.add(follower);
	    				follower = "";
	    			} else {
	    				follower += c;
	    			}
	    		}
    		}
    		
    		if (Integer.parseInt(line[4]) != 0) {
    		
	    		String tweetStr = line[5] + " ";
	    		
	    		boolean check = false;
	    		String tweetLink = "", tweetOwner = "";
	    		
	    		for (int i = 0; i < tweetStr.length(); ++i) {
	    			char c = tweetStr.charAt(i);
	    			if (c == ' ') {
	    				if (check) {
	    					listTweets.add(new Tweet(tweetLink, tweetOwner));
	    					tweetLink = "";
	    					tweetOwner = "";
	    				}
	    				check = !check;
	    			} else {
	    				if (!check) {
	    					tweetOwner += c;
	    				} else {
	    					tweetLink += c;
	    				}
	    			}
	    		}

    		}
    		
    		listKOL.add(new KOL(kolURL, listFollowers, listTweets, kolUsername, 0));
//    		if (listKOL.size() == 20) break;
    	}
    	
//    	for (int i = 0 ; i < listKOL.size(); ++i) {
//    		System.out.print(listKOL.get(i).getKolUsername());
//    		System.out.print(" -> Number Followers: " + listKOL.get(i).getListFollowers().size());
//    		System.out.println(" -> Number Tweets: " + listKOL.get(i).getListTweets().size());
//    	}
    	
    	return listKOL;
	}
}
