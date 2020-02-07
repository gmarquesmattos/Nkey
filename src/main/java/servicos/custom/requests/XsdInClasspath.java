package servicos.custom.requests;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import utils.CommonUtils;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;
import java.io.StringWriter;

public class XsdInClasspath extends TypeSafeMatcher<String> {

    private final String xsdFile;

    private XsdInClasspath(String xsdFile) {
        this.xsdFile = xsdFile;
    }

    @Override
    protected boolean matchesSafely(String xmlResponse) {
        try {
            xmlResponse = xmlResponse.replaceAll("(<\\?[^<]*\\?>)?", "")
                .replaceAll("xmlns.*?(\"|\').*?(\"|\')", "")
                .replaceAll("(<)(\\w+:)(.*?>)", "$1$3")
                .replaceAll("(</)(\\w+:)(.*?>)", "$1$3")
                .replaceAll(" >", ">").replaceAll(" />", "/>")
                .replaceAll("\n", "")
                .replaceAll(">\\s*<", "><");

            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(xmlResponse)));

            XPath xPath = XPathFactory.newInstance().newXPath();
            Node result = (Node)xPath.evaluate("/Envelope/Body/child::node()", doc, XPathConstants.NODE);

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(CommonUtils.getFileFromResources(xsdFile));

            Validator validator = schema.newValidator();
            System.out.println(nodeToString(result));
            validator.validate(new StreamSource(new StringReader(nodeToString(result))));

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Esperava que o XML (sem as tags Envelope, Header e Body) estivesse conforme designado no XSD " + xsdFile);
    }

    public static Matcher<String> matchesXsdInClasspath(String xsdFile) {
        return new XsdInClasspath(xsdFile);
    }

    private static String nodeToString(Node node) throws TransformerException {
        StringWriter buf = new StringWriter();
        Transformer xform = TransformerFactory.newInstance().newTransformer();
        xform.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        xform.transform(new DOMSource(node), new StreamResult(buf));
        return(buf.toString());
    }
}
