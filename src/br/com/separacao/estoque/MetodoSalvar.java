package br.com.separacao.estoque;

import br.com.separacao.conexao.*;
import br.com.separacao.estoque.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MetodoSalvar {

	
	Conexao conex = new Conexao();
	EstoqueClass cadest = new EstoqueClass();
	
	
	public void salvar(EstoqueClass cadest){
		
	  conex.conecta();
	  
	try {
		PreparedStatement pst = conex.con.prepareStatement("insert into estoque (qtd) values(?)");
	    pst.setString(1, cadest.getQtd());
		pst.execute();
		JOptionPane.showMessageDialog(null,"Dados gravados com sucesso!");
	
	} catch (SQLException ex) {
		
		ex.printStackTrace();
		JOptionPane.showMessageDialog(null,"Não inseriu os dados:/Erro"+ex);
	}
		
	}
	
	}	
	

