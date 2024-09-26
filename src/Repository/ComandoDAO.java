package Repository;

import Model.Comando;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComandoDAO {

    // Método para buscar um comando específico por cena e comando digitado
    public static Comando findComandoByCenaAndTexto(int idCena, String textoComando) {
        Comando comando = null;
        String sql = "SELECT * FROM Itens WHERE id_cena = ? AND comando = ?";

        try (Connection conn = Mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCena);
            stmt.setString(2, textoComando);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                comando = new Comando();
                comando.setIdItem(rs.getInt("id_item"));
                comando.setIdCena(rs.getInt("id_cena"));
                comando.setNome(rs.getString("nome"));
                comando.setDescricao(rs.getString("descricao"));
                comando.setComando(rs.getString("comando"));
                comando.setResposta(rs.getString("resposta"));

                // A próxima cena pode ser null, então verificamos
                int proximaCena = rs.getInt("proxima_cena");
                if (!rs.wasNull()) {
                    comando.setProximaCena(proximaCena);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comando;
    }
}
