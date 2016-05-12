package tech.beans;

public class TwitterBean {

	Statuses statuses[];
	Search_Metadata search_metadata;
	
	public Statuses[] getStatuses() {
		return statuses;
	}
	public void setStatuses(Statuses[] statuses) {
		this.statuses = statuses;
	}
	public Search_Metadata getSearch_metadata() {
		return search_metadata;
	}
	public void setSearch_metadata(Search_Metadata search_metadata) {
		this.search_metadata = search_metadata;
	}
	
	
}
