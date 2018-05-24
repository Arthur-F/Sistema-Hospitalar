package sistema.hospitalar;

import java.sql.Date;

public class SistemaHospitalar {

    public static void main(String[] args) {
        // TODO code application logic here
        DBManager dbManager = new DBManager();

//        Medico medicoteste = new Medico();
//        medicoteste.setCPF("12345678910");
//        medicoteste.setNome("Fulano da Silva");
//        medicoteste.setDataNascimento(new Date(18900));
//        medicoteste.setSalario(6000.00);
//        medicoteste.setAreaDeAtuacao("Lorem");
//        medicoteste.setEspecialidade("Ipsum");
//        medicoteste.setCRM("1234567890RJ");
//        dbManager.cadastrarMedico(medicoteste);
        dbManager.consultarFuncionario(12345678910L);
    }

}
