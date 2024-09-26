package Repository;

import Model.Cena;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CenaDAO {
    public static Integer idCenaAtual; // Variável para armazenar a cena atual

    // Método para encontrar uma cena pelo ID
    public static Cena findCenaById(Integer id) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "SELECT * FROM Cenas WHERE id_cena = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Cena cena = new Cena();

        // Verifica se há uma cena correspondente
        if (rs.next()) {
            cena.setIdCena(rs.getInt("id_cena"));
            cena.setDescricao(rs.getString("descricao"));
            cena.setItens(ItemDAO.findItensByScene(cena));
        }

        return cena;
    }


}
