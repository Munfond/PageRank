package kol_information;
import java.util.ArrayList;

public class KOL {
	private String kolUrl, kolUsername;
	private ArrayList<String> listFollowers;
	private ArrayList<Tweet> listTweets;
	private double point;
	
	public KOL(String kolUrl, ArrayList<String> listFollowers, ArrayList<Tweet> listTweets, String kolUsername, double point) {
		this.kolUrl = kolUrl;
		this.listFollowers = listFollowers;
		this.listTweets = listTweets;
		this.kolUsername = kolUsername;
		this.point = point;
	}
	
	public int getNumberFollowers() {
		return this.listFollowers.size();
	}	
	
	
	
	public String getKolUrl() {
		return kolUrl;
	}

	public void setKolUrl(String kolUrl) {
		this.kolUrl = kolUrl;
	}

	public ArrayList<String> getListFollowers() {
		return listFollowers;
	}
	
	public void setListFollowers(ArrayList<String> listFollowers) {
		this.listFollowers = listFollowers;
	}
	
	public ArrayList<Tweet> getListTweets() {
		return listTweets;
	}
	
	public void setListTweets(ArrayList<Tweet> listTweets) {
		this.listTweets = listTweets;
	}

	public String getKolUsername() {
		return kolUsername;
	}

	public void setKolUsername(String kolUsername) {
		this.kolUsername = kolUsername;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}
	
}
