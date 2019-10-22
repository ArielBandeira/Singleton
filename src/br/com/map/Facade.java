package br.com.map;

import java.sql.SQLException;
import java.util.HashMap;

import br.com.DAO.DaoException;
import br.com.DAO.OrdemDeServicoDAO;
import br.com.DAO.UsuarioDao;

public class Facade {
	private HashMap<String, Usuario> usuarios;

	public Facade() {
		this.usuarios = new HashMap<>();
		UsuarioDao dao = new UsuarioDao();
		try {
			for(Usuario u : dao.all()) {
				this.usuarios.put(u.getCpf(), u);
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addUsuario(String nome, String cpf) throws DaoException {
		Usuario u = new Usuario(nome, cpf);
		UsuarioDao usu = new UsuarioDao();
		usu.save(u);
		usuarios.put(cpf, u);
	}

	
    //Apagar usuário 
	public void apagarUsuario(String cpf) throws DaoException {
		UsuarioDao usu = new UsuarioDao();
		Usuario usuario = this.usuarios.remove(cpf);
		usu.remove(usuario);
	}

	public boolean addOS(String titulo, String descricao, String cpf) {
		OrdemDeServico os = FacadeSimpleFactory.ordemDeServico(titulo, descricao);
		OrdemDeServicoDAO odao = new OrdemDeServicoDAO();
		try {
			odao.save(os);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Usuario u = this.usuarios.get(cpf);
		if(u.addOs(os)) {
			UsuarioDao udao = new UsuarioDao();
			try {
				udao.update(u);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		return false;
		
	}
	
	//remover ondem de serviço
	public boolean removeOS(String cpf, String titulo) {
		
		Usuario u = this.usuarios.get(cpf);
		OrdemDeServico or = u.removerOs(titulo);
		if(or != null) {
			UsuarioDao udao = new UsuarioDao();
			try {
				udao.update(u);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			OrdemDeServicoDAO odao = new OrdemDeServicoDAO();
			try {
				odao.remove(or);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	public boolean resolveOS(String cpf, String titulo) {
		Usuario u = this.usuarios.get(cpf);
		OrdemDeServico or = u.resolveOS(titulo);
		OrdemDeServicoDAO odao = new OrdemDeServicoDAO();
		try {
			odao.update(or);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.usuarios.get(cpf).resolveOS(titulo);
		return true;	
	}
}
