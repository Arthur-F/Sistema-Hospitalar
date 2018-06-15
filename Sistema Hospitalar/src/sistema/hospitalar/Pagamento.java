package sistema.hospitalar;

public class Pagamento {

    private Double[] valor;

    private String nome;

    private Paciente paciente;

    public void setValor(Double[] valor) {
        this.valor = valor;
    }

    public Double[] getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    
}
