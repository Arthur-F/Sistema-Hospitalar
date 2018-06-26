package sistema.hospitalar;

public class Receita {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String receita;
    private String tipo;
    private Long cpfpaciente;
    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {

        this.receita = receita;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getCpfpaciente() {
        return cpfpaciente;
    }

    public void setCpfpaciente(Long cpfpaciente) {
        this.cpfpaciente = cpfpaciente;
    }

    @Override
    public String toString() {
        return "Receita " + this.id + ": " + this.tipo; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
