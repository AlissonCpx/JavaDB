/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import Connection.ConnectionFactory;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Categoria;

/**
 *  CRUD
 * @author Alisson
 */
public class CategoriaDAO {
    
    private Connection con = null;

    public CategoriaDAO() {
    con = ConnectionFactory.getConnection();
    
    }
    
    public boolean save(Categoria categoria){
        String sql = "INSERT INTO categoria (descricao) VALUES (?)";
        
        PreparedStatement stmt = null;
        
        
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, categoria.getDescricao());
            
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: 200" + ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
}
