import Model.Console;
import Model.Save;
import Model.Item;
import Model.Cena;
import Repository.CenaDAO;
import Repository.ItemDAO;
import Repository.SaveDAO;
import Repository.InventarioDAO;
import Service.ComandoService;
import com.google.gson.Gson;
import spark.Spark;

import static spark.Spark.get;

public class Main {
    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        try {

            Save save = SaveDAO.novoJogo();
            Console console = new Console();
            console.setIdSave(save.getSaveId());
            console.setMensagem(save.getCenaAtual().getDescricao());


            Spark.get("/", (req, res) -> gson.toJson(console));


            Spark.get("/cena/:id", (req, res) -> {
                Integer idCena = Integer.parseInt(req.params(":id"));
                Cena cenaAtual = CenaDAO.findCenaById(idCena);

                if (cenaAtual != null) {
                    return gson.toJson(cenaAtual);
                } else {
                    return gson.toJson("Cena não encontrada.");
                }
            });


            Spark.get("/comando/:comando", (req, res) -> {
                String comandoBruto = req.params(":comando");
                ComandoService comandoService = new ComandoService(comandoBruto);
                Console resultadoConsole = comandoService.getResultadoConsole();
                res.type("application/json");
                return gson.toJson(resultadoConsole);
            });

            Spark.post("/comando/:comando", (req, res) -> {
                String comando = req.params(":comando").toUpperCase(); // Pegamos o comando do frontend
                Save saveAtual = SaveDAO.carregarSave(console.getIdSave()); // Pega o jogo salvo
                Cena cenaAtual = saveAtual.getCenaAtual(); // Pega a cena atual do jogo


                if (comando.startsWith("GET")) {
                    String nomeItem = comando.substring(4); // Extrai o nome do item do comando
                    Item item = ItemDAO.findItemByName(nomeItem);

                    if (item != null) {
                        InventarioDAO.salvarItem(saveAtual.getIdSave(), item); // Salva o item no inventário
                        console.setMensagem("Você pegou o " + item.getNome() + " e ele foi adicionado ao seu inventário.");
                    } else {
                        console.setMensagem("Item não encontrado.");
                    }
                } else {
                    console.setMensagem("Comando inválido.");
                }

                return gson.toJson(console);
            });

            Spark.get("/inventario/:idJogador", (req, res) -> {
                Integer idJogador = Integer.parseInt(req.params(":idJogador"));
                return gson.toJson(InventarioDAO.carregarInventario(idJogador));
            });


            Spark.post("/inventario/:idJogador/pegar/:idItem", (req, res) -> {
                Integer idJogador = Integer.parseInt(req.params(":idJogador"));
                Integer idItem = Integer.parseInt(req.params(":idItem"));

                Item item = ItemDAO.findItemById(idItem);
                if (item != null) {
                    InventarioDAO.salvarItem(idJogador, item);
                    return gson.toJson("Item " + item.getNome() + " adicionado ao inventário.");
                } else {
                    return gson.toJson("Item não encontrado.");
                }
            });


            Spark.post("/cena/proxima/:idSave", (req, res) -> {
                Integer idSave = Integer.parseInt(req.params(":idSave"));
                Save saveAtual = SaveDAO.carregarSave(idSave);
                Cena cenaAtual = saveAtual.getCenaAtual();

                if (cenaAtual.getProximaCena() != null) {
                    Cena proximaCena = CenaDAO.findCenaById(cenaAtual.getProximaCena());
                    if (proximaCena != null) {
                        saveAtual.setCenaAtual(proximaCena);
                        SaveDAO.salvarSave(saveAtual);
                        console.setMensagem(proximaCena.getDescricao());
                        return gson.toJson(console);
                    } else {
                        return gson.toJson("Próxima cena não encontrada.");
                    }
                } else {
                    return gson.toJson("Não há mais cenas. Você completou a história.");
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
            Spark.halt(500);
        }
    }
}
