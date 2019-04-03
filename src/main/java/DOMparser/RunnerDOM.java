package DOMparser;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class RunnerDOM {

    private static final String COUNTRIES_XML = "InfoForVK.xml";
    private static final int ROOT_ELEMENT = 0;

    public static InformationForVK getInfo() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            document = dBuilder.parse(COUNTRIES_XML);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<InformationForVK> allInformation = null;
        allInformation = new DOMParser().parse(document);
        return allInformation.get(ROOT_ELEMENT);
    }
}
