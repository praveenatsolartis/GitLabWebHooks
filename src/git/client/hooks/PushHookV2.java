package git.client.hooks;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import git.client.entity.Commit;
import git.client.entity.Project;
import git.client.entity.Repository;


@JsonPropertyOrder({
    "object_kind",
    "before",
    "after",
    "ref",
    "checkout_sha",
    "user_id",
    "user_name",
    "user_username",
    "user_email",
    "user_avatar",
    "project_id",
    "project",
    "repository",
    "commits",
    "total_commits_count"
})
public class PushHookV2 {

    @JsonProperty("object_kind")
    private String objectKind;
    @JsonProperty("before")
    private String before;
    @JsonProperty("after")
    private String after;
    @JsonProperty("ref")
    private String ref;
    @JsonProperty("checkout_sha")
    private String checkoutSha;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("user_username")
    private String userUsername;
    @JsonProperty("user_email")
    private String userEmail;
    @JsonProperty("user_avatar")
    private String userAvatar;
    @JsonProperty("project_id")
    private Integer projectId;
    @JsonProperty("project")
    private Project project;
    @JsonProperty("repository")
    private Repository repository;
    @JsonProperty("commits")
    private List<Commit> commits = null;
    @JsonProperty("total_commits_count")
    private Integer totalCommitsCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("object_kind")
    public String getObjectKind() {
        return objectKind;
    }

    @JsonProperty("object_kind")
    public void setObjectKind(String objectKind) {
        this.objectKind = objectKind;
    }

    @JsonProperty("before")
    public String getBefore() {
        return before;
    }

    @JsonProperty("before")
    public void setBefore(String before) {
        this.before = before;
    }

    @JsonProperty("after")
    public String getAfter() {
        return after;
    }

    @JsonProperty("after")
    public void setAfter(String after) {
        this.after = after;
    }

    @JsonProperty("ref")
    public String getRef() {
        return ref;
    }

    @JsonProperty("ref")
    public void setRef(String ref) {
        this.ref = ref;
    }

    @JsonProperty("checkout_sha")
    public String getCheckoutSha() {
        return checkoutSha;
    }

    @JsonProperty("checkout_sha")
    public void setCheckoutSha(String checkoutSha) {
        this.checkoutSha = checkoutSha;
    }

    @JsonProperty("user_id")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @JsonProperty("user_name")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("user_name")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("user_username")
    public String getUserUsername() {
        return userUsername;
    }

    @JsonProperty("user_username")
    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    @JsonProperty("user_email")
    public String getUserEmail() {
        return userEmail;
    }

    @JsonProperty("user_email")
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @JsonProperty("user_avatar")
    public String getUserAvatar() {
        return userAvatar;
    }

    @JsonProperty("user_avatar")
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    @JsonProperty("project_id")
    public Integer getProjectId() {
        return projectId;
    }

    @JsonProperty("project_id")
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @JsonProperty("project")
    public Project getProject() {
        return project;
    }

    @JsonProperty("project")
    public void setProject(Project project) {
        this.project = project;
    }

    @JsonProperty("repository")
    public Repository getRepository() {
        return repository;
    }

    @JsonProperty("repository")
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @JsonProperty("commits")
    public List<Commit> getCommits() {
        return commits;
    }

    @JsonProperty("commits")
    public void setCommits(List<Commit> commits) {
        this.commits = commits;
    }

    @JsonProperty("total_commits_count")
    public Integer getTotalCommitsCount() {
        return totalCommitsCount;
    }

    @JsonProperty("total_commits_count")
    public void setTotalCommitsCount(Integer totalCommitsCount) {
        this.totalCommitsCount = totalCommitsCount;
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
