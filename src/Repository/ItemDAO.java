package Repository;

import Model.Item;
import Model.Cena;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    // Método para encontrar um item pelo seu ID
    public static Item findItemById(Integer id) throws SQLException {
        Connection connection = Mysql.getConnection();
        String sql = "SELECT * FROM Itens WHERE id_item = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            return mapResultSetToItem(resultSet); // Mapeia o item encontrado
        }

        return null; // Retorna null se o item não for encontrado
    }

    // Método para encontrar itens associados a uma cena
    public static List<Item> findItensByScene(Cena cena) throws SQLException {
        Connection connection = Mysql.getConnection();
        String sql = "SELECT * FROM Itens WHERE id_cena = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, cena.getIdCena());
        ResultSet resultSet = ps.executeQuery();
        List<Item> itens = new ArrayList<>();

        while (resultSet.next()) {
            itens.add(mapResultSetToItem(resultSet)); // Adiciona o item à lista
        }

        return itens; // Retorna a lista de itens da cena
    }

    // Método para encontrar um item pelo nome
    public static Item findItemByName(String nome) throws SQLException {
        Connection connection = Mysql.getConnection();
        String sql = "SELECT * FROM Itens WHERE nome = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, nome);
        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            return mapResultSetToItem(resultSet); // Mapeia o item encontrado
        }

        return null; // Retorna null se o item não for encontrado
    }

    // Método para encontrar um item com base na cena e no comando
    public static Item findBySceneAndCommand(int idCena, String comando) throws SQLException {
        Connection connection = Mysql.getConnection();
        String sql = "SELECT * FROM Itens WHERE id_cena = ? AND comando = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idCena); // Define o id da cena
        ps.setString(2, comando); // Define o comando
        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            return mapResultSetToItem(resultSet); // Mapeia o item encontrado
        }

        return null; // Retorna null se nenhum item for encontrado
    }

    // Método auxiliar para mapear o ResultSet em um objeto Item
    private static Item mapResultSetToItem(ResultSet resultSet) throws SQLException {
        Item item = new Item();
        item.setIdItem(resultSet.getInt("id_item"));
        item.setNome(resultSet.getString("nome"));
        item.setIdProximaCena(resultSet.getInt("proxima_cena"));
        item.setComando(resultSet.getString("comando")); // Mapeia o comando
        item.setResposta(resultSet.getString("resposta")); // Mapeia a resposta
        return item; // Retorna o item mapeado
    }
}
