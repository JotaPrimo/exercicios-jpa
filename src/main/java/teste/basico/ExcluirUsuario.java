package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class ExcluirUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.
				createEntityManagerFactory("exercicios-jpa");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		Usuario usuario = entityManager.find(Usuario.class, 2L);
		if(usuario != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(usuario);
			entityManager.getTransaction().commit();		
			
		}
		
				
		entityManager.close();
		entityManagerFactory.close();;

	}

}
