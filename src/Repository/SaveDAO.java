package Repository;
import Model.Cena;
import Model.Save;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaveDAO {

    // Método para criar um novo jogo
    public static Save novoJogo() throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "INSERT INTO save (id_cena) VALUES (1)";
        PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        stmt.executeUpdate();  // Atualizado para executeUpdate() em vez de execute(sql)
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        Save save = new Save();
        if (generatedKeys.next()) {
            save.setSaveId(generatedKeys.getInt(1));
            save.setCenaAtual(CenaDAO.findCenaById(1)); // Carrega a cena inicial (id = 1)
        }
        return save;
    }



    // Método para salvar o progresso do jogo (atualizar a cena no save)
    public static void salvarSave(Save save) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "UPDATE save SET id_cena = ? WHERE save_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, save.getCenaAtual().getIdCena());
        stmt.setInt(2, save.getSaveId());
        stmt.executeUpdate();
    }

    public static void atualizarCena(int saveId, int novaCenaId) {
        String sql = "UPDATE Save SET id_cena = ? WHERE id_save = ?";

        try (Connection conn = Mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, novaCenaId);
            stmt.setInt(2, saveId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar o save do jogador baseado no ID do save
    public static Save carregarSave(int idSave) {
        Save save = null;
        String sql = "SELECT * FROM Save WHERE id_save = ?";

        try (Connection conn = Mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idSave);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                save = new Save();
                save.setSaveId(rs.getInt("id_save"));

                // Criar um objeto Cena com o ID da cena atual
                Cena cenaAtual = new Cena();
                cenaAtual.setIdCena(rs.getInt("id_cena"));
                save.setCenaAtual(cenaAtual);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return save;
    }
}




