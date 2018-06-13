package sistema.hospitalar;

public abstract class Procedimento {

 private String nome;

    private Double valor;

    private Equipe[] equipe;

    private Pagamento pagamento;
    
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }

}
