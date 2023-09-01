import java.util.ArrayList;

public abstract class Jogador {
    String nome;
    private final ArrayList<Classe> unidades = new ArrayList<>();
    public abstract void executarAcao();
    public ArrayList<Classe> getUnidades() {
        return unidades;
    }
}
