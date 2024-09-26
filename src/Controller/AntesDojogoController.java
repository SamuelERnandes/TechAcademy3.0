package Controller;

import Service.ComandoService;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class AntesDojogoController implements Route {

    @Override
    public Object handle(Request request, Response response) throws Exception {
        String comandoBruto = request.params(":comando");

        ComandoService comandoService = new ComandoService(comandoBruto);
        Gson gson = new Gson();


        return gson.toJson(comandoService.getResultadoConsole());



    }
}
