package Model;

public class Item {
    private Integer idItem;
    private String nome;
    private String descricao;
    private String comando;
    private String resposta;
    private Integer idProximaCena;

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Integer getIdProximaCena() {
        return idProximaCena;
    }

    public void setIdProximaCena(Integer idProximaCena) {
        this.idProximaCena = idProximaCena;
    }

    @Override
    public String toString() {
        return "Item{" +
                "idItem=" + idItem +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", comando='" + comando + '\'' +
                ", resposta='" + resposta + '\'' +
                ", idProximaCena=" + idProximaCena +
                '}';
    }
}
