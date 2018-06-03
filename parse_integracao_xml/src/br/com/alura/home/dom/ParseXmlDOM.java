package br.com.alura.home.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ParseXmlDOM {
	
	public static void main(String[] args) throws Exception {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("resources/venda.xml");
		
		NodeList produtos = document.getElementsByTagName("produto");
		System.out.println("Moeda is " + document.getDocumentElement().getAttribute("moeda"));
		
		for(int i =0; i < produtos.getLength(); i++) {
			Element produto = (Element) produtos.item(i);
			String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
			String preco = produto.getElementsByTagName("preco").item(0).getTextContent();
			
			System.out.println("--------------------------------------------");
			System.out.println("Nome do produto: "+ nome);
			System.out.println("Preco do produto: "+ preco);
			System.out.println("--------------------------------------------");
		}
		
	}
	
}
