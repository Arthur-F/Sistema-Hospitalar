/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalar;

/**
 *
 * @author arthur
 */
public class Laudo {
     private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String laudo;
    private Long cpfpaciente;



    public Long getCpfpaciente() {
        return cpfpaciente;
    }

    public void setCpfpaciente(Long cpfpaciente) {
        this.cpfpaciente = cpfpaciente;
    }

    public String getLaudo() {
        return laudo;
    }

    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }
    

    @Override
    public String toString() {
        return "Laudo " + this.id ; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
