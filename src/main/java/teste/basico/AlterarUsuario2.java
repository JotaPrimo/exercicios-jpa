package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager entityManager = managerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		
		Usuario usuario = entityManager.find(Usuario.class, 3L);
		// detach desassocia o objeto do estado gerenciado
		// com isso ele n�o alt
		entityManager.detach(usuario);
		usuario.setNome("Teste Edi��o");
		// caso eu use o metodo merge de entity manage, a altera��o ser� aplicada
		
		// entityManager.merge(usuario);		
		entityManager.getTransaction().commit();
		
		
		managerFactory.close();
		entityManager.close();
		

	}

}
