package sistema.hospitalar;

public class FuncionarioAdministrativo extends Funcionario {

    private String cargo;

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }
    @Override
    public void setSalario(Double salario) {
        this.salario = salario;
    }

}
