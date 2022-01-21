package modelo.basico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "prod_nome", length = 120, nullable = false)
	private String prod_nome;
	
	@Column(name = "prod_preco", nullable = false, precision = 10, scale = 2)
	private Double prod_preco;
	
	public Produto() {
		
	}

	public Produto(String prod_nome, Double prod_preco) {
		super();
		this.prod_nome = prod_nome;
		this.prod_preco = prod_preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProd_nome() {
		return prod_nome;
	}

	public void setProd_nome(String prod_nome) {
		this.prod_nome = prod_nome;
	}

	public Double getProd_preco() {
		return prod_preco;
	}

	public void setProd_preco(Double prod_preco) {
		this.prod_preco = prod_preco;
	}

	
	
	
	
	

}
