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

    DBManager() {
//     
    }
    
 
    public List<Funcionario> getFuncionarios(Long cpf){                
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
                Funcionario func = new Funcionario() {};
                Long func_cpf = Long.parseLong(rs.getString("cpf"));
                func.setCPF(func_cpf);
                func.setNome(rs.getString("nome"));
                func.setDataNascimento(rs.getString("datanasc"));
                func.setSenha(rs.getString("senha"));
                func.setSalario(rs.getDouble("salario"));
                func.setSetor_id(rs.getInt("setor_id"));
                func.setPapel_id(rs.getInt("papel_id"));
                list_func.add(func);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_func;
    }
    
    public List<Equipe> getEquipe(Equipe eq){
        List<Equipe> list_eq = new ArrayList<>();        
        ResultSet rs = null;
        PreparedStatement sqlStatement1 = null;
        try (Connection conn = conector.connect();){
            if (eq != null) {
                if(eq.getID() != null){
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
                    String sql = "select * from Equipe where supervisor_crm = ?";
                    sqlStatement1 = conn.prepareStatement(sql);
                    sqlStatement1.setString(1,eq.getSupervisor_cpf());
                    rs = sqlStatement1.executeQuery();
                }
            }else{
                String sql = "select * from Equipe";
                sqlStatement1 = conn.prepareStatement(sql);
                rs = sqlStatement1.executeQuery();
            }
            while(rs.next()){
                Equipe eq1 = new Equipe();
                eq1.setID(rs.getInt("id"));
                eq1.setNome(rs.getString("nome"));
                eq1.setSupervisor_cpf(rs.getString("supervisor_crm"));
                list_eq.add(eq1);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_eq;
    }
    
    public List<Equipe> cadastrarEquipe(Equipe eq){
        List<Equipe> list_eq = new ArrayList<>();
        PreparedStatement sqlStatement1 = null;
        try (Connection conn = conector.connect();){
            String sql = "insert into Equipe (nome,supervisor_crm) values (?,?)";
            sqlStatement1 = conn.prepareStatement(sql);
            sqlStatement1.setString(1,eq.getNome());
            sqlStatement1.setString(2,eq.getSupervisor_cpf());
            sqlStatement1.execute();
            conn.close();
            list_eq = this.getEquipe(null);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_eq;
    }
    
    public List<Equipe> editarEquipe(Equipe eq){
        List<Equipe> list = new ArrayList<>();
        try (Connection conn = conector.connect();){
            String sql = "update Equipe set nome = ?, supervisor_crm = ? where id = ?";
            PreparedStatement sqlStatement1 = conn.prepareStatement(sql);
            sqlStatement1.setString(1,eq.getNome());
            sqlStatement1.setString(2,eq.getSupervisor_cpf());
            sqlStatement1.setInt(3,eq.getID());
            sqlStatement1.executeUpdate();
            conn.close();
            list = this.getEquipe(null);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public List<Equipe> deletarEquipe(Equipe eq){
        List<Equipe> list_eq = new ArrayList<>();
        PreparedStatement sqlStatement1 = null;
        try (Connection conn = conector.connect();){
            String sql = "delete from Equipe where id = ?";
            sqlStatement1 = conn.prepareStatement(sql);
            sqlStatement1.setInt(1,eq.getID());
            sqlStatement1.execute();
            sql = "delete from Equipe_Funcionario where equipe_id = ?";
            sqlStatement1 = conn.prepareStatement(sql);
            sqlStatement1.setInt(1,eq.getID());
            sqlStatement1.execute();
            conn.close();
            list_eq = this.getEquipe(null);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_eq;
    }
    
    public List<Procedimento> getProcedimento(Procedimento proc){
        List<Procedimento> list_proc = new ArrayList<>();        
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
                Procedimento proc1 = new Procedimento() {};
                proc1.setId(rs.getInt("id"));
                proc1.setNome(rs.getString("nome"));
                proc1.setValor(rs.getDouble("valor"));
                list_proc.add(proc1);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_proc;
    }
    
    public List<Sala> getSala(Sala sl){
        List<Sala> list_sl = new ArrayList<>();
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
                Sala sl1 = new Sala(){};
                sl1.setQuartos(rs.getInt("id"));
                sl1.setSubsetor_id(rs.getInt("subsetor_id"));
                list_sl.add(sl1);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_sl;
    }
    
    public List<Paciente> getPaciente(Paciente pac){
        List<Paciente> list_pac = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement sqlStatement1 = null;
        try (Connection conn = conector.connect();){
            if(pac.getCPF() != null){
                String sql = "select * from Paciente where cpf = ?";
                sqlStatement1 = conn.prepareStatement(sql);
                sqlStatement1.setLong(1,pac.getCPF());
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
                sqlStatement1.setString(1,pac.getRG());
                rs = sqlStatement1.executeQuery();
            }
            while(rs.next()){
                Paciente pac1 = new Paciente();
                pac1.setCPF(rs.getLong("cpf"));
                pac1.setNome(rs.getString("nome"));
                pac1.setRG(rs.getString("RG"));
                list_pac.add(pac1);
            }
            conn.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_pac;
    }
    
    public List<Empresa> getEmpresa(Empresa emp){
        List<Empresa> list_emp = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement sqlStatement1 = null;
        try (Connection conn = conector.connect();){
            if(emp != null && emp.getCnpj() != null && emp.getNome() == null){
                String sql = "select * from Empresa where cnpj = ?";
                sqlStatement1 = conn.prepareStatement(sql);
                sqlStatement1.setString(1,emp.getCnpj());
                rs = sqlStatement1.executeQuery();
            }else if(emp != null && emp.getNome() != null && emp.getCnpj() == null){
                String sql = "select * from Empresa where nome like ?";
                sqlStatement1 = conn.prepareStatement(sql);
                String str = "%" + emp.getNome() + "%";
                sqlStatement1.setString(1,str);
                rs = sqlStatement1.executeQuery();
            }else if(emp != null && emp.getCnpj() != null && emp.getNome() != null){
                String sql = "select * from Empresa where cnpj = ? or nome like ?";
                sqlStatement1 = conn.prepareStatement(sql);
                sqlStatement1.setString(1,emp.getCnpj());
                String str = "%" + emp.getNome() + "%";
                sqlStatement1.setString(2,str);
                rs = sqlStatement1.executeQuery();
            }else{
                String sql = "select * from Empresa";
                sqlStatement1 = conn.prepareStatement(sql);
                rs = sqlStatement1.executeQuery();
            }
            while(rs.next()){
                Empresa emp1 = new Empresa();
                emp1.setCnpj(rs.getString("cnpj"));
                emp1.setNome(rs.getString("nome"));
                list_emp.add(emp1);
            }
            conn.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_emp;
    }
    
    public List<Empresa> cadastrarEmpresa(Empresa emp){
        List<Empresa> list_emp = new ArrayList<>();
        PreparedStatement sqlStatement1 = null;
        try (Connection conn = conector.connect();){
            String sql = "insert into Empresa (cnpj,nome) values (?,?)";
            sqlStatement1 = conn.prepareStatement(sql);
            sqlStatement1.setString(1,emp.getCnpj().toString());
            sqlStatement1.setString(2,emp.getNome());
            sqlStatement1.execute();
            conn.close();
            list_emp = this.getEmpresa(null);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_emp;
    }
    
    public List<Empresa> editarEmpresa(Empresa emp){
        List<Empresa> list = new ArrayList<>();
        try (Connection conn = conector.connect();){
            String sql = "update Empresa set nome = ? where cnpj = ?";
            PreparedStatement sqlStatement1 = conn.prepareStatement(sql);
            sqlStatement1.setString(1,emp.getNome());
            sqlStatement1.setString(2,emp.getCnpj());
            sqlStatement1.executeUpdate();
            conn.close();
            list = this.getEmpresa(null);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public List<Empresa> deletarEmpresa(Empresa emp){
        List<Empresa> list_emp = new ArrayList<>();
        PreparedStatement sqlStatement1 = null;
        try (Connection conn = conector.connect();){
            String sql = "delete from Empresa where cnpj = ?";
            sqlStatement1 = conn.prepareStatement(sql);
            sqlStatement1.setString(1,emp.getCnpj().toString());
            sqlStatement1.execute();
            conn.close();
            list_emp = this.getEmpresa(null);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_emp;
    }
    
    public List<Agendamento> consultarAgendamento(String data){
        List<Agendamento> list_ag = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement sqlStatementl = null;
        try (Connection conn = conector.connect();){
            String sql = "select * from Agendamento where data = ?";
            sqlStatementl = conn.prepareStatement(sql);
            sqlStatementl.setString(1, data);
            rs = sqlStatementl.executeQuery();
            while (rs.next()) {
                Agendamento ag = new Agendamento();
                List<Equipe> lt_eq = new ArrayList<>();
                Equipe eq = new Equipe();
                eq.setID(rs.getInt("equipe_id"));
                lt_eq = this.getEquipe(eq);
                List<Paciente> lt_pac = new ArrayList<>();
                Paciente pac = new Paciente();
                pac.setCPF(rs.getLong("paciente_cpf"));
                lt_pac = this.getPaciente(pac);
                List<Procedimento> lt_proc = new ArrayList<>();
                Procedimento proc = new Procedimento() {};
                proc.setId(rs.getInt("procedimento_id"));
                lt_proc = this.getProcedimento(proc);
                for (Equipe equip : lt_eq) {
                    ag.setEquipe_id(rs.getInt("equipe_id"));
                    ag.setEq_nome(equip.getNome());
                    ag.setSupervisor_crm(equip.getSupervisor_cpf());
                }
                for (Paciente paciente: lt_pac) {
                    ag.setPaciente_id(rs.getLong("paciente_cpf"));
                    ag.setPac_nome(paciente.getNome());
                }
                for (Procedimento procedimento : lt_proc) {
                    ag.setProcedimento_id(rs.getInt("procedimento_id"));
                    ag.setProc_nome(procedimento.getNome());
                }
                ag.setData(data);
                ag.setHora(rs.getString("hora"));
                ag.setId(rs.getInt("id"));
                ag.setSala_id(rs.getInt("sala_id"));
                list_ag.add(ag);
            }
            conn.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }        
        return list_ag;
    }
    
    public List<Agendamento> cancelarAgendamento(Agendamento ag){
        List<Agendamento> list_ag = new ArrayList<>();
        PreparedStatement sqlStatement1 = null;
        try (Connection conn = conector.connect();){
            String sql = "delete from Agendamento where data = ? and hora = ? and paciente_cpf = ?";
            sqlStatement1 = conn.prepareStatement(sql);
            sqlStatement1.setString(1,ag.getData());
            sqlStatement1.setString(2,ag.getHora());
            sqlStatement1.setLong(3,ag.getPaciente_id());
            sqlStatement1.execute();
            conn.close();
            list_ag = this.consultarAgendamento(ag.getData());
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_ag;
    }
    
    public void agendar(Agendamento ag){
        try (Connection conn = conector.connect();){
            String sql = "insert into Agendamento (data,hora,sala_id,paciente_cpf,equipe_id,procedimento_id) values (?,?,?,?,?,?)";
            PreparedStatement sqlStatement1 = conn.prepareStatement(sql);
            sqlStatement1.setString(1,ag.getData());
            sqlStatement1.setString(2,ag.getHora());
            sqlStatement1.setInt(3,ag.getSala_id());
            sqlStatement1.setLong(4,ag.getPaciente_id());
            sqlStatement1.setInt(5,ag.getEquipe_id());
            sqlStatement1.setInt(6,ag.getProcedimento_id());
            sqlStatement1.execute();
            conn.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void alteraFuncionario(Funcionario func){
        try (Connection conn = conector.connect();){
            String sql = "update Funcionario set nome = ?, datanasc = ?, salario = ?, setor_id = ?, papel_id = ?, senha = ? where cpf = ?";
            PreparedStatement sqlStatement1 = conn.prepareStatement(sql);
            sqlStatement1.setString(1,func.getNome());
            sqlStatement1.setString(2,func.getDataNascimento());
            sqlStatement1.setDouble(3,func.getSalario());
            sqlStatement1.setInt(4,func.getSetor_id());
            sqlStatement1.setInt(5,func.getPapel_id());
            sqlStatement1.setString(6,func.getSenha());
            sqlStatement1.setLong(7,func.getCPF());
            sqlStatement1.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<Medico> getMedico(Medico med){
        List<Medico> list_med = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement sqlStatement1 = null;
        try (Connection conn = conector.connect();){
            if(med != null && med.getCRM() != null){
                String sql = "select * from Medico where CRM = ?";
                sqlStatement1 = conn.prepareStatement(sql);
                sqlStatement1.setString(1,med.getCRM());
                rs = sqlStatement1.executeQuery();
            }else if(med != null && med.getCPF() != null){
                String sql = "select * from Medico where funcionario_cpf = ?";
                sqlStatement1 = conn.prepareStatement(sql);
                sqlStatement1.setLong(1,med.getCPF());
                rs = sqlStatement1.executeQuery();
            }else{
                String sql = "select * from Medico";
                sqlStatement1 = conn.prepareStatement(sql);                
                rs = sqlStatement1.executeQuery();
            }
            while(rs.next()){
                Medico medico = new Medico();
                medico.setCRM(rs.getString("CRM"));
                medico.setCPF(rs.getLong("funcionario_cpf"));
                medico.setAreaDeAtuacao(rs.getString("areaatuacao"));
                medico.setEspecialidade(rs.getString("especialidade"));
                list_med.add(medico);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_med;
    }


//    private ConectorDB conector = new ConectorDB();
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
            sqlStatement1.setString(3, medico.getDataNascimento());
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
            sqlStatement1.setString(3, paciente.getRG());
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
            sqlStatement1.setString(3, funcadmin.getDataNascimento());
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
            sqlStatement1.setString(3, enfermeiro.getDataNascimento());
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
    public Funcionario consultarFuncionario(long cpf) {
        Funcionario func = null;
        try (Connection conn = conector.connect();) {
            String sqlFunc = "select papel_id from Funcionario where cpf = ?";

            String papelFuncionario = "";
            PreparedStatement sqlStatement1 = conn.prepareStatement(sqlFunc);
            sqlStatement1.setLong(1, cpf);
            ResultSet rs = sqlStatement1.executeQuery();
            switch (rs.getInt("papel_id")) {
                case 1:
                    papelFuncionario = "Enfermeiro";
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
            func.setDataNascimento(rs2.getString("datanasc"));
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

    public Receita criarReceita(String tipo, String textoReceita, Paciente paciente) {
        Receita receita = new Receita();
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

//    public void cadastrarEquipe(Equipe equipe) {
//
//        String sqlEquipe = "INSERT INTO Equipe(nome,supervisor_cpf) VALUES(?,?)";
//        String sqlFuncionariosEquipe = "INSERT INTO Equipe_Funcionario(equipe_id,funcionario_cpf) VALUES(?,?)";
//
//        try (Connection conn = conector.connect();) {
//            conn.setAutoCommit(false);
//            PreparedStatement sqlStatement = conn.prepareStatement(sqlEquipe);
//            sqlStatement.setString(1, equipe.getNome());
//            sqlStatement.setLong(2, equipe.getMedicoSupervisor().getCPF());
//            PreparedStatement sqlStatementMembros = conn.prepareStatement(sqlFuncionariosEquipe);
//            sqlStatement.execute();
//
//            for (Medico medico : equipe.getMedicos()) {
//                sqlStatementMembros.setInt(1, equipe.getID());
//                sqlStatementMembros.setLong(2, medico.getCPF());
//                sqlStatementMembros.addBatch();
//            }
//            for (Enfermeiro enfermeiro : equipe.getEnfermeiros()) {
//                sqlStatementMembros.setInt(1, equipe.getID());
//                sqlStatementMembros.setLong(2, enfermeiro.getCPF());
//                sqlStatementMembros.addBatch();
//            }
//            conn.commit();
//            conn.close();
//            System.out.println("Gravado");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//
//        }
//
//    }
    
    public List<MembrosEquipe> consultarMembrosEquipe(Integer id){
        List<MembrosEquipe> list_eq_func = new ArrayList<>();
        try (Connection conn = conector.connect()){
            String sql = "select * from Equipe_Funcionario where equipe_id = ?";
            PreparedStatement sqlStatement1 = conn.prepareStatement(sql);
            sqlStatement1.setInt(1,id);
            ResultSet rs = sqlStatement1.executeQuery();
            while(rs.next()){
                MembrosEquipe eq_func = new MembrosEquipe();
                eq_func.setId(rs.getInt("id"));
                eq_func.setEquipe_id(rs.getInt("equipe_id"));
                eq_func.setFunc_cpf(rs.getLong("funcionario_cpf"));
                list_eq_func.add(eq_func);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_eq_func;
    }
    
    public List<MembrosEquipe> cadastrarMembrosEquipe(MembrosEquipe eq_func){
        List<MembrosEquipe> list_eq_func = new ArrayList<>();
        try (Connection conn = conector.connect()){
            String sql = "insert into Equipe_Funcionario (equipe_id,funcionario_cpf) values (?,?)";
            PreparedStatement sqlStatement1 = conn.prepareStatement(sql);
            sqlStatement1.setInt(1,eq_func.getEquipe_id());
            sqlStatement1.setLong(2,eq_func.getFunc_cpf());
            sqlStatement1.execute();
            conn.close();
            list_eq_func = this.consultarMembrosEquipe(eq_func.getEquipe_id());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_eq_func;
    }
    
    public List<Enfermeiro> getEnfermeiros(Enfermeiro enf){
        List<Enfermeiro> list_enf = new ArrayList<>();
        PreparedStatement sqlStatement1 = null;
        ResultSet rs = null;
        try (Connection conn = conector.connect()){
            if(enf != null && enf.getCPF() != null){
                String sql = "select * from Enfermeiro where funcionario_cpf = ?";
                sqlStatement1 = conn.prepareStatement(sql);
                sqlStatement1.setLong(1,enf.getCPF());
                rs = sqlStatement1.executeQuery();
            }else{
                String sql = "select * from Enfermeiro";
                sqlStatement1 = conn.prepareStatement(sql);
                rs = sqlStatement1.executeQuery();
            }
            while(rs.next()){
                Enfermeiro enfe = new Enfermeiro();
                enfe.setCPF(rs.getLong("funcionario_cpf"));
                List<Funcionario> list_func = new ArrayList<>();
                list_func = this.getFuncionarios(enfe.getCPF());
                for (Funcionario funcionario : list_func) {
                    enfe.setNome(funcionario.getNome());
                    enfe.setDataNascimento(funcionario.getDataNascimento());
                    enfe.setPapel_id(funcionario.getPapel_id());
                    enfe.setSalario(funcionario.getSalario());
                    enfe.setSetor_id(funcionario.getSetor_id());
                }
                if(enf != null && enf.getNome() != null){                    
                    if(enfe.getNome().equalsIgnoreCase(enf.getNome())){
                        list_enf.add(enfe);
                    }
                }else{
                    list_enf.add(enfe);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_enf;
    }
    
    public List<MembrosEquipe> deletarMembrosEquipe(MembrosEquipe eq_func){
        List<MembrosEquipe> list_eq_func = new ArrayList<>();
        PreparedStatement sqlStatement1 = null;
        try (Connection conn = conector.connect()){            
            String sql = "delete from Equipe_Funcionario where id = ?";
            sqlStatement1 = conn.prepareStatement(sql);
            sqlStatement1.setInt(1,eq_func.getId());
            sqlStatement1.execute();
            conn.close();
            list_eq_func = this.consultarMembrosEquipe(eq_func.getEquipe_id());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_eq_func;
    }
    
    public List<Setor> getSetor(Setor setor){
        List<Setor> list_setor = new ArrayList<>();
        PreparedStatement sqlStatement1 = null;
        ResultSet rs = null;
        String sql = null;
        try (Connection conn = conector.connect()){
            if(setor != null && setor.getId() != null){
                sql = "select * from Setor where id = ?";
                sqlStatement1 = conn.prepareStatement(sql);
                sqlStatement1.setInt(1,setor.getId());
                rs = sqlStatement1.executeQuery();
            }else if(setor != null && setor.getNome() != null){
                sql = "select * from Setor where nome like ?";
                sqlStatement1 = conn.prepareStatement(sql);
                String str = "%" + setor.getNome() + "%";
                sqlStatement1.setString(1,str);
                rs = sqlStatement1.executeQuery();
            }else{
                sql = "select * from Setor";
                sqlStatement1 = conn.prepareStatement(sql);                
                rs = sqlStatement1.executeQuery();
            }
            while(rs.next()){
                Setor st = new Setor();
                st.setId(rs.getInt("id"));
                st.setNome(rs.getString("nome"));
                list_setor.add(st);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_setor;
    }
    
    public List<Subsetor> getSubSetor(Subsetor ssetor){
        List<Subsetor> list_ssetor = new ArrayList<>();
        PreparedStatement sqlStatement1 = null;
        ResultSet rs = null;
        String sql = null;
        try (Connection conn = conector.connect()){
            if(ssetor != null && ssetor.getId() != null){
                sql = "select * from Subsetor where id = ?";
                sqlStatement1 = conn.prepareStatement(sql);
                sqlStatement1.setInt(1,ssetor.getId());
                rs = sqlStatement1.executeQuery();
            }else if(ssetor != null && ssetor.getSetor_id() != null){
                sql = "select * from Subsetor where setor_id = ?";
                sqlStatement1 = conn.prepareStatement(sql);
                sqlStatement1.setInt(1,ssetor.getSetor_id());
                rs = sqlStatement1.executeQuery();
            }else if(ssetor != null && ssetor.getNome() != null){
                sql = "select * from Subsetor where nome like ?";
                sqlStatement1 = conn.prepareStatement(sql);
                String str = "%" + ssetor.getNome() + "%";
                sqlStatement1.setString(1,str);
                rs = sqlStatement1.executeQuery();
            }else{
                sql = "select * from Subsetor";
                sqlStatement1 = conn.prepareStatement(sql);                
                rs = sqlStatement1.executeQuery();
            }
            while(rs.next()){
                Subsetor subsetor = new Subsetor();
                subsetor.setId(rs.getInt("id"));
                subsetor.setNome(rs.getString("nome"));
                subsetor.setSetor_id(rs.getInt("setor_id"));
                list_ssetor.add(subsetor);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list_ssetor;
    }

    public void alterarReceita(Receita receita)
    {
        
       
        try (Connection conn = conector.connect()){

                PreparedStatement sqlStatement1 = null;
                String sql = "update Receita set descricao = ?  where id = ?";
                sqlStatement1 = conn.prepareStatement(sql);
                sqlStatement1.setInt(2,receita.getId());
                sqlStatement1.setString(1, receita.getReceita());
                sqlStatement1.executeUpdate();
                conn.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        
    }
    public List<Receita> getReceitasDoPaciente(Long cpf)
    {
        
        List listareceitas = new ArrayList<>();
        PreparedStatement sqlStatement1 = null;
        ResultSet rs = null;
        try (Connection conn = conector.connect()){

                String sql = "select * from Receita where paciente_cpf = ?";
                sqlStatement1 = conn.prepareStatement(sql);
                sqlStatement1.setLong(1,cpf);
                rs = sqlStatement1.executeQuery();
            while(rs.next()){
                Receita receita = new Receita();
                receita.setCpfpaciente(rs.getLong("paciente_cpf"));
                receita.setReceita(rs.getString("descricao"));
                receita.setTipo(rs.getString("tipo"));
                receita.setId(rs.getInt("id"));
                listareceitas.add(receita);
               
                
                
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listareceitas;
    }
            
    
    public void cadastrarFuncionario(Funcionario func){
        String sql = null;
        PreparedStatement sqlStatement1 = null;
        try (Connection conn = conector.connect()){
            if(func.getDataNascimento() != null && func.getSalario() != null && func.getSetor_id() != null){
                sql = "insert into Funcionario (nome,cpf,datanasc,salario,setor_id,senha) values (?,?,?,?,?,?)";
                sqlStatement1 = conn.prepareStatement(sql);
                sqlStatement1.setString(1,func.getNome());
                sqlStatement1.setLong(2,func.getCPF());
                sqlStatement1.setString(3,func.getDataNascimento());
                sqlStatement1.setDouble(4,func.getSalario());
                sqlStatement1.setInt(5,func.getSetor_id());
                sqlStatement1.setString(6,"admin");
                sqlStatement1.execute();
            }else if(func.getDataNascimento() != null && func.getSalario() != null){
                sql = "insert into Funcionario (nome,cpf,datanasc,salario,senha) values (?,?,?,?,?)";
                sqlStatement1 = conn.prepareStatement(sql);
                sqlStatement1.setString(1,func.getNome());
                sqlStatement1.setLong(2,func.getCPF());
                sqlStatement1.setString(3,func.getDataNascimento());
                sqlStatement1.setDouble(4,func.getSalario());                
                sqlStatement1.setString(5,"admin");
                sqlStatement1.execute();
            }else if(func.getDataNascimento() != null){
                sql = "insert into Funcionario (nome,cpf,datanasc,senha) values (?,?,?,?)";
                sqlStatement1 = conn.prepareStatement(sql);
                sqlStatement1.setString(1,func.getNome());
                sqlStatement1.setLong(2,func.getCPF());
                sqlStatement1.setString(3,func.getDataNascimento());                               
                sqlStatement1.setString(4,"admin");
                sqlStatement1.execute();
            }else{
                sql = "insert into Funcionario (nome,cpf,senha) values (?,?,?)";
                sqlStatement1 = conn.prepareStatement(sql);
                sqlStatement1.setString(1,func.getNome());
                sqlStatement1.setLong(2,func.getCPF());              
                sqlStatement1.setString(3,"admin");
                sqlStatement1.execute();
            }
            conn.close();            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cadastrarMedico1(Medico med){
        String sql = null;
        PreparedStatement sqlStatement1 = null;
        try (Connection conn = conector.connect()){
            if(med.getAreaDeAtuacao() != null){
                sql = "insert into Medico (CRM,areaatuacao,funcionario_cpf) values (?,?,?)";
                sqlStatement1 = conn.prepareStatement(sql);
                sqlStatement1.setString(1,med.getCRM());
                sqlStatement1.setString(2,med.getAreaDeAtuacao());
                sqlStatement1.setLong(3,med.getCPF());            
                sqlStatement1.execute();
            }else{
                sql = "insert into Medico (CRM,funcionario_cpf) values (?,?)";
                sqlStatement1 = conn.prepareStatement(sql);
                sqlStatement1.setString(1,med.getCRM());                
                sqlStatement1.setLong(2,med.getCPF());            
                sqlStatement1.execute();
            }     
            conn.close();            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cadastrarEnfermeiro1(Enfermeiro enf){
        try (Connection conn = conector.connect()){
            String sql = "insert into Enfermeiro (tipo,funcionario_cpf) values (?,?)";
            PreparedStatement sqlStatement1 = conn.prepareStatement(sql);
            sqlStatement1.setString(1,enf.getTipo());
            sqlStatement1.setLong(2,enf.getCPF());            
            sqlStatement1.execute();
            conn.close();            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cadastrarFuncAdm(FuncionarioAdministrativo funcAd){
        try (Connection conn = conector.connect()){
            String sql = "insert into FuncionarioAdministrativo (cargo,funcionariocpf) values (?,?)";
            PreparedStatement sqlStatement1 = conn.prepareStatement(sql);
            sqlStatement1.setString(1,funcAd.getCargo());
            sqlStatement1.setLong(2,funcAd.getCPF());            
            sqlStatement1.execute();
            conn.close();            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
