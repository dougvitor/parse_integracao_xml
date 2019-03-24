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
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class NfeXmlParserDOM {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("resources/35180943708379000363550010003096641000000013-procNFe.xml");
		
		XPath xPath = XPathFactory.newInstance().newXPath();
		
		String emitExpression = "/nfeProc/NFe/infNFe/emit/";
		String ideExpression = "/nfeProc/NFe/infNFe/ide/";
		String protNFeExpression = "/nfeProc/protNFe/infProt/";
		
		String cnpj = getElementValue(document, xPath, emitExpression, "CNPJ");
		String cpf = getElementValue(document, xPath, emitExpression, "CPF"); 
		String razaoSocial = getElementValue(document, xPath, emitExpression, "xNome"); 
		String nomeFantasia = getElementValue(document, xPath, emitExpression,  "xFant"); 
		System.out.println(cnpj);
		System.out.println(cpf);
		System.out.println(razaoSocial);
		System.out.println(nomeFantasia);
		
		String numero = getElementValue(document, xPath, ideExpression, "nNF");
		String serie = getElementValue(document, xPath, ideExpression, "serie");
		String dataEmissao = getElementValue(document, xPath, ideExpression, "dhEmi");
		System.out.println(numero);
		System.out.println(serie);
		System.out.println(dataEmissao);
		
		String chaveNfe = getElementValue(document, xPath, protNFeExpression, "chNFe");
		String situacao = getElementValue(document, xPath, protNFeExpression, "cStat");
		System.out.println(chaveNfe);
		System.out.println(situacao);
		
	}
	
	private static String getElementValue(Document document, XPath xPath, String expression, String tagName) throws XPathExpressionException {
		Node node = (Node) xPath.compile(expression.concat(tagName)).evaluate(document, XPathConstants.NODE);
		if(node != null) {
			return node.getTextContent();
		}
		return null;
		
	}

}
