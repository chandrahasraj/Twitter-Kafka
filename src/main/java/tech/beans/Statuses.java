package tech.beans;

public class Statuses {
	String created_at, id_str, text, source, lang;
	Entities entities;
	Object id, truncated, metadata, in_reply_to_status_id, in_reply_to_status_id_str, in_reply_to_user_id,
			in_reply_to_user_id_str, in_reply_to_screen_name, user, geo, coordinates, place, contributors,
			retweeted_status, is_quote_status, retweet_count, favorite_count, favorited, retweeted, possibly_sensitive,
			quoted_status_id,quoted_status_id_str,quoted_status;

	public Object getQuoted_status() {
		return quoted_status;
	}

	public void setQuoted_status(Object quoted_status) {
		this.quoted_status = quoted_status;
	}

	public Object getQuoted_status_id_str() {
		return quoted_status_id_str;
	}

	public void setQuoted_status_id_str(Object quoted_status_id_str) {
		this.quoted_status_id_str = quoted_status_id_str;
	}

	public Object getQuoted_status_id() {
		return quoted_status_id;
	}

	public void setQuoted_status_id(Object quoted_status_id) {
		this.quoted_status_id = quoted_status_id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getId_str() {
		return id_str;
	}

	public void setId_str(String id_str) {
		this.id_str = id_str;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	public Object getTruncated() {
		return truncated;
	}

	public void setTruncated(Object truncated) {
		this.truncated = truncated;
	}

	public Object getMetadata() {
		return metadata;
	}

	public void setMetadata(Object metadata) {
		this.metadata = metadata;
	}

	public Object getIn_reply_to_status_id() {
		return in_reply_to_status_id;
	}

	public void setIn_reply_to_status_id(Object in_reply_to_status_id) {
		this.in_reply_to_status_id = in_reply_to_status_id;
	}

	public Object getIn_reply_to_status_id_str() {
		return in_reply_to_status_id_str;
	}

	public void setIn_reply_to_status_id_str(Object in_reply_to_status_id_str) {
		this.in_reply_to_status_id_str = in_reply_to_status_id_str;
	}

	public Object getIn_reply_to_user_id() {
		return in_reply_to_user_id;
	}

	public void setIn_reply_to_user_id(Object in_reply_to_user_id) {
		this.in_reply_to_user_id = in_reply_to_user_id;
	}

	public Object getIn_reply_to_user_id_str() {
		return in_reply_to_user_id_str;
	}

	public void setIn_reply_to_user_id_str(Object in_reply_to_user_id_str) {
		this.in_reply_to_user_id_str = in_reply_to_user_id_str;
	}

	public Object getIn_reply_to_screen_name() {
		return in_reply_to_screen_name;
	}

	public void setIn_reply_to_screen_name(Object in_reply_to_screen_name) {
		this.in_reply_to_screen_name = in_reply_to_screen_name;
	}

	public Object getUser() {
		return user;
	}

	public void setUser(Object user) {
		this.user = user;
	}

	public Object getGeo() {
		return geo;
	}

	public void setGeo(Object geo) {
		this.geo = geo;
	}

	public Object getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Object coordinates) {
		this.coordinates = coordinates;
	}

	public Object getPlace() {
		return place;
	}

	public void setPlace(Object place) {
		this.place = place;
	}

	public Object getContributors() {
		return contributors;
	}

	public void setContributors(Object contributors) {
		this.contributors = contributors;
	}

	public Object getRetweeted_status() {
		return retweeted_status;
	}

	public void setRetweeted_status(Object retweeted_status) {
		this.retweeted_status = retweeted_status;
	}

	public Object getIs_quote_status() {
		return is_quote_status;
	}

	public void setIs_quote_status(Object is_quote_status) {
		this.is_quote_status = is_quote_status;
	}

	public Object getRetweet_count() {
		return retweet_count;
	}

	public void setRetweet_count(Object retweet_count) {
		this.retweet_count = retweet_count;
	}

	public Object getFavorite_count() {
		return favorite_count;
	}

	public void setFavorite_count(Object favorite_count) {
		this.favorite_count = favorite_count;
	}

	public Object getFavorited() {
		return favorited;
	}

	public void setFavorited(Object favorited) {
		this.favorited = favorited;
	}

	public Object getRetweeted() {
		return retweeted;
	}

	public void setRetweeted(Object retweeted) {
		this.retweeted = retweeted;
	}

	public Object getPossibly_sensitive() {
		return possibly_sensitive;
	}

	public void setPossibly_sensitive(Object possibly_sensitive) {
		this.possibly_sensitive = possibly_sensitive;
	}

	public Entities getEntities() {
		return entities;
	}

	public void setEntities(Entities entities) {
		this.entities = entities;
	}

}
