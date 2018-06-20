package sistema.hospitalar;

public abstract class Procedimento {

 private String nome;

    protected Double valor;

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

    public Equipe[] getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe[] equipe) {
        this.equipe = equipe;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;

    }

}
