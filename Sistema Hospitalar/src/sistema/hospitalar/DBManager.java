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
import java.sql.ResultSet;

/**
 *
 * @author GabrielladaSilvadeSo
 */
public class DBManager {

    private Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:careplus.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void cadastrarMedico(Medico medico) {
        String sqlFunc = "INSERT INTO Funcionario(cpf,nome,datanasc,salario) VALUES(?,?,?,?)";
        String sqlMed = "INSERT INTO Medico(CRM,areaatuacao,especialidade,funcionario_CPF) VALUES(?,?,?,?)";
        try (Connection conn = this.connect();) {
            PreparedStatement sqlStatement1 = conn.prepareStatement(sqlFunc);
            PreparedStatement sqlStatement2 = conn.prepareStatement(sqlMed);
            sqlStatement1.setLong(1, medico.getCPF());
            sqlStatement1.setString(2, medico.getNome());
            sqlStatement1.setDate(3, medico.getDataNascimento());
            sqlStatement1.setDouble(4, medico.getSalario());
            sqlStatement2.setString(1, medico.getCRM());
            sqlStatement2.setString(2, medico.getAreaDeAtuacao());
            sqlStatement2.setString(3, medico.getEspecialidade());
            sqlStatement2.setLong(4, medico.getCPF());

            sqlStatement1.executeUpdate();
            sqlStatement2.executeUpdate();
            conn.commit();
            conn.close();
            System.out.println("Gravado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    {

    }

    public void cadastrarFuncionarioAdministrativo(FuncionarioAdministrativo funcadmin) {
        String sqlFunc = "INSERT INTO Funcionario(cpf,nome,datanasc,salario) VALUES(?,?,?,?)";
        String sqlFuncAdm = "INSERT INTO FuncionarioAdministrativo(cargo_ID,funcionario_CPF) VALUES(?,?)";
        try (Connection conn = this.connect();) {
            PreparedStatement sqlStatement1 = conn.prepareStatement(sqlFunc);
            PreparedStatement sqlStatement2 = conn.prepareStatement(sqlFuncAdm);
            sqlStatement1.setLong(1, funcadmin.getCPF());
            sqlStatement1.setString(2, funcadmin.getNome());
            sqlStatement1.setDate(3, funcadmin.getDataNascimento());
            sqlStatement1.setDouble(4, funcadmin.getSalario());
            sqlStatement2.setString(1, funcadmin.getCargo());
            sqlStatement2.setLong(2, funcadmin.getCPF());

            sqlStatement1.executeUpdate();
            sqlStatement2.executeUpdate();
            conn.commit();
            conn.close();
            System.out.println("Gravado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
     public void cadastrarEnfermeiro(Enfermeiro enfermeiro) {
        String sqlFunc = "INSERT INTO Funcionario(cpf,nome,datanasc,salario) VALUES(?,?,?,?)";
        String sqlEnf = "INSERT INTO Enfermeiro(tipo,funcionario_CPF) VALUES(?,?)";
        try (Connection conn = this.connect();) {
            PreparedStatement sqlStatement1 = conn.prepareStatement(sqlFunc);
            PreparedStatement sqlStatement2 = conn.prepareStatement(sqlEnf);
            sqlStatement1.setLong(1, enfermeiro.getCPF());
            sqlStatement1.setString(2, enfermeiro.getNome());
            sqlStatement1.setDate(3, enfermeiro.getDataNascimento());
            sqlStatement1.setDouble(4, enfermeiro.getSalario());
            sqlStatement2.setString(1, enfermeiro.getTipo());
            sqlStatement2.setLong(2, enfermeiro.getCPF());

            sqlStatement1.executeUpdate();
            sqlStatement2.executeUpdate();
            conn.commit();
            conn.close();
            System.out.println("Gravado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public void consultarFuncionario(long cpf){
        
        try (Connection conn = this.connect();){
            String sqlFunc = "select papel_id from Funcionario where cpf = ?";
            
            String papelFuncionario = "";
            PreparedStatement sqlStatement1 = conn.prepareStatement(sqlFunc);
            sqlStatement1.setLong(1, cpf);
            ResultSet rs = sqlStatement1.executeQuery();
            switch(rs.getInt("papel_id"))
            {
                    case 1: 
                        papelFuncionario =  "Enfermeiro";
                        break;

                    case 2: 
                        papelFuncionario = "Medico";
                        break;
                    case 3:
                        papelFuncionario = "FuncionarioAdmnistrativo";
                        break;
            }
           
            String sqlJoin = "select * FROM Funcionario LEFT JOIN " + papelFuncionario + " on Funcionario.cpf = " + papelFuncionario + ".funcionario_cpf where cpf = ?";
            
            PreparedStatement sqlStatement2 = conn.prepareStatement(sqlJoin);
            //sqlStatement2.setLong(1, cpf);
            ResultSet rs2 = sqlStatement2.executeQuery();
            
          
//            while (rs.next())
            {
//                rs.getInt(cpf);
//                rs
//                System.out.println(rs.get);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removerFuncionario(int cpf) {
        try (Connection conn = this.connect();) {
            String sqlDelete = "DELETE FROM funcionario WHERE cpf = ?";
            PreparedStatement sqlStatement = conn.prepareStatement(sqlDelete);
            sqlStatement.setInt(1, cpf);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
