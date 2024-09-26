package Repository;

import Model.Inventario;
import Model.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InventarioDAO {


    public static Inventario carregarInventario(int idJogador) throws SQLException {
        Connection connection = Mysql.getConnection();
        String sql = "SELECT i.id_item, it.nome FROM Inventario i JOIN Itens it ON i.id_item = it.id_item WHERE i.id_jogador = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idJogador);
        ResultSet rs = ps.executeQuery();


        Inventario inventario = new Inventario(idJogador);
        while (rs.next()) {
            Item item = new Item();
            item.setIdItem(rs.getInt("id_item"));
            item.setNome(rs.getString("nome"));
            inventario.addItem(item);  // Adicionar o item ao inventário
        }

        rs.close(); // Fecha o ResultSet
        ps.close(); // Fecha o PreparedStatement
        connection.close(); // Fecha a conexão
        return inventario;
    }

    // Método para salvar um item no inventário de um jogador
    public static void salvarItem(int idJogador, Item item) throws SQLException {
        Connection connection = Mysql.getConnection();
        String sql = "INSERT INTO Inventario (id_jogador, id_item) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idJogador);  // Define o id do jogador
        ps.setInt(2, item.getIdItem());  // Define o id do item
        ps.executeUpdate();  // Executa a inserção

        ps.close(); // Fecha o PreparedStatement
        connection.close(); // Fecha a conexão
    }

    // Método para remover um item do inventário de um jogador
    public static void removerItem(int idJogador, Item item) throws SQLException {
        Connection connection = Mysql.getConnection();
        String sql = "DELETE FROM Inventario WHERE id_jogador = ? AND id_item = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idJogador);  // Define o id do jogador
        ps.setInt(2, item.getIdItem());  // Define o id do item a ser removido
        ps.executeUpdate();  // Executa a remoção

        ps.close(); // Fecha o PreparedStatement
        connection.close(); // Fecha a conexão
    }
}
