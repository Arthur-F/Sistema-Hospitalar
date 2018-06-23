
package sistema.hospitalar;

import java.sql.Date;
import java.sql.Time;

public class Agendamento {
    
    private Integer id;
    private String data;
    private String hora;
    private Integer sala_id;
    private Long paciente_id;
    private Integer equipe_id;
    private Integer procedimento_id;
    private String proc_nome;
    private String eq_nome;
    private String pac_nome;
    private String supervisor_crm;

    public String getSupervisor_crm() {
        return supervisor_crm;
    }

    public void setSupervisor_crm(String supervisor_crm) {
        this.supervisor_crm = supervisor_crm;
    }

    public String getProc_nome() {
        return proc_nome;
    }

    public void setProc_nome(String proc_nome) {
        this.proc_nome = proc_nome;
    }

    public String getEq_nome() {
        return eq_nome;
    }

    public void setEq_nome(String eq_nome) {
        this.eq_nome = eq_nome;
    }

    public String getPac_nome() {
        return pac_nome;
    }

    public void setPac_nome(String pac_nome) {
        this.pac_nome = pac_nome;
    }

    public Integer getProcedimento_id() {
        return procedimento_id;
    }

    public void setProcedimento_id(Integer procedimento_id) {
        this.procedimento_id = procedimento_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getSala_id() {
        return sala_id;
    }

    public void setSala_id(Integer sala_id) {
        this.sala_id = sala_id;
    }

    public Long getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(Long paciente_id) {
        this.paciente_id = paciente_id;
    }

    public Integer getEquipe_id() {
        return equipe_id;
    }

    public void setEquipe_id(Integer equipe_id) {
        this.equipe_id = equipe_id;
    }
    
}
