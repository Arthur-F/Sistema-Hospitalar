package sistema.hospitalar;

public class Enfermeiro extends Funcionario {

    String getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void setSalario(Double salario) {
        this.salario = salario;
    }
	
}
