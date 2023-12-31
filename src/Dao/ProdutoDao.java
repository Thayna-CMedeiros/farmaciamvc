package Dao;

import controller.ProdutoController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDao {
   ProdutoController prod = new ProdutoController();
   String url = "jdbc:mysql://localhost:3306/farmaciau";
   String usuario = "root";
   String senha = "";
   Connection conexao = null;
   PreparedStatement statement = null;
   ResultSet resultSet = null;
   
public void cadProduto(ProdutoController produto){ 
        
    String sql = "INSERT INTO PRODUTO (nome, valor, descricao) VALUES ("
    + " '" + prod.getNome() + "' , "
    + prod.getValor() + " , "	
    + " '" + prod.getDescricao() + "')";
              
    System.out.println(sql);
    ConexaoDao.executar(sql);
    
    }
    
     public static ProdutoController obterProdutoPorCodigo (int codigo){
     String query = "SELECT * FROM PRODUTO WHERE codigo = ?";
     ResultSet resultSet = null;
     ProdutoController prod = null;

     try (Connection conexao = ConexaoDao.conectar();
          PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
         preparedStatement.setInt(1, codigo);
         resultSet = preparedStatement.executeQuery();

         // VERIF SE HÁ RESULTADOS
         if (resultSet != null && resultSet.next()) {
             //PREENCHE OBJETO CODIGO COM OS DADOS DO BANCO DE DADOS
             prod = new ProdutoController();
             prod.setCodigo(resultSet.getInt("codigo"));
             prod.setNome(resultSet.getString("nome"));
             prod.setDescricao(resultSet.getString("descricao"));
             prod.setValor(resultSet.getDouble("valor"));
            
         }
     } catch (SQLException e) {
         e.printStackTrace(); 
     } finally {
         // FECHA O RESULTSET SE PRECISAR
         try {
             if (resultSet != null) resultSet.close();
         } catch (SQLException e) {
             e.printStackTrace(); //EXCESSAO SQL SE FECHAR
         }
     }

     return prod;
        }
    
}
