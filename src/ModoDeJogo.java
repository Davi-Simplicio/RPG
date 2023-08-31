import java.util.ArrayList;
import java.util.Scanner;

public abstract class ModoDeJogo {
    static Scanner sc = new Scanner(System.in);
    static Usuario jogadorAtual;
    public static ArrayList<Jogador> jogadores = new ArrayList<>();
    public abstract ArrayList<Classe>definirUnidades(Usuario jogador);

    public abstract void menu();
    public void cadastraJogador() {
        System.out.println("Cadastre um nome de Usuario");
        String nome = sc.next();
        Jogador jogador = new Usuario(jogadores.size() + 1, nome, 0);
        jogadores.add(jogador);
    }
}
