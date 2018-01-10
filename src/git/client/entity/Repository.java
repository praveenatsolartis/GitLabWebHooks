
package git.client.entity;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({ "name", "url", "description", "homepage", "git_http_url", "git_ssh_url", "visibility_level" })
public class Repository {

	@JsonProperty("name")
	private String name;
	@JsonProperty("url")
	private String url;
	@JsonProperty("description")
	private String description;
	@JsonProperty("homepage")
	private String homepage;
	@JsonProperty("git_http_url")
	private String gitHttpUrl;
	@JsonProperty("git_ssh_url")
	private String gitSshUrl;
	@JsonProperty("visibility_level")
	private Integer visibilityLevel;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("homepage")
	public String getHomepage() {
		return homepage;
	}

	@JsonProperty("homepage")
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	@JsonProperty("git_http_url")
	public String getGitHttpUrl() {
		return gitHttpUrl;
	}

	@JsonProperty("git_http_url")
	public void setGitHttpUrl(String gitHttpUrl) {
		this.gitHttpUrl = gitHttpUrl;
	}

	@JsonProperty("git_ssh_url")
	public String getGitSshUrl() {
		return gitSshUrl;
	}

	@JsonProperty("git_ssh_url")
	public void setGitSshUrl(String gitSshUrl) {
		this.gitSshUrl = gitSshUrl;
	}

	@JsonProperty("visibility_level")
	public Integer getVisibilityLevel() {
		return visibilityLevel;
	}

	@JsonProperty("visibility_level")
	public void setVisibilityLevel(Integer visibilityLevel) {
		this.visibilityLevel = visibilityLevel;
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
