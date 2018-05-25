package sistema.hospitalar;

import java.util.List;

public class Paciente {

    private String nome;

    private Long CPF;

    private String RG;

    private List<String> receitas;

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

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public List<String> getReceitas() {
        return receitas;
    }


}
