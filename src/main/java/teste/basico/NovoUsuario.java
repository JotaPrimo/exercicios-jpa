package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {
	
	public static void main(String[] args) {
		
		// entoityMangerfactory deve ser instanciado a partir de Persistence 	 
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		Usuario usuario = new Usuario("Djalma", "djalma@lanche.combr");
		// persist só funciona dentro de uma transação
		
		entityManager.getTransaction().begin();;
		entityManager.persist(usuario);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
	}

}
