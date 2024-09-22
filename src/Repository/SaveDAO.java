package Repository;

import Model.Save;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaveDAO {

    public static Save novoJogo() throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "INSERT INTO save (id_cena) VALUES (1)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        Save save = new Save();
        if(generatedKeys.next()) {
            save.setSaveId(generatedKeys.getInt(1));
            save.setCenaAtual(CenaDAO.findCenaById(1));
        }
        return save;
    }
}
