package Model;

public class Cena {
    private int idCena;
    private String descricaocena;
    private int numeroCena;

    public int getIdCena() {
        return idCena;
    }

    public void setIdCena(int idCena) {
        this.idCena = idCena;
    }

    public String getDescricaocena() {
        return descricaocena;
    }

    public void setDescricaocena(String descricaocena) {
        this.descricaocena = descricaocena;
    }

    public int getNumeroCena() {
        return numeroCena;
    }

    public void setNumeroCena(int numeroCena) {
        this.numeroCena = numeroCena;
    }

    @Override
    public String toString() {
        return "Cena{" +
                "idCena=" + idCena +
                ", descricaocena='" + descricaocena + '\'' +
                ", numeroCena=" + numeroCena +
                '}';
    }
}
