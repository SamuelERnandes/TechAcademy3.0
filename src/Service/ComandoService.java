package Service;

import Model.Console;
import Model.Item;
import Repository.ItemDAO;

import java.sql.SQLException;

public class ComandoService {
    private String comandoBruto;
    private Console console;


    public ComandoService(String comandoBruto) {
        this.comandoBruto = comandoBruto;
    }


    public Console help() {

        String[] mensagensAjuda = {
                "O objetivo do text adventure é o usuário interagir com os objetos descritos na cena " +
                        "(identificados pelos nomes em letra MAIÚSCULAS) para avançar no jogo.",
                "Comandos possíveis:",
                "HELP: Exibe o menu de ajuda do jogo.",
                "USE [ITEM] COM [ITEM]: Interage com um item da cena usando outro item.",
                "CHECK [ITEM]: Mostra a descrição de um item da cena.",
                "GET [ITEM]: Adiciona o item ao inventário, se possível.",
                "INVENTORY: Mostra os itens atualmente no inventário.",
                "SAVE: Salva o progresso atual do jogo.",
                "LOAD: Carrega um jogo salvo anteriormente.",
                "RESTART: Reinicia o jogo do começo."
        };

        return console;
    }


    public Console getResultadoConsole() {
        Console console = new Console();
        String resposta = "";


        String[] partes = comandoBruto.split(" ");
        String comando = partes[0];
        String item = partes.length > 1 ? partes[1] : null;


        if ("CHECK".equalsIgnoreCase(comando) && item != null) {
            Item itemEncontrado;
            try {
                itemEncontrado = ItemDAO.findItemByName(item);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if (itemEncontrado != null) {
                resposta = itemEncontrado.getResposta();
            } else {
                resposta = "Item não encontrado.";
            }
        } else if ("GET".equalsIgnoreCase(comando) && item != null) {
            Item itemParaPegar;
            try {
                itemParaPegar = ItemDAO.findItemByName(item); // Busca o item pelo nome
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if (itemParaPegar != null) {


                resposta = "O item " + itemParaPegar.getNome() + " foi adicionado ao seu inventário.";
            } else {
                resposta = "Item não encontrado.";
            }
        } else if ("USE".equalsIgnoreCase(comando) && partes.length > 2) {
            String itemUso = partes[1];
            String itemCom = partes[2];

            Item itemUsar;
            try {
                itemUsar = ItemDAO.findItemByName(itemUso);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            Item itemCompara;
            try {
                itemCompara = ItemDAO.findItemByName(itemCom);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if (itemUsar != null && itemCompara != null) {


                resposta = "Você usou " + itemUsar.getNome() + " com " + itemCompara.getNome() + ".";
            } else {
                resposta = "Um ou ambos os itens não foram encontrados.";
            }
        }
        // Comando inválido
        else {
            resposta = "Comando inválido.";
        }

        console.setMensagem(resposta);
        return console;
    }
}
