package Model;

public class Save {
    private Integer saveId;
    private Cena cenaAtual;

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
}
