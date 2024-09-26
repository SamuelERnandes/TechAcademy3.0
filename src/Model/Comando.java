package Model;

public class Comando {
    private int idItem;
    private int idCena;
    private String nome;
    private String descricao;
    private String comando;
    private String resposta;
    private Integer proximaCena; // Pode ser null

    // Getters e Setters
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdCena() {
        return idCena;
    }

    public void setIdCena(int idCena) {
        this.idCena = idCena;
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

    public Integer getProximaCena() {
        return proximaCena;
    }

    public void setProximaCena(Integer proximaCena) {
        Integer proximaCena1 = this.proximaCena;
    }
}