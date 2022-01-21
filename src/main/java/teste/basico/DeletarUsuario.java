package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class DeletarUsuario {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager entityManager = factory.createEntityManager();

		Usuario usuario = entityManager.find(Usuario.class, 2L);
		
		if(usuario != null) {
			
			entityManager.getTransaction().begin();
			entityManager.remove(usuario);
			entityManager.getTransaction().commit();
		
		}else {
			System.out.println("Usuario não encontrado");
		}
		
		factory.close();
		entityManager.close();
	}

}
