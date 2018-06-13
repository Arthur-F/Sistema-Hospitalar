package sistema.hospitalar;

import java.sql.Date;
import java.util.List;

public class Paciente {

    private String nome;

    private Long CPF;

    private Date dataNascimento;

    private Double salario;
    
    private int id_equipe;
    
    private String senha;
    
    private Integer setor_id;
    
    private Integer papel_id;
    
    private Long RG;

    public Long getRG() {
        return RG;
    }

    public void setRG(Long RG) {
        this.RG = RG;
    }

    public Integer getPapel_id() {
        return papel_id;
    }

    public void setPapel_id(Integer papel_id) {
        this.papel_id = papel_id;
    }

    public Integer getSetor_id() {
        return setor_id;
    }

    public void setSetor_id(Integer setor_id) {
        this.setor_id = setor_id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

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

    public void setCPF(Long CPF) {
        this.CPF = CPF;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }


}
