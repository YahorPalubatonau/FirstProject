package api;

import DOMparser.RunnerDOM;
import org.apache.http.HttpResponse;
import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;


public class VkAPIConnect {
    private final static Logger logger = Logger.getLogger(VkAPIConnect.class);

    private URIBuilder builderForEdit;
    private URIBuilder builderForCommit;

    public URIBuilder addCommitOnWall() {
        logger.info("Send message by API");
        builderForCommit = СreatorForBuilder.createBuilder(RunnerDOM.getInfo().getMethodPost())
                .setParameter(RunnerDOM.getInfo().getParamMessage(), RunnerDOM.getInfo().getValue());
        logger.info("Message was sand by API");
        return builderForCommit;
    }

    public URIBuilder editCommit() {
        logger.info("Edit message by API");
        builderForEdit = СreatorForBuilder.createBuilder(RunnerDOM.getInfo().getMethodPost())
                .setParameter(RunnerDOM.getInfo().getParamMessage(), RunnerDOM.getInfo().getValue());
        String postId = СreatorForBuilder.getPostID(builderForEdit);
        СreatorForBuilder.createBuilder(RunnerDOM.getInfo().getMethodEdit())
                .setParameter(RunnerDOM.getInfo().getPostId(), postId)
                .setParameter(RunnerDOM.getInfo().getParamMessage(), RunnerDOM.getInfo().getNewValue());
        logger.info("Message was edited by API");
        return builderForEdit;
    }

    public HttpResponse getHttpResponseForAddCommit() {
        HttpResponse httpResponse = СreatorForBuilder.getResponse(this.builderForCommit);
        return httpResponse;
    }

    public HttpResponse getHttpResponseForEdit() {
        HttpResponse httpResponse = СreatorForBuilder.getResponse(this.builderForEdit);
        return httpResponse;
    }

}