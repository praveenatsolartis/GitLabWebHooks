
package git.client.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "message", "timestamp", "url", "author", "added", "modified", "removed" })
public class Commit {

	@JsonProperty("id")
	private String id;
	@JsonProperty("message")
	private String message;
	@JsonProperty("timestamp")
	private String timestamp;
	@JsonProperty("url")
	private String url;
	@JsonProperty("author")
	private Author author;
	@JsonProperty("added")
	private List<String> added = null;
	@JsonProperty("modified")
	private List<String> modified = null;
	@JsonProperty("removed")
	private List<Object> removed = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	@JsonProperty("timestamp")
	public String getTimestamp() {
		return timestamp;
	}

	@JsonProperty("timestamp")
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("author")
	public Author getAuthor() {
		return author;
	}

	@JsonProperty("author")
	public void setAuthor(Author author) {
		this.author = author;
	}

	@JsonProperty("added")
	public List<String> getAdded() {
		return added;
	}

	@JsonProperty("added")
	public void setAdded(List<String> added) {
		this.added = added;
	}

	@JsonProperty("modified")
	public List<String> getModified() {
		return modified;
	}

	@JsonProperty("modified")
	public void setModified(List<String> modified) {
		this.modified = modified;
	}

	@JsonProperty("removed")
	public List<Object> getRemoved() {
		return removed;
	}

	@JsonProperty("removed")
	public void setRemoved(List<Object> removed) {
		this.removed = removed;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
