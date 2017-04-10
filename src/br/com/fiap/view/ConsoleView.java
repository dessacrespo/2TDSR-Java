package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.entity.Pacote;

public class ConsoleView {

	public static void main(String[] args) {
		//Listar os pacotes cadastrados
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		PacoteDAO dao = new PacoteDAOImpl(em);
		
		List<Pacote> pacotes = dao.listar();
		for (Pacote pacote : pacotes) {
			System.out.println(pacote.getDescricao() 
				+ " R$"+ pacote.getPreco() + 
				" Dias: " + pacote.getQtdDias());
		}
		
		List<Pacote> porPreco = dao.buscarPorPreco(100, 1000);
		for (Pacote pacote : porPreco) {
			System.out.println(pacote.getDescricao() 
				+ " R$"+ pacote.getPreco() + 
				" Dias: " + pacote.getQtdDias());
		}
		
		em.close();
		System.exit(0);
	}

}







