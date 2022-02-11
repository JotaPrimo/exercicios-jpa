package teste.basico;

import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class ObterTodosUsuarios {

	public static void main(String[] args) {
		
		
		 String jpql = "SELECT u FROM Usuario u";
		 
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exercicios-jpa");
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		 // type query jpql
		TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
		query.setMaxResults(5);
		
		List<Usuario> usuarios = query.getResultList();
		
		for (Usuario usuario : usuarios) {
			System.out.println(usuario.toString());
		}
		
		 
		
		 entityManager.close();
		 entityManagerFactory.close();
	}
}
