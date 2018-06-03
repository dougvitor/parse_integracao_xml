package br.com.alura.home.sax;

import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class ParseXmlSAX {
	
	public static void main(String[] args) throws Exception {
		// codigo que vai converter o xml em objetos produtos
		XMLReader reader = XMLReaderFactory.createXMLReader();
		ProdutoHandler ph = new ProdutoHandler();
		reader.setContentHandler(ph);
		
		InputStream is = new FileInputStream("resources/venda.xml");
		
		reader.parse(new InputSource(is));
		
		System.out.println(ph.getProdutos());
		
	}
}
