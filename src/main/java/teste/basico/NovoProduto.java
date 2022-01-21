package teste.basico;

import java.util.Scanner;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entradaString = new Scanner(System.in);
		Scanner entradaInteiro = new Scanner(System.in);
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		
		Produto produto = new Produto();
		
		System.out.println("Informe o nome do produto ");
		produto.setProd_nome(entradaString.next());
		
		System.out.println("Informe o preço do produto ");
		produto.setProd_preco(entradaInteiro.nextDouble());
		
		dao.incluirAtomico(produto);
		
		System.out.println("Produto incluido com sucessso " + produto.getId());

	}

}
