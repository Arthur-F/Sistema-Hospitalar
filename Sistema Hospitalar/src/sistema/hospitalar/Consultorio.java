package sistema.hospitalar;

public class Consultorio extends Sala {

    Medico medicoResponsavel;
    String especialidadeConsultorio;

    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setMedicoResponsavel(Medico medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }

    public String getEspecialidadeConsultorio() {
        return especialidadeConsultorio;
    }

    public void setEspecialidadeConsultorio(String especialidadeConsultorio) {
        this.especialidadeConsultorio = especialidadeConsultorio;
    }

}
