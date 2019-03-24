package br.com.alura.home.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class NfeXmlParserDOM {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("resources/35180943708379000363550010003096641000000013-procNFe.xml");
		
		XPath xPath = XPathFactory.newInstance().newXPath();
		
		String emitExpression = "/nfeProc/NFe/infNFe/emit";
		String ideExpression = "/nfeProc/NFe/infNFe/ide";
		String protNFeExpression = "/nfeProc/protNFe";
		
		NodeList emit = (NodeList) xPath.compile(emitExpression).evaluate(document, XPathConstants.NODESET);
		NodeList ide = (NodeList) xPath.compile(ideExpression).evaluate(document, XPathConstants.NODESET);
		NodeList protNFe = (NodeList) xPath.compile(protNFeExpression).evaluate(document, XPathConstants.NODESET);
		
		String cnpj = getElementValue("CNPJ", 0, emit);
		String cpf = getElementValue("CPF", 0, emit);
		String nomeFantasia = getElementValue("xFant", 0, emit);
		System.out.println(cnpj);
		System.out.println(cpf);
		System.out.println(nomeFantasia);
		
		String numero = getElementValue("nNF", 0, ide);
		String serie = getElementValue("serie", 0, ide);
		String dataEmissao = getElementValue("dhEmi", 0, ide);
		System.out.println(numero);
		System.out.println(serie);
		System.out.println(dataEmissao);
		
		String chaveNfe = getElementValue("chNFe", 0, protNFe);
		String situacao = getElementValue("cStat", 0, protNFe);
		System.out.println(chaveNfe);
		System.out.println(situacao);
		
	}
	
	private static String getElementValue(String name, int index, NodeList nodeList) {
		Element atual = (Element) nodeList.item(index);
		NodeList element = atual.getElementsByTagName(name);
		Node node = element.item(index);
		if(node != null) {
			return node.getTextContent();
		}
		
		return null;
		
	}

}
