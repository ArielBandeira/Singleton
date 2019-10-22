package br.com.map;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.DAO.DaoException;

public class Main {

	public static void main(String[] args) throws DaoException {
		Facade facade = new Facade();
		Scanner sc = new Scanner(System.in);

		System.out.println(" 1. Adicionar Usuario\n 2. Adicionar OS\n 3. Remover OS\n 4. Remover Usuario\n 5. Resolver OS\n 0. Sair: ");
		int op = sc.nextInt();

		while (op != 0) {
			if (op == 1) {
				System.out.println("CADASTRO DE USUARIO");
				System.out.println("Nome: ");
				String nome = sc.next();
				
				System.out.println("CPF: ");
				String cpf = sc.next();

				facade.addUsuario(nome, cpf);
				System.out.println("Usuario Inserido com Sucesso!");

			} else if (op == 2) {
				System.out.println("CADASTRO DE ORDEM DE SERVIÇO");
				System.out.println("Titulo: ");
				String titulo = sc.next();
				
				System.out.println("Descricao: ");
				String descricao = sc.next();
				
				System.out.println("CPF do Usuario: ");
				String cpf = sc.next();

				facade.addOS(titulo, descricao, cpf);

			} else if (op == 3) {
				System.out.println("REMOVER DE ORDEM DE SERVIÇO");
				System.out.println("CPF do Usuario: ");
				String cpf = sc.next();
				System.out.println("Titulo: ");
				String titulo = sc.next();

			if(facade.removeOS(cpf, titulo)){
				System.out.println("Ordem Removida!");
			}else {
				System.out.println(" A Ordem Já Foi Removida!");
			}

				
			} else if (op == 4) {
				System.out.println("REMOVER USUARIO");
				
				System.out.println("CPF do Usuario: ");
				String cpf = sc.next();

				facade.apagarUsuario(cpf);
			} else if (op == 5) {
				System.out.println("RESOLVER OS");
				
				System.out.println("CPF do Usuario: ");
				String cpf = sc.next();
				
				System.out.println("Titulo: ");
				String titulo = sc.next();

				facade.resolveOS(cpf, titulo);
			} 

			System.out.println(
					" 1. Adicionar Usuario\n 2. Adicionar OS\n 3. Remover OS\n 4. Remover Usuario\n 5. Resolver OS\n 0. Sair: ");
			op = sc.nextInt();
		}
		sc.close();
	
	}
}
