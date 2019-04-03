package DOMparser;

public class InformationForVK {

    private int beginIndex;
    private int endIndex;
    private String methodPost;
    private String paramMessage;
    private String value;
    private String methodEdit;
    private String postId;
    private String newValue;
    private String accessToken;
    private String ownerId;
    private String id;
    private String version;
    private String numberOfVersion;
    private String token;
    private String https;

    public int getBeginIndex() {
        return beginIndex;
    }

    public void setBeginIndex(int beginIndex) {
        this.beginIndex = beginIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public String getMethodPost() {
        return methodPost;
    }

    public void setMethodPost(String methodPost) {
        this.methodPost = methodPost;
    }

    public String getParamMessage() {
        return paramMessage;
    }

    public void setParamMessage(String paramMessage) {
        this.paramMessage = paramMessage;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMethodEdit() {
        return methodEdit;
    }

    public void setMethodEdit(String methodEdit) {
        this.methodEdit = methodEdit;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNumberOfVersion() {
        return numberOfVersion;
    }

    public void setNumberOfVersion(String numberOfVersion) {
        this.numberOfVersion = numberOfVersion;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getHttps() {
        return https;
    }

    public void setHttps(String https) {
        this.https = https;
    }

    @Override
    public String toString() {
        return "InformationForVK{" +
                "beginIndex=" + beginIndex +
                ", endIndex=" + endIndex +
                ", methodPost='" + methodPost + '\'' +
                ", paramMessage='" + paramMessage + '\'' +
                ", value='" + value + '\'' +
                ", methodEdit='" + methodEdit + '\'' +
                ", postId='" + postId + '\'' +
                ", newValue='" + newValue + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", id='" + id + '\'' +
                ", version='" + version + '\'' +
                ", numberOfVersion='" + numberOfVersion + '\'' +
                ", token='" + token + '\'' +
                ", https='" + https + '\'' +
                '}';
    }
}
