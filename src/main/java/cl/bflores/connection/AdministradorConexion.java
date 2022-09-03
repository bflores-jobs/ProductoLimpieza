package cl.bflores.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AdministradorConexion {
	
	protected static Connection conn = null;
	protected PreparedStatement pstm = null;
	protected ResultSet rs = null;
	
	//conexion mediante JDBC
	protected Connection generaConexion() {
		
		String usr = "EDUTECNO";
		String pwd = "admin";
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		
		if(conn == null) {
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, usr, pwd);
				System.out.println("Conexión generada con generaConexion()");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}		
		return conn;
	}
	
	//conexion mediante Pool de Conexion singleton
	protected Connection generaPoolConexion() {
		Context initContext;
		
		if(conn == null) {
			try {
				initContext = new InitialContext();
				DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/ConexionOracle");
				conn = ds.getConnection();
				System.out.println("Conexión establecida con generaPoolConexion()");
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
			}
		}		
		return conn;
	}

}
