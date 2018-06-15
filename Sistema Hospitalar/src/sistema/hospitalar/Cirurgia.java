package sistema.hospitalar;

public class Cirurgia extends Procedimento {

    Equipe equipeResponsável;

    public Equipe getEquipeResponsável() {
        return equipeResponsável;
    }

    public void setEquipeResponsável(Equipe equipeResponsável) {
        this.equipeResponsável = equipeResponsável;
    }

    @Override
    public void setValor(Double valor) {
        this.valor = valor;
    }
}
