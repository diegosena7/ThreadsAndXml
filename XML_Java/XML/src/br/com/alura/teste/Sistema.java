package br.com.alura.teste;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.alura.model.Produto;

public class Sistema {
	
	public static void main(String[] args) throws Exception {
//DocumentBuilderFactory carrega o documento xml na memória e usamos o método newInstance() para obtermos uma referência desse tipo.
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = fabrica.newDocumentBuilder();//newDocumentBuilder novo construtor de documentos
		Document document = builder.parse("src/vendas.xml");//Retorna para a variável document um objeto do formato xml passado ao construtor
		Element venda = document.getDocumentElement();//Pega o elemento da tag principal
		
		fabrica.setValidating(true);//Valida o documento xsd
		fabrica.setNamespaceAware(true);//Pega o arquivo de validação (xsd)
		fabrica.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		
		String moeda = venda.getAttribute("moeda");//Pega o atributo da tag venda
		System.out.println(moeda);
		NodeList produtos = document.getElementsByTagName("produto");// utiliza a getElementsByTagName para acessar a tag
		
		for(int i = 0; i < produtos.getLength(); i ++) {//precorre os produtos
			Element produto = (Element) produtos.item(i);//acessa o elemento na posição informada
			
			String nome = produto.getElementsByTagName("nome").item(0).getTextContent();//Pega o conteúdo de texto do arquivo xml
			double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());//Pega o conteúdo de texto do arquivo xml
			Produto prod = new Produto(nome, preco);
			
			System.out.println(prod);//imprime na tela a informação
		}
	}
}
