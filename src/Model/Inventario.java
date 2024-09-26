package Model;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private int idJogador;
    private List<Item> itens;

    // Construtor
    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public Inventario(int idJogador) {
        this.idJogador = idJogador;
        this.itens = new ArrayList<>();
    }

    // Getter e Setter para idJogador
    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
    }

    // Getter para os itens
    public List<Item> getItens() {
        return itens;
    }

    // Adicionar item ao inventário
    public void addItem(Item item) {
        this.itens.add(item);
    }

    // Remover item do inventário
    public void removeItem(Item item) {
        this.itens.remove(item);
    }

    // Verificar se o item está no inventário
    public boolean hasItem(Item item) {
        return this.itens.contains(item);
    }

    // Verificar se o inventário está vazio
    public boolean isEmpty() {
        return this.itens.isEmpty();
    }

    // Método para exibir o inventário (opcional, para facilitar o debug)
    public String mostrarInventario() {
        if (itens.isEmpty()) {
            return "O inventário está vazio.";
        }

        StringBuilder inventarioStr = new StringBuilder("Itens no inventário:\n");
        for (Item item : itens) {
            inventarioStr.append("- ").append(item.getNome()).append("\n");
        }
        return inventarioStr.toString();
    }
}

