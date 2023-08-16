import java.util.ArrayList;

public class Jogador {
    String nome;
    int id;
    int especial;
    public ArrayList<Classes> unidades = new ArrayList<>();

    public Jogador(int id, String nome, int especial) {
        this.nome = nome;
        this.id = id;
        this.especial =especial;

    }


    public ArrayList<Classes> getUnidades() {
        return unidades;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                '}';
    }
}
