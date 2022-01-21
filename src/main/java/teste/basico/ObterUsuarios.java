package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class ObterUsuarios {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		// preparando consulta jpql
		String jpql = "SELECT u FROM Usuario u";
		TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
		query.setMaxResults(5);
		
		// Variavel do tipo list para armazenar os dados
		List<Usuario> usuarios = query.getResultList();
		
		for (Usuario usuario : usuarios) {
			System.out.println("ID : " + usuario.getId() + " --->  E-mail : " + usuario.getEmail());
		}
		
		entityManagerFactory.close();
		entityManager.clear();
	}
}
