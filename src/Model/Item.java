package Model;

public class Item {
    private int idItem;
    private String nomeItem;
    private String descricao;

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Item{" +
                "idItem=" + idItem +
                ", nomeItem='" + nomeItem + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
