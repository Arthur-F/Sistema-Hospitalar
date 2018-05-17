/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

/**
 *
 * @author GabrielladaSilvadeSo
 */
public class DBManager {
    private Connection connect()
    {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:careplus.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
    }catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return conn;
    }
    
    public void cadastrarMedico(Medico medico)
    {
        String sqlFunc = "INSERT INTO Funcionario(cpf,nome,datanasc,salario) VALUES(?,?,?,?)";
        String sqlMed = "INSERT INTO Medico(CRM,areaatuacao,especialidade,funcionario_CPF) VALUES(?,?,?,?)";
       try (Connection conn = this.connect();
               
               )
                         
       {    PreparedStatement sqlStatement1 = conn.prepareStatement(sqlFunc);
            PreparedStatement sqlStatement2 = conn.prepareStatement(sqlMed);
            sqlStatement1.setString(1, medico.getCPF());
            sqlStatement1.setString(2,medico.getNome());
            sqlStatement1.setDate(3, medico.getDataNascimento());
            sqlStatement1.setDouble(4, medico.getSalario());
            sqlStatement2.setString(1, medico.getCRM());
            sqlStatement2.setString(2, medico.getAreaDeAtuacao());
            sqlStatement2.setString(3, medico.getEspecialidade());
            sqlStatement2.setString(4, medico.getCPF());
            
            sqlStatement1.executeUpdate();
            sqlStatement2.executeUpdate();
            conn.commit();
            conn.close();
            System.out.println("Gravado");
       }catch (SQLException e)
       {
           System.out.println(e.getMessage());
       }
        
       
        
    }
    {
        
    }
}
