package sistema.hospitalar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;

public abstract class Funcionario {

    protected String nome;
    protected Long CPF;
    protected String dataNascimento;
    protected Double salario;    
    protected String senha;
    protected Integer setor_id;
    protected Integer papel_id;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

//    private Date dataNascimento;

//    protected Double salario;
    
    //Esse método não deveria estar no dbmanager?
    public boolean cadastrarFuncionario() {

        return true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCPF() {
        return CPF;
    }

    public Integer getSetor_id() {
        return setor_id;
    }

    public void setSetor_id(Integer setor_id) {
        this.setor_id = setor_id;
    }

    public Integer getPapel_id() {
        return papel_id;
    }

    public void setPapel_id(Integer papel_id) {
        this.papel_id = papel_id;
    }

    public void setCPF(Long CPF) {
        this.CPF = CPF;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

}
