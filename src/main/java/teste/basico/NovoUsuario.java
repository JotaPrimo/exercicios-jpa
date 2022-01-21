package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {
	
	public static void main(String[] args) {
		
		// cria o EntityManager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		
		// Conexao
		// posso criar mais de um EntityManager, cada uma para um banco especifico
		EntityManager em = emf.createEntityManager();
		
		Usuario novoUsuario = new Usuario();
		novoUsuario.setNome("Jota");
		novoUsuario.setEmail("Jota@gmail.com");				
		em.getTransaction().begin();
		em.persist(novoUsuario);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
