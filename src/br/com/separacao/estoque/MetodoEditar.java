package br.com.separacao.estoque;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.separacao.conexao.*;
import br.com.separacao.estoque.*;

public class MetodoEditar {

	
	Conexao conex = new Conexao();
	EstoqueClass cadest = new EstoqueClass();
	
	
	public void editar(EstoqueClass cadest){
		
		conex.conecta();
		
		try {
		PreparedStatement pst = conex.con.prepareStatement("UPDATE estoque SET qtd = ? WHERE id = ?");
	    pst.setString(1, cadest.getQtd());
		pst.executeUpdate();
		JOptionPane.showMessageDialog(null, "Editado com sucesso");

		
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"Os dados não foram editados:/Erro"+ex);
		}
		
	}
	
	
}
