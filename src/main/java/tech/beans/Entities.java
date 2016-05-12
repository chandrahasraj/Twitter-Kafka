package tech.beans;

public class Entities {
	HashTags hashtags[];
	Object symbols, user_mentions, urls,media;
	
	public Object getMedia() {
		return media;
	}

	public void setMedia(Object media) {
		this.media = media;
	}

	public Entities(){}

	public Entities(Object symbols, Object user_mentions, Object urls, HashTags[] hashtags) {
		super();
		this.symbols = symbols;
		this.user_mentions = user_mentions;
		this.urls = urls;
		this.hashtags = hashtags;
	}

	public Object getSymbols() {
		return symbols;
	}

	public void setSymbols(Object symbols) {
		this.symbols = symbols;
	}

	public Object getUser_mentions() {
		return user_mentions;
	}

	public void setUser_mentions(Object user_mentions) {
		this.user_mentions = user_mentions;
	}

	public Object getUrls() {
		return urls;
	}

	public void setUrls(Object urls) {
		this.urls = urls;
	}

	public HashTags[] getHashtags() {
		return hashtags;
	}

	public void setHashtags(HashTags[] hashtags) {
		this.hashtags = hashtags;
	}

}
