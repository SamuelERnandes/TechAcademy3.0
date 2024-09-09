package Model;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Item> itens;

    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(Item item) {
        itens.remove(item);
    }
    public void listarItens() {
        if(itens.isEmpty()) {
            System.out.println("O Inventário está vazio");
        }else {
            System.out.println("Itens no inventário");
        }
        for(Item item : itens) {
            System.out.println(item);
        }
    }
}
