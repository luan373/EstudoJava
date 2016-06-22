package com.acesso;

public class Principal {
	public static void main(String[] args) {
		try {
			boolean autenticado = AcessoLdap.authenticateJndi("jordan.silva", "@a123456");
			System.out.println(autenticado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}