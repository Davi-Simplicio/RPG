import java.util.ArrayList;
import java.util.Objects;

public class Multiplayer extends ModoDeJogo {

    @Override
    public void cadastraJogador() {
        do {
            super.cadastraJogador();
        }while (jogadores.size()<2);
    }

    @Override
    public ArrayList<Classe> definirUnidades(Usuario jogadorE) {
        for (int i = 0; i <= 2; ) {
            int opcao;
            System.out.println(jogadorE.nome + """ 
                     Escolha um personagem para seu time:
                    [1]Arqueiro
                    [2]Guerreiro
                    [3]Ladino
                    [4]Mago""");
            opcao = sc.nextInt();
            int id = jogadorE.getUnidades().size();
            switch (opcao) {
                case 1:
                    Arqueiro arqueiro = new Arqueiro(id);
                    jogadorE.getUnidades().add(arqueiro);
                    break;
                case 2:
                    Guerreiro guerreiro = new Guerreiro(id);
                    jogadorE.getUnidades().add(guerreiro);
                    break;
                case 3:
                    Ladino ladino = new Ladino(id);
                    jogadorE.getUnidades().add(ladino);
                    break;
                case 4:
                    Mago mago = new Mago(id);
                    jogadorE.getUnidades().add(mago);
                    break;
            }
        }
    }
    @Override
    public int menu() {
        int opcao;
        do {
            System.out.println("""
                    [1]Mostrar Times
                    [2]Lutar
                    [3]Sair""");
             opcao = sc.nextInt();

        } while (opcao < 1 ||opcao > 3);
        return opcao;
    }

    @Override
    public void executarAcao(int opcao) {
        switch (opcao){
            case 1:
                mostrarTime();
                break;
            case 2:
                menuDeLutaMultiplayer();
                break;
            case 3:
                break;
        }
    }
    public void menuDeLutaMultiplayer() {
        int opcaoMenuLuta;
        Jogador jogadorAtual = getJogadorAtual();
        Jogador jogadorAdversario = getJogadorAdversario()
        do {
                System.out.println("""
                        Vez de\040""" + jogadorAtual.nome + "\n" + """
                        Oque você deseja fazer?
                        [1]Atacar
                        [2]Defender
                        [3]Especial(Apenas depois de 3 rodadas)
                        [4]Propor Empate
                        [5]Desistir""");
                opcaoMenuLuta = sc.nextInt();
                if (opcaoMenuLuta == 3) {
                    if (jogadorAtual.getEspecial() >= 3) {
                        jogadorAtual.setEspecial(0);
                    } else {
                        System.out.println("Especial não carregado");
                        opcaoMenuLuta = 6;
                    }
                }
                switch (opcaoMenuLuta) {
                    case 1:
                        atacar(jogadorAtual, jogadorAdversario.getUnidades());
                        break;
                    case 2:
                        defender(jogadorAtual);
                        break;
                    case 3:
                        especial(jogadorAtual, jogadorAdversario.getUnidades());
                        break;

                    case 4:
                        if (empate()) {
                            vez = 0;
                        }

                        break;
                    case 5:
                        desistir(jogadorAtual);
                        break;

                }
                if (verificaVitoria() && opcaoMenuLuta != 3) {
                    if (jogadorAtual == p1) {
                        System.out.println(p2.nome + " Venceu o jogo");
                    } else {
                        System.out.println(p1.nome + " Venceu o jogo");
                    }
                    vez = 0;
                    for (Jogador jogador : jogadores) {
                        jogador.getUnidades().removeIf(Objects::nonNull);
                    }
                }
                if (vez == 1) {
                    vez = 2;
                    p1.setEspecial(p1.getEspecial() + 1);
                } else if (vez == 2) {
                    vez = 1;
                    p2.setEspecial(p2.getEspecial() + 1);
                }
            }
        } while (vez != 0);
    }
}
