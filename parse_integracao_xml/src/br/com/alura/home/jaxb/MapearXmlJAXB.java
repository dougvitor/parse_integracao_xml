package br.com.alura.home.jaxb;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.alura.home.model.Produto;
import br.com.alura.home.model.Venda;

public class MapearXmlJAXB {
	
	public static void main(String[] args) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Venda.class);
		parseXmlObject(context);
		
		System.out.println("\n\n");
		
		parseObjectXml(context);
	}

	private static void parseXmlObject(JAXBContext context) throws JAXBException {
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Venda venda = (Venda) unmarshaller.unmarshal(new File("resources/venda.xml"));
		
		System.out.println(venda);
	}
	
	private static void parseObjectXml(JAXBContext context) throws JAXBException {
		Venda venda = new Venda();
		venda.setFormaPagamento("Crediário");
		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto("Codificando em JAVA", 55.00));
		produtos.add(new Produto("Codificando em C#", 10.00));
		venda.setProdutos(produtos);
		
		StringWriter writer = new StringWriter();
		
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(venda, writer);
		
		System.out.println(writer.toString());
		
	}

}
