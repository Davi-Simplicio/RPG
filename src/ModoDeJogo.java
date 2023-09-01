import java.util.ArrayList;
import java.util.Scanner;

public abstract class ModoDeJogo {
    static Scanner sc = new Scanner(System.in);
    int rodada=0;
    public ArrayList<Jogador> jogadores = new ArrayList<>();
    public abstract ArrayList<Classe>definirUnidades(Usuario jogador);

    public abstract int menu();
    public void cadastraJogador() {
        System.out.println("Cadastre um nome de Usuario");
        String nome = sc.next();
        Jogador jogador = new Usuario( nome, 0);
        jogadores.add(jogador);
    }
    public abstract void executarAcao(int opcao);
    public void mostrarTime() {
        for (Jogador jogadorE : jogadores) {
            System.out.println("Time de " + jogadorE.nome + "\n");
            for (Classe unidade : jogadorE.getUnidades()) {
                System.out.println(unidade + "\n");
            }
        }
    }
    public Jogador getJogadorAtual(){
        return jogadores.get(rodada%2);
    }
    public Jogador getJogadorAdversario(){
        return jogadores.get((rodada+1)%2);
    }
}
