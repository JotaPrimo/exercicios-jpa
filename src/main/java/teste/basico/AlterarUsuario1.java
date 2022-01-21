package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario1 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		Usuario usuario = manager.find(Usuario.class, 3L);
		usuario.setNome("Judy Rua Bolinha");
		usuario.setEmail("JudyRuaBolinha@gmail.com");
		manager.merge(usuario);
		
		manager.getTransaction().commit();
		
		
		System.out.println(usuario.getNome());
		
		
		factory.close();
		manager.close();
		
	}

}
