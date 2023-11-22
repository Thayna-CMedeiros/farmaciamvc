package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexao {
	private static final String URL = "jdbc:mysql://localhost:3306/farmaciau";
	private static final String USER = "root";
        private static final String DRIVER = "com.mysql.jdbc.Driver";
        private static final String SENHA = "";
              
		public static void executar(String query) {
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL,USER,SENHA);
			Statement st = conn.createStatement();
			st.execute(query);
			conn.close();
		} catch(Exception e ) {
			JOptionPane.showMessageDialog(null, e.toString());
			
		}

	}
		
		public static ResultSet consultar(String query) {
			try {Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL,USER,SENHA);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			//conn.close();
			return rs;
		} catch(Exception e ) {
			JOptionPane.showMessageDialog(null, e.toString());
			return null;
		}
				
			}

    public static void closeConnection(Connection conexao, PreparedStatement pstm, ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

   public static Connection conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/farmaciau";
        String usuario = "root";
        String senha = "";
        return DriverManager.getConnection(url, usuario, senha);
    }
   
    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
			
		}
    

