/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalar;

/**
 *
 * @author Gabriel
 */
public class MembrosEquipe {
    
    private Integer id;
    private Integer equipe_id;
    private Long func_cpf;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEquipe_id() {
        return equipe_id;
    }

    public void setEquipe_id(Integer equipe_id) {
        this.equipe_id = equipe_id;
    }

    public Long getFunc_cpf() {
        return func_cpf;
    }

    public void setFunc_cpf(Long func_cpf) {
        this.func_cpf = func_cpf;
    }
    
}
