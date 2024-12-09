package kol_information;

public class Tweet {
	private String tweetLink, tweetOwner;
	
	public Tweet(String tweetLink, String tweetOwner) {
		this.tweetLink = tweetLink;
		this.tweetOwner = tweetOwner;
	}

	public String getTweetLink() {
		return tweetLink;
	}

	public void setTweetLink(String tweetLink) {
		this.tweetLink = tweetLink;
	}

	public String getTweetOwner() {
		return tweetOwner;
	}

	public void setTweetOwner(String tweetOwner) {
		this.tweetOwner = tweetOwner;
	}
	
}
