package sistema.hospitalar;

public class Subsetor {

    private String nome;
    private Integer setor_id;
    private Sala[] salas;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSetor_id() {
        return setor_id;
    }

    public void setSetor_id(Integer setor_id) {
        this.setor_id = setor_id;
    }

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

    @Override
    public String toString() {
        return "Subsetor " + id + ": " + nome;
    }
    
}
