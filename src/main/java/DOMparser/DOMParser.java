package DOMparser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DOMParser {

    public List<InformationForVK> parse(Document document) {
        NodeList nodeList = document.getElementsByTagName("Information");
        List<InformationForVK> allInformation = new ArrayList<InformationForVK>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            allInformation.add(getNeedInfo(nodeList.item(i)));
        }
        return allInformation;
    }

    private static InformationForVK getNeedInfo(Node node) {
        InformationForVK informationForVK = new InformationForVK();
        Element element = (Element) node;
        informationForVK.setBeginIndex(Integer.parseInt(getTagValue("BEGIN_INDEX", element)));
        informationForVK.setEndIndex(Integer.parseInt(getTagValue("END_INDEX", element)));
        informationForVK.setAccessToken(getTagValue("ACESS_TOKEN", element));
        informationForVK.setHttps(getTagValue("HTTPS", element));
        informationForVK.setId(getTagValue("ID", element));
        informationForVK.setVersion(getTagValue("VERSOIN", element));
        informationForVK.setValue(getTagValue("VALUE", element));
        informationForVK.setToken(getTagValue("TOKEN", element));
        informationForVK.setPostId(getTagValue("POST_ID", element));
        informationForVK.setParamMessage(getTagValue("PARAM_MESSAGE", element));
        informationForVK.setOwnerId(getTagValue("OWNER_ID", element));
        informationForVK.setNumberOfVersion(getTagValue("NUMBER_OF_VERSION", element));
        informationForVK.setNewValue(getTagValue("NEW_VALUE", element));
        informationForVK.setMethodPost(getTagValue("METHOD_POST", element));
        informationForVK.setMethodEdit(getTagValue("METHOD_EDIT", element));
        return informationForVK;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}
