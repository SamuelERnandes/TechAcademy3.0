
import Model.Console;
import Model.Save;
import Repository.CenaDAO;
import Repository.SaveDAO;
import com.google.gson.Gson;
import spark.Spark;

import java.sql.SQLException;

public class Main {
    private static final Gson Gson = new Gson();
    public static void main(String[] args)  {
        try {
            Save save = SaveDAO.novoJogo();
            Console console = new Console();


            String saveJson = Gson.toJson(save);
            Spark.get("/", ((req, res) -> saveJson));


            Spark.get("/",(req,res)-> saveJson);
            Spark.get("cena/:id",(req, res) -> {
                Integer idCena = Integer.parseInt(req.params(":id"));
                return Gson.toJson(CenaDAO.findCenaById(idCena));
            });


            Spark.get("cena/:id", (req,res)->{
                Integer idCena = Integer.parseInt(req.params(":id"));
                return Gson.toJson(CenaDAO.findCenaById(idCena));

            });







        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}