package com.microsoft.sqlserver.principal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.jdbc.SQLServerConexao;

public class Principal extends SQLServerConexao {
	
	public Principal() {
		super.configuraConexao();
	}
	
	public void consultaCep(String sql) throws SQLException{
		List<String> listaRetorno = new ArrayList<String>();
			String string = null;
		
			this.comandoSql = conexao.prepareStatement(sql);			
			ResultSet resultadoSql = comandoSql.executeQuery();
			
			while(resultadoSql.next()){
				string = new String();
				
				string = resultadoSql.getString("CD_CEP");
				
				listaRetorno.add(string);
			}
		
		System.out.println(listaRetorno);
	}
	
	public static void main(String[] args) throws SQLException {
		Principal principal = new Principal();
		
		String sql = "SELECT TOP 1000 [CD_CEP] FROM [CRPRTO].[dbo].[CEP]";
		
		principal.consultaCep(sql);
		
		

	}

}
