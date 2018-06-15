package sistema.hospitalar;

public class Consulta extends Procedimento {

    private String diagnostico;

    private String exames;

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setExames(String exames) {
        this.exames = exames;
    }

    public String getExames() {
        return exames;
    }

    @Override
    public void setValor(Double valor) {
        this.valor = valor;
    }

}
