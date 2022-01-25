package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Cliente;

public class ObterClienteAssento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DAO<Cliente> dao = new DAO<Cliente>(Cliente.class);
		Cliente cliente = dao.obterPorId(3L);

		System.out.println("Assento " + cliente.getAssento().getNome());
		dao.fecharDAO();

	}

}
