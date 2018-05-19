public class Setor {

    private String nome;
    private Subsetor[] subsetores;
    private Equipe[] equipes;

    public String getNome() {
        return nome;
    }

    public Subsetor[] getSubsetores() {
        return subsetores;
    }

    public Equipe[] getEquipes() {
        return equipes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSubsetores(Subsetor[] subsetores) {
        this.subsetores = subsetores;
    }

    public void setEquipes(Equipe[] equipes) {
        this.equipes = equipes;
    }

	
}
