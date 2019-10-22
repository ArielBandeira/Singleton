//package br.com.Singleton;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class ConecSingleton {
//	private static Connection connection;
//	
//	private ConecSingleton() {}
//	
//	public static Connection getConnection() {
//		if (ConecSingleton.connection == null) {
//			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				ConecSingleton.connection = DriverManager.getConnection(
//						"jdbc:mysql://localhost:3306/bancosingleton?useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
//			} catch (Exception e) {
//				e.printStackTrace();
//				return null;
//			}
//		}
//		return ConecSingleton.connection;
//	}
//}
