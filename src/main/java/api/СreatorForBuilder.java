package api;

import DOMparser.RunnerDOM;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class СreatorForBuilder {

    static URIBuilder createBuilder(String method) {
        URIBuilder builderForGetAllMessage = null;
        try {
            builderForGetAllMessage = new URIBuilder(String.format(RunnerDOM.getInfo().getHttps(), method));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        builderForGetAllMessage.setParameter(RunnerDOM.getInfo().getAccessToken(), RunnerDOM.getInfo().getToken())
                .setParameter(RunnerDOM.getInfo().getOwnerId(), RunnerDOM.getInfo().getId())
                .setParameter(RunnerDOM.getInfo().getVersion(), RunnerDOM.getInfo().getNumberOfVersion());
        return builderForGetAllMessage;
    }

    static String getPostID(URIBuilder builderForCommit) {
        HttpGet request = null;
        try {
            request = new HttpGet(builderForCommit.build());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = null;
        try {
            response = client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.getStatusLine().getStatusCode();
        String postId = null;
        try {
            postId = (EntityUtils.toString(response.getEntity())).substring(RunnerDOM.getInfo().getBeginIndex(), RunnerDOM.getInfo().getEndIndex());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return postId;
    }

    public static HttpResponse getResponse(URIBuilder builder) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = null;
        HttpGet request = null;
        try {
            request = new HttpGet(builder.build());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            response = client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}