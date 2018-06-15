package sistema.hospitalar;

public class SalaCirurgia extends Sala {

    private Equipe equipeResponsavel;

    public void setEquipeResponsavel(Equipe equipeResponsavel) {
        this.equipeResponsavel = equipeResponsavel;
    }

    public Equipe getEquipeResponsavel() {
        return equipeResponsavel;
    }

}
