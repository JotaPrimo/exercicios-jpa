package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class DAO<E> {
	
	private static EntityManagerFactory entityManagerFactory;
	private  EntityManager entityManager;
	private  Class classe;
	
	static {
		try {
			entityManagerFactory = Persistence.
					createEntityManagerFactory("exercicios-jpa");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		// TODO Auto-generated constructor stub
		this.classe = classe;
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public DAO<E> abrirTransacao() {
		entityManager.getTransaction().begin();
		return this;
	}
	
	public DAO<E> fecharTransacao() {
		entityManager.getTransaction().commit();
		return this;
	}
	
	public DAO<E> incluir(E entidade) {
		entityManager.persist(entidade);
		return this;
	}
	
	
	public DAO<E> incluirAtomico(E entidade) {
		return this.abrirTransacao().incluir(entidade).fecharTransacao();
	}
	
	public List<E> getAll(int qtde, int deslocamento) {
		if(classe == null) {
			throw new UnsupportedOperationException("Classe nula"); 
		}
		
		String jpql = "select e from " + classe.getName() + " e";
		TypedQuery<E> query = entityManager.createQuery(jpql, classe);		
		query.setMaxResults(qtde);
		query.setMaxResults(deslocamento);
		return query.getResultList();		
	}
	
	public List<E> getAll() {
			return this.getAll(10, 0);
	}
	
	public void fechar() {
		entityManager.close();
	}

}
