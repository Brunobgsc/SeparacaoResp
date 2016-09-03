package br.com.separacao.conexao;

import java.sql.*;
import javax.swing.JOptionPane;

import br.com.separacao.interfacegrafica.*;

public class Conexao
{

String driver = "org.postgresql.Driver";
String url = "jdbc:postgresql://localhost/javapadraodb";
String usuario = "postgres";
String senha = "123";

public Connection con;
public Statement stm;
public ResultSet resultset;
public ResultSet rs;    

 public boolean conecta()
 {
 
	 boolean result = true;
 
 try
 {
    Class.forName(driver);

 con = DriverManager.getConnection(url, usuario, senha);
 //JOptionPane.showMessageDialog(null,"Conectado");

 
 }
 
 catch(ClassNotFoundException Driver)
 
 {
  JOptionPane.showMessageDialog(null,"Driver nao Localizado:"+Driver);
  result = false;
  
  }
 catch(SQLException Fonte)

  {

 JOptionPane.showMessageDialog(null,"Deu erro na conexao"+ "com a fonte de dados:"+Fonte);

 result = false;

  }
  return result;

  }

  public void executeSQL(String sql)
  {

 try

 {

    stm = con.createStatement(
    ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    resultset = stm.executeQuery(sql);
    resultset = stm.executeQuery(sql);

  }
catch(SQLException sqlex)

  {

//JOptionPane.showMessageDialog(null,"Campo pesquisar vazio!");

  }


   }

    public String resultset(String codigo) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void setExtendedState(int MAXIMIZED_BOTH) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    
    }
    
