package sistema.hospitalar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;

public class AccessManager {

    ConectorDB conector = new ConectorDB();

    public boolean alterarSenha(Funcionario func, String senha) {
        try (Connection conn = conector.connect();) {
            String sqlAlterarSenha = "UPDATE funcionario SET senha = ? WHERE cpf = ?";
            PreparedStatement sqlStatement = conn.prepareStatement(sqlAlterarSenha);
            sqlStatement.setLong(2, func.getCPF());
            sqlStatement.setString(1, senha);
            sqlStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

}
