package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;


public class ObterUsuario {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Usuario usuario = em.find(Usuario.class, 3L);
		System.out.println("Resultados: " + usuario.getNome());
		
		entityManagerFactory.close();
		em.close();
	}

}
