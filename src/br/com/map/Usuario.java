package br.com.map;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	private String nome;
	private String cpf;
	
	@Id
	@GeneratedValue
	private Long id;
	@OneToMany
	private List<OrdemDeServico> ordens;

	/**
	 * Construtor padrão.
	 * 
	 * @param nome do Usuário
	 * @param id 
	 * @param u    do Usuário
	 */
	public Usuario(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.ordens = new ArrayList<OrdemDeServico>();
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método que retorna a próxima OrdemDeServico do Usuario.
	 * 
	 * @return objeto do tipo OrdemDeServico
	 */
	public OrdemDeServico getOss() {
		if (!this.ordens.isEmpty()) {
			return this.ordens.get(0);
		}
		return null;
	}

	/**
	 * Método que adiciona OS ao Usuario.
	 * 
	 * @param os objeto do tipo OrdemDeServico
	 * @return 
	 */
	public boolean addOs(OrdemDeServico os) {
		if(this.ordens.add(os)) {
			return true;
		}
		return false;
	}

	public OrdemDeServico removerOs(String titulo) {
		for (int i = 0; i < ordens.size(); i++) {
			OrdemDeServico os = ordens.get(i);

			if (os.getTitulo().equals(titulo)) {
				ordens.remove(os);
				return os;
			}
		}
		
		return null;
	}
	
	public OrdemDeServico resolveOS(String titulo) {
		for(int i = 0; i< ordens.size(); i++) {
			OrdemDeServico os = ordens.get(i);
		  
		if(os.getTitulo().equals(titulo) && os.getAberta() == true) {
			os.setAberta(false);
			return os;
		}
	  }
		return null;
	}
}
