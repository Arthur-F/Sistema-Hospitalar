package sistema.hospitalar;

import java.util.List;

public class Equipe {

    private int ID;
    
    private String nome;

    private Medico medicoSupervisor;

    private List<Medico> medicos;

    private List<Enfermeiro> enfermeiros;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Medico getMedicoSupervisor() {
        return medicoSupervisor;
    }

    public void setMedicoSupervisor(Medico medicoSupervisor) {
        this.medicoSupervisor = medicoSupervisor;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public List<Enfermeiro> getEnfermeiros() {
        return enfermeiros;
    }

    public void setEnfermeiros(List<Enfermeiro> enfermeiros) {
        this.enfermeiros = enfermeiros;
    }

   

}
