package sistema.hospitalar;

import java.sql.Date;
import java.util.List;

public class SistemaHospitalar {

    public static void main(String[] args) {
        // TODO code application logic here
        DBManager dbManager = new DBManager();
        AccessManager accessmanager = new AccessManager();
        new TelaLogin().setVisible(true);
        //new TelaConsultarEquipe().setVisible(true);
    }

}
