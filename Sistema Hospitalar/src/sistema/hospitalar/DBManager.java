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
import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.objects.Global;

/**
 *
 * @author GabrielladaSilvadeSo
 */
public class DBManager {

    private ConectorDB conector = new ConectorDB();
//    private Connection connect() {
//        Connection conn = null;
//        try {
//            // db parameters
//            String url = "jdbc:sqlite:careplus.db";
//            // create a connection to the database
//            conn = DriverManager.getConnection(url);
//
//            System.out.println("Connection to SQLite has been established.");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return conn;
//    }

    public void cadastrarMedico(Medico medico) {
        String sqlFunc = "INSERT INTO Funcionario(cpf,nome,datanasc,salario) VALUES(?,?,?,?)";
        String sqlMed = "INSERT INTO Medico(CRM,areaatuacao,especialidade,funcionario_CPF) VALUES(?,?,?,?)";
        try (Connection conn = conector.connect();) {
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
    
    public void cadastrarPaciente(Paciente paciente) {
        //Dúvida: receita só acontece após consulta, mesmo assim eu deveria colocá-la aqui?
        String sqlPac = "INSERT INTO Paciente(cpf,nome,rg) VALUES(?,?,?)";
        try (Connection conn = conector.connect();) {
            PreparedStatement sqlStatement1 = conn.prepareStatement(sqlPac);
            sqlStatement1.setLong(1, paciente.getCPF());
            sqlStatement1.setString(2, paciente.getNome());
            sqlStatement1.setLong(3, paciente.getRG());
            sqlStatement1.executeUpdate();
            conn.commit();
            conn.close();
            System.out.println("Gravado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
     public void removerPaciente(int cpf) {
        try (Connection conn = conector.connect();) {
            String sqlDelete = "DELETE FROM paciente WHERE cpf = ?";
            PreparedStatement sqlStatement = conn.prepareStatement(sqlDelete);
            sqlStatement.setInt(1, cpf);
            sqlStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     
    

    {

    }

    public void cadastrarFuncionarioAdministrativo(FuncionarioAdministrativo funcadmin) {
        String sqlFunc = "INSERT INTO Funcionario(cpf,nome,datanasc,salario) VALUES(?,?,?,?)";
        String sqlFuncAdm = "INSERT INTO FuncionarioAdministrativo(cargo_ID,funcionario_CPF) VALUES(?,?)";
        try (Connection conn = conector.connect();) {
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
        try (Connection conn = conector.connect();) {
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
  
    // @TODO Fix  
    public Funcionario consultarFuncionario(long cpf){
        Funcionario func = null;
        try (Connection conn = conector.connect();){
            String sqlFunc = "select papel_id from Funcionario where cpf = ?";
            
            String papelFuncionario = "";
            PreparedStatement sqlStatement1 = conn.prepareStatement(sqlFunc);
            sqlStatement1.setLong(1, cpf);
            ResultSet rs = sqlStatement1.executeQuery();
            switch(rs.getInt("papel_id"))
            {
                    case 1: 
                        papelFuncionario =  "Enfermeiro";
                        func = new Enfermeiro();
                        break;

                    case 2: 
                        papelFuncionario = "Medico";
                        func = new Medico();
                        break;
                    case 3:
                        papelFuncionario = "FuncionarioAdmnistrativo";
                        func = new FuncionarioAdministrativo();
                        break;
            }
           
            String sqlJoin = "select * FROM Funcionario LEFT JOIN " + papelFuncionario + " on Funcionario.cpf = " + papelFuncionario + ".funcionario_cpf where cpf = ?";
            
            PreparedStatement sqlStatement2 = conn.prepareStatement(sqlJoin);
            sqlStatement2.setLong(1, cpf);
            ResultSet rs2 = sqlStatement2.executeQuery();
            func.setNome(rs2.getString("nome"));
            func.setCPF(rs2.getLong("cpf"));
            func.setDataNascimento(rs2.getDate("datanasc"));
            func.setSalario(rs2.getDouble("salario"));
            
            
            
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
         return func;
    }

    public void removerFuncionario(int cpf) {
        try (Connection conn = conector.connect();) {
            String sqlDelete = "DELETE FROM funcionario WHERE cpf = ?";
            PreparedStatement sqlStatement = conn.prepareStatement(sqlDelete);
            sqlStatement.setInt(1, cpf);
            sqlStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Receita criarReceita(String tipo, String textoReceita, Paciente paciente)
    {
        Receita receita= new Receita();
//        paciente.getReceitas().add(textoReceita);
        try (Connection conn = conector.connect();) {
            String sqlReceitas = "INSERT INTO receita(paciente_cpf,tipo,descricao) VALUES(?,?,?)";
            PreparedStatement sqlStatement = conn.prepareStatement(sqlReceitas);
            sqlStatement.setLong(1, paciente.getCPF());
            sqlStatement.setString(2, tipo);
            sqlStatement.setString(3, textoReceita);
            sqlStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return receita;
    }
    
    public void cadastrarEquipe(Equipe equipe)
    {
        
        String sqlEquipe = "INSERT INTO Equipe(nome,supervisor_cpf) VALUES(?,?)";
        String sqlFuncionariosEquipe = "INSERT INTO Equipe_Funcionario(equipe_id,funcionario_cpf) VALUES(?,?)";
       
        try (Connection conn = conector.connect();) {
            conn.setAutoCommit(false);
            PreparedStatement sqlStatement = conn.prepareStatement(sqlEquipe); 
            sqlStatement.setString(1,equipe.getNome());
            sqlStatement.setLong(2, equipe.getMedicoSupervisor().getCPF());
            PreparedStatement sqlStatementMembros = conn.prepareStatement(sqlFuncionariosEquipe);
            sqlStatement.execute();
            
            for (Medico medico : equipe.getMedicos())
            {
                sqlStatementMembros.setInt(1,equipe.getID());
                sqlStatementMembros.setLong(2, medico.getCPF());
                sqlStatementMembros.addBatch();
            }
            for (Enfermeiro enfermeiro : equipe.getEnfermeiros())
            {
                sqlStatementMembros.setInt(1,equipe.getID());
                sqlStatementMembros.setLong(2, enfermeiro.getCPF());
                sqlStatementMembros.addBatch();
            }
            conn.commit();
            conn.close();
            System.out.println("Gravado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }        
    }
   
    public List<Funcionario> getFuncionarios(Long cpf){        
        Funcionario func = new Funcionario() {};
        ResultSet rs = null;
        List<Funcionario> list_func = new ArrayList<>();
        try (Connection conn = conector.connect();){
            if (cpf != null) {
                String sqlFunc = "select * from Funcionario where cpf = ?";
                PreparedStatement sqlStatement1 = conn.prepareStatement(sqlFunc);
                sqlStatement1.setString(1, cpf.toString());
                rs = sqlStatement1.executeQuery();
            }else{
                String sqlFunc = "select * from Funcionario";
                PreparedStatement sqlStatement1 = conn.prepareStatement(sqlFunc);
                rs = sqlStatement1.executeQuery();
            }
            while (rs.next()) {                
                Long func_cpf = Long.parseLong(rs.getString("cpf"));
                func.setCPF(func_cpf);
                func.setDataNascimento(rs.getDate("datanasc"));
                func.setSenha(rs.getString("senha"));
                list_func.add(func);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_func;
    }
    
    public List<Equipe> getEquipe(Equipe eq){
        List<Equipe> list_eq = new ArrayList<>();
        Equipe eq1 = new Equipe();
        ResultSet rs = null;
        PreparedStatement sqlStatement1 = null;
        try (Connection conn = conector.connect();){
            if (eq != null) {
                if(eq.getID() != 0){
                    String sql = "select * from Equipe where id = ?";
                    sqlStatement1 = conn.prepareStatement(sql);
                    sqlStatement1.setInt(1, eq.getID());
                    rs = sqlStatement1.executeQuery();
                }
                if(eq.getNome() != null){
                    String sql = "select * from Equipe where nome = ?";
                    sqlStatement1 = conn.prepareStatement(sql);
                    sqlStatement1.setString(1, eq.getNome());
                    rs = sqlStatement1.executeQuery();
                }
                if(eq.getSupervisor_cpf() != null){
                    String sql = "select * from Equipe where supervisor_cpf = ?";
                    sqlStatement1 = conn.prepareStatement(sql);
                    sqlStatement1.setInt(1, eq.getSupervisor_cpf());
                    rs = sqlStatement1.executeQuery();
                }
            }else{
                String sql = "select * from Equipe";
                sqlStatement1 = conn.prepareStatement(sql);
                rs = sqlStatement1.executeQuery();
            }
            while(rs.next()){
                eq1.setID(rs.getInt("id"));
                eq1.setNome(rs.getString("nome"));
                eq1.setSupervisor_cpf(rs.getInt("supervisor_cpf"));
                list_eq.add(eq1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_eq;
    }
    
    public List<Procedimento> getProcedimento(Procedimento proc){
        List<Procedimento> list_proc = new ArrayList<>();
        Procedimento proc1 = new Procedimento() {};
        ResultSet rs = null;
        PreparedStatement sqlStatement1 = null;
        try (Connection conn = conector.connect();){
            if(proc != null){
                if(proc.getId() != 0){
                    String sql = "select * from Procedimento where id = ?";
                    sqlStatement1 = conn.prepareStatement(sql);
                    sqlStatement1.setInt(1, proc.getId());
                    rs = sqlStatement1.executeQuery();
                }
                if(proc.getNome() != null){
                    String sql = "select * from Procedimento where nome = ?";
                    sqlStatement1 = conn.prepareStatement(sql);
                    sqlStatement1.setString(1, proc.getNome());
                    rs = sqlStatement1.executeQuery();
                }
            }else{
                String sql = "select * from Procedimento";
                sqlStatement1 = conn.prepareStatement(sql);
                rs = sqlStatement1.executeQuery();
            }
            while(rs.next()){
                proc1.setId(rs.getInt("id"));
                proc1.setNome(rs.getString("nome"));
                proc1.setValor(rs.getDouble("valor"));
                list_proc.add(proc1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_proc;
    }
    
    public List<Sala> getSala(Sala sl){
        List<Sala> list_sl = new ArrayList<>();
        Sala sl1 = new Sala(){};
        ResultSet rs = null;
        PreparedStatement sqlStatement1 = null;
        try (Connection conn = conector.connect();){
            if(sl != null){
                if(sl.getQuartos() != null){
                    String sql = "select * from Sala where id = ?";
                    sqlStatement1 = conn.prepareStatement(sql);
                    sqlStatement1.setInt(1, sl.getQuartos());
                    rs = sqlStatement1.executeQuery();
                }
                if(sl.getSubsetor_id() != null){
                    String sql = "select * from Sala where subsetor_id = ?";
                    sqlStatement1 = conn.prepareStatement(sql);
                    sqlStatement1.setInt(1, sl.getSubsetor_id());
                    rs = sqlStatement1.executeQuery();
                }
            }else{
                String sql = "select * from Sala";
                sqlStatement1 = conn.prepareStatement(sql);
                rs = sqlStatement1.executeQuery();
            }
            while(rs.next()){
                sl1.setQuartos(rs.getInt("id"));
                sl1.setSubsetor_id(rs.getInt("subsetor_id"));
                list_sl.add(sl1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_sl;
    }
    
    public List<Paciente> getPaciente(Paciente pac){
        List<Paciente> list_pac = new ArrayList<>();
        Paciente pac1 = new Paciente();
        ResultSet rs = null;
        PreparedStatement sqlStatement1 = null;
        try (Connection conn = conector.connect();){
            if(pac.getCPF() != null){
                String sql = "select * from Paciente where cpf = ?";
                sqlStatement1 = conn.prepareStatement(sql);
                sqlStatement1.setInt(1,pac.getCPF().intValue());
                rs = sqlStatement1.executeQuery();
            }
            if(pac.getNome() != null){
                String sql = "select * from Paciente where nome = ?";
                sqlStatement1 = conn.prepareStatement(sql);
                sqlStatement1.setString(1,pac.getNome());
                rs = sqlStatement1.executeQuery();
            }
            if(pac.getRG() != null){
                String sql = "select * from Paciente where RG = ?";
                sqlStatement1 = conn.prepareStatement(sql);
                sqlStatement1.setInt(1,pac.getRG().intValue());
                rs = sqlStatement1.executeQuery();
            }
            while(rs.next()){
                pac1.setCPF(rs.getLong("cpf"));
                pac1.setNome(rs.getString("nome"));
                pac1.setRG(rs.getLong("RG"));
                list_pac.add(pac1);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_pac;
    }
    
    /*public List<Agendamento> consultarAgendamento(Date data){
        List<Agendamento> list_ag = new ArrayList<>();
        Agendamento ag = new Agendamento();
        ResultSet rs = null;
        PreparedStatement sqlStatementl = null;
        try (Connection conn = conector.connect();){
            String sql = "select * from Agendamento where data = ?";
            sqlStatementl = conn.prepareStatement(sql);
            sqlStatementl.setDate(1, data);
            rs = sqlStatementl.executeQuery();
            while (rs.next()) {
                List<Equipe> lt_eq = new ArrayList<>();
                Equipe eq = new Equipe();
                eq.setId(rs.getInt("equipe_id"));
                lt_eq = this.getEquipe(eq);
                List<Paciente> lt_pac = new ArrayList<>();
                Paciente pac = new Paciente();
                pac.setCPF(rs.getLong("paciente_id"));
                lt_pac = this.getPaciente(pac);
                List<Procedimento> lt_proc = new ArrayList<>();
                Procedimento proc = new Procedimento() {};
                proc.setId(rs.getInt("equipe_id"));
                lt_proc = this.getProcedimento(proc);
                for (Equipe equip : lt_eq) {
                    ag.setEquipe_id(rs.getInt("equipe_id"));
                    ag.setEquipe_nome(equip.getNome());
                }
                for (Paciente paciente: lt_pac) {
                    ag.setPaciente_id(rs.getLong("paciente_id"));
                    ag.setPaciente_nome(paciente.getNome());
                }
                for (Procedimento procedimento : lt_proc) {
                    ag.setProcedimento_id(rs.getInt("procedimento_id"));
                    ag.setProcedimento_nome(procedimento.getNome());
                }
                ag.setData(data);
                ag.setHora(rs.getTime("hora"));
                ag.setId(rs.getInt("id"));
                ag.setSala_id(rs.getInt("sala_id"));
                list_ag.add(ag);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }        
        return list_ag;
    }*/
    
}
