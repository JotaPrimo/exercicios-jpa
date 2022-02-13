package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.
				createEntityManagerFactory("exercicios-jpa");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Usuario usuario = entityManager.find(Usuario.class, 3L);
		// detach tira o objeto do estado gerenciado
		// s� ser� editado explicitamente usando o metodo merge
		entityManager.detach(usuario);
		
		if(usuario instanceof Usuario) {
			usuario.setEmail("jotajota@gmail.com"); 
		}
		
		// update precisa do merge para ser efetivo
		 entityManager.merge(usuario);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();

	}

}
