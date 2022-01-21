package teste.basico;

import java.util.List;

import modelo.basico.Produto;
import modelo.basico.ProdutoDAO;

public class ObterProdutos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> listProdutos = dao.obterTodos();
		
		for (Produto produto : listProdutos) {
			System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getProd_nome());
		}
		
		double precoTotal = listProdutos
				.stream()
				.map(p -> p.getProd_preco())
				.reduce(0.0, (t, p) -> t + p)
				.doubleValue();
		
		System.out.println("O valor total é R$ " + precoTotal);
		
		dao.fecharDAO();

	}

}
