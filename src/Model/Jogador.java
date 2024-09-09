package Model;

public class Jogador {
    private int idJogador;
    private String nome;

    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "idJogador=" + idJogador +
                ", nome='" + nome + '\'' +
                '}';
    }
}
