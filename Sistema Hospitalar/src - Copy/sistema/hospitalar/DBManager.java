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
                sqlStatement1.setInt(1,pac.getRG().intValue());
                rs = sqlStatement1.executeQuery();
            }
            while(rs.next()){
                Paciente pac1 = new Paciente();
                pac1.setCPF(rs.getLong("cpf"));
                pac1.setNome(rs.getString("nome"));
                pac1.setRG(rs.getLong("RG"));
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
}
