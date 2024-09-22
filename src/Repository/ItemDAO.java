package Repository;

import Model.Item;
import Model.Cena;
import Model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    public static Item findItemById(Integer id) {
        return new Item();
    }

    public static List<Item> findItensByScene(Cena cena) throws SQLException {

        Connection connection = Mysql.getConnection();
        String sql = "select * from Itens where id_cena = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, cena.getIdCena());
        ResultSet resultSet = ps.executeQuery();
        List<Item> itens = new ArrayList<>();

        while (resultSet.next()) {
            Item item = new Item();
            item.setIdItem(resultSet.getInt("id_item"));

            item.setNome(resultSet.getString("nome"));

            Integer idProximaCena = resultSet.getInt("proxima_cena");
            item.setIdProximaCena(idProximaCena);

            itens.add(item);
        }


        return itens;
    }

}
