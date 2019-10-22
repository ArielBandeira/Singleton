package br.com.map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrdemDeServico {
	private String titulo;
	private String descricao;
	private Boolean aberta;
	
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Construtor padrão.
	 * 
	 * @param titulo    da OrdemDeServico
	 * @param descricao da OrdemDeServico
	 */
	public OrdemDeServico(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.aberta = true;
	}
	
	public OrdemDeServico() {
		// TODO Auto-generated constructor stub
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public Boolean getAberta() {
		return aberta;
	}

	public void setAberta(boolean aberta) {
	    this.aberta = aberta;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
