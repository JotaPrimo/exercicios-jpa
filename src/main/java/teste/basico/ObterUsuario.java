package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class ObterUsuario {
	
	public static void main(String[] args) {
		
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();		
	
		
		
		 Usuario usuario = entityManager.find(Usuario.class, 1L);
		 
		 if(usuario instanceof Usuario) {
			 System.out.println(usuario.toString());
		 }else {
			 System.out.println("Usuario não encontrado");
		 }	 		
		
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
