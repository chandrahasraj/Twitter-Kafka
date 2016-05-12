package tech.beans;

public class HashTags {
	String text;
	Object indices;
	
	
	public HashTags(){}
	public HashTags(String text, Object indices) {
		super();
		this.text = text;
		this.indices = indices;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Object getIndices() {
		return indices;
	}

	public void setIndices(Object indices) {
		this.indices = indices;
	}
}
