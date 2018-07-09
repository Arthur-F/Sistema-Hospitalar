package sistema.hospitalar;

import java.sql.Date;
import java.util.List;

public class SistemaHospitalar {

   public static void main(String[] args) {
        // TODO code application logic here
        DBManager dbManager = new DBManager();
        AccessManager accessmanager = new AccessManager();
        //new TelaLogin().setVisible(true);
        
        //PayManager paymanager = new PayManager();
        new SwingEmailSender().setVisible(true);
        //new TelaConsultarSalas().setVisible(true);
        
        Laudo laudo = new Laudo();
        laudo.setCpfpaciente(12345L);
        laudo.setLaudo("aheuaehuaehuaheuhae");
        dbManager.gerarPDFLaudo(laudo);
        
    }
}
