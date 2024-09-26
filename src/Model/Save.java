package Model;

public class Save {
    private Integer saveId;
    private Cena cenaAtual;
    private Integer IdJogador;
    private Integer idSave;

    public Integer getSaveId() {
        return saveId;
    }

    public void setSaveId(Integer saveId) {
        this.saveId = saveId;
    }

    public Cena getCenaAtual() {
        return cenaAtual;
    }

    public void setCenaAtual(Cena cenaAtual) {
        this.cenaAtual = cenaAtual;
    }

    @Override
    public String toString() {
        return "Save{" +
                "saveId=" + saveId +
                ", cenaAtual=" + cenaAtual +
                '}';
    }

    public int getIdJogador() {
        return getIdJogador();
    }

    public void setIdJogador(int idJogador) {
        this.IdJogador = idJogador;
    }

    public int getIdSave() {
        return idSave;
    }

    public void setIdSave(int idSave) {
        this.idSave = idSave;
    }
}
