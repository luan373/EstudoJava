package com.microsoft.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public abstract class SQLServerConexao {
	protected Connection conexao = null;
	protected PreparedStatement comandoSql = null;
	protected ResultSet resultadoSql = null;
	
	protected void configuraConexao() {
		try {
			Driver d = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			String connectionUrl = "jdbc:sqlserver://10.5.1.224;database=CRPRTO;user=usr_estudo;password=123456";
			this.conexao = d.connect(connectionUrl, new Properties());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
