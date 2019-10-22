package br.com.map;

public class FacadeSimpleFactory {
	
	private FacadeSimpleFactory() {
		
	}

	public static Usuario usuario(String nome, String cpf) {
		return new Usuario(nome, cpf);
	}
	
	public static OrdemDeServico ordemDeServico(String titulo, String descricao) {
		return new OrdemDeServico(titulo, descricao);
	}
}
