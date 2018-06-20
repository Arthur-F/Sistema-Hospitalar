package sistema.hospitalar;

public class Subsetor {

    private String nome;

    private Sala[] salas;

    public String getNome() {
        return nome;
    }

    public Sala[] getSalas() {
        return salas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalas(Sala[] salas) {
        this.salas = salas;
    }

}
