package br.com.alura.home.xslt;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ConverterXmlWithXSTL {
	
	public static void main(String[] args) throws Exception {
		TransformerFactory factory = TransformerFactory.newInstance();
		
		InputStream template = new FileInputStream("resources/template.xsl");
		StreamSource stylesheet = new StreamSource(template);
		Transformer transformer = factory.newTransformer(stylesheet);
		
		InputStream produtos = new FileInputStream("resources/venda.xml");
		StreamSource source = new StreamSource(produtos);
		StreamResult result = new StreamResult("resources/saida.html");
		transformer.transform(source, result);
		
		System.out.println("Gerado arquivo convertido: saida.html" );
		
	}
}
