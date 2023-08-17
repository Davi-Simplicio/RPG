
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Executavel {
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<Jogador> jogadores = new ArrayList<>();
    public static ArrayList<Classe> unidadesAdversarias = new ArrayList<>();

    public static void main(String[] args) {
        cadastraUsuario();
    }

    public static void defineTime() {
        for (Jogador jogadorE : jogadores) {
            if (jogadorE.unidades.size() == 0) {
                for (int i = 0; i <= 2; ) {
                    int opcao = 0;
                    System.out.println(jogadorE.nome + """ 
                             Escolha um personagem para seu time:
                            [1]Arqueiro
                            [2]Guerreiro
                            [3]ladino
                            [4]Mago """);
                    opcao = sc.nextInt();
                    int id = jogadorE.getUnidades().toArray().length;
                    switch (opcao) {
                        case 1:
                            Arqueiro arqueiro = new Arqueiro("Arqueiro", 100, 30, 25, 5, 10, 90, id);
                            jogadorE.unidades.add(arqueiro);
                            i++;
                            break;
                        case 2:
                            Guerreiro guerreiro = new Guerreiro("Guerreiro", 100, 10, 50, 2, 1, 100, id);
                            jogadorE.unidades.add(guerreiro);
                            i++;
                            break;
                        case 3:
                            Ladino ladino = new Ladino("Ladino", 100, 50, 0, 8, 10, 90, id);
                            jogadorE.unidades.add(ladino);
                            i++;
                            break;
                        case 4:
                            Mago mago = new Mago("Mago", 100, 30, 25, 0, 20, 50, id);
                            jogadorE.unidades.add(mago);
                            i++;
                            break;
                    }
                }
            } else {
                System.out.println("Os times já estão definidos");
            }
        }
    }

    public static void cadastraUsuario() {
        int id;
        do {
            System.out.println("Cadastre um nome de Usuario");
            String nome = sc.next();

            if (jogadores.size() == 0) {
                id = 1;
                Jogador jogador = new Jogador(id, nome, 0);
                jogadores.add(jogador);
            } else {
                id = 2;
                Jogador jogador = new Jogador(id, nome, 0);
                jogadores.add(jogador);
            }
        } while (id != 2);
        menu();
    }

    public static void modoDeJogo() {
        int opcao;
        do {


            System.out.println("Você deseja jogar Campanha ou Multiplayer?\n[1]Campanha\n[2]Multiplayer\n[3]Sair");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    campanha();
                    break;
                case 2:
                    lutarMultiplayer();
                    break;
                case 3:
                    break;
            }
        } while (opcao != 3);
    }

    public static void lutarMultiplayer() {
        int vez = 1;
        int opcaoMenuLuta = 0;
        Jogador p1 = null;
        Jogador p2 = null;
        Jogador jogadorAtual = null;
        Jogador jogadorAdversario = null;
        do {

            for (Jogador jogadorE : jogadores) {
                if (jogadorE.id == 1) {
                    p1 = jogadorE;
                } else {
                    p2 = jogadorE;
                }
            }
            if (p1.unidades.size() != 0 || p2.unidades.size() != 0) {
                if (vez == 1) {
                    jogadorAtual = p1;
                    jogadorAdversario = p2;
                } else if (vez == 2) {
                    jogadorAtual = p2;
                    jogadorAdversario = p1;
                }
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
                    if (jogadorAtual.especial >= 3) {
                        jogadorAtual.especial = 0;
                    } else {
                        System.out.println("Especial não carregado");
                        opcaoMenuLuta = 6;
                    }
                }
                switch (opcaoMenuLuta) {
                    case 1:
                        atacarMultiplayer(jogadorAtual, jogadorAdversario);
                        break;
                    case 2:
                        defenderMultiplayer(jogadorAtual);
                        break;
                    case 3:
                        especial(jogadorAtual, jogadorAdversario);
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
                        vez = 0;
                    } else {
                        System.out.println(p1.nome + " Venceu o jogo");
                        vez = 0;
                    }
                    for (Jogador jogador : jogadores) {
                        jogador.unidades.removeIf(Objects::nonNull);
                    }
                }
                if (vez == 1) {
                    vez = 2;
                    p1.especial++;
                } else if (vez == 2) {
                    vez = 1;
                    p2.especial++;
                }
            } else {
                System.out.println("Defina um time antes de lutar");
                vez = 0;
            }


        } while (vez != 0);

    }

    public static void desistir(Jogador jogadorE) {
        jogadorE.unidades.removeIf(Objects::nonNull);
    }

    public static boolean empate() {
        int empate = 0;
        int resposta = 0;
        for (Jogador jogadorEmpate : jogadores) {
            System.out.println(jogadorEmpate.nome + " Aceita o empate?\n[1]Sim\n[2]Não");
            resposta = sc.nextInt();

            if (resposta == 1) {
                empate++;
            }
        }
        if (empate == 2) {
            System.out.println("O jogo terminou empatado");
            for (Jogador jogador : jogadores) {
                jogador.unidades.removeIf(Objects::nonNull);
            }
            return true;
        } else {
            System.out.println("Não houve empate");
            return false;
        }
    }

    public static void menu() {
        int opcao = 0;
        do {
            System.out.println("""
                    [1]Definir Times
                    [2]Mostrar Times
                    [3]Lutar
                    [4]Sair""");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    defineTime();
                    break;
                case 2:
                    mostrarTime();
                    break;
                case 3:
                    modoDeJogo();
                    break;
                case 4:
                    break;
            }
        } while (opcao != 4);

    }

    public static void mostrarTime() {
        for (Jogador jogadorE : jogadores) {
            System.out.println("Time de " + jogadorE.nome + "\n");
            for (Classe a : jogadorE.unidades) {
                System.out.println(a + "\n");
            }
        }
    }

    public static void atacarMultiplayer(Jogador jogadorAtual, Jogador jogadorAdversario) {
        int opcaoParaAtacarEscolhida = 0;
        System.out.println(jogadorAtual.nome + " " + """
                Escolha um personagem para atacar o Adversario""");
        System.out.println(jogadorAtual.unidades);
        int opcao = sc.nextInt();
        for (Classe unidadeEscolhida : jogadorAtual.unidades) {
            if (jogadorAtual.unidades.indexOf(unidadeEscolhida) == opcao) {
                System.out.println("""
                        Quem você deseja atacar\040""" + jogadorAtual.nome);
                System.out.println(jogadorAdversario.unidades);
                opcaoParaAtacarEscolhida = sc.nextInt();
                for (Classe unidadeAdversariaEscolhida : jogadorAdversario.unidades) {
                    if (jogadorAdversario.unidades.indexOf(unidadeAdversariaEscolhida) == opcaoParaAtacarEscolhida) {
                        System.out.println(jogadorAdversario.unidades.indexOf(unidadeAdversariaEscolhida));
                        String saida = unidadeEscolhida.atacar(unidadeAdversariaEscolhida);
                        System.out.println(saida);
                    }
                }
            }


        }
        verificaMorte();
    }

    static public void defenderMultiplayer(Jogador jogadorE) {
        System.out.println("Qual personagem  deseja recuperar a defesa?");
        System.out.println(jogadorE.unidades);
        int opcao = sc.nextInt();
        for (Classe unidadeEscolhida : jogadorE.unidades) {
            if (jogadorE.unidades.indexOf(unidadeEscolhida) == opcao) {
                unidadeEscolhida.defender();
            }
        }

    }

    public static void verificaMorte() {
        int i = 0;
        for (Jogador jogadorE : jogadores) {
            for (Classe unidadeEncontrada : jogadorE.unidades) {
                if (unidadeEncontrada.getVida() <= 0) {
                    jogadorE.unidades.remove(unidadeEncontrada);
                    break;
                }
            }
            recompilar(jogadorE);
        }

    }

    public static void recompilar(Jogador jogadorE) {
        int i = 0;
        for (Classe unidadeSendoRecompilada : jogadorE.unidades) {
            unidadeSendoRecompilada.setId(i);
            i++;
        }
    }

    public static boolean verificaVitoria() {
        for (Jogador jogadorE : jogadores) {
            if (jogadorE.unidades.size() == 0) {
                return true;
            }

        }
        return false;
    }

    public static void especial(Jogador jogadorAtual, Jogador jogadorAdversario) {
        String saida;
        System.out.println(jogadorAtual.nome + " " + """
                Escolha um personagem para usar o especial""");
        System.out.println(jogadorAtual.unidades);
        int opcao = sc.nextInt();
        for (Classe unidadeEscolhida : jogadorAtual.unidades) {
            if (jogadorAtual.unidades.indexOf(unidadeEscolhida) == opcao) {
                if (unidadeEscolhida instanceof Guerreiro || unidadeEscolhida instanceof Ladino) {
                    saida = unidadeEscolhida.especial(unidadeEscolhida);
                    System.out.println(saida);

                } else if (unidadeEscolhida instanceof Mago) {
                    System.out.println(jogadorAtual.nome + " " + """
                            Quem você deseja curar?""");
                    System.out.println(jogadorAtual.unidades);
                    int opcao2 = sc.nextInt();
                    for (Classe unidadeEscolhidaParaCurar : jogadorAtual.unidades) {
                        if (jogadorAtual.unidades.indexOf(unidadeEscolhidaParaCurar) == opcao2) {
                            saida = unidadeEscolhida.especial(unidadeEscolhidaParaCurar);
                            System.out.println(saida);

                        }
                    }

                } else if (unidadeEscolhida instanceof Arqueiro) {
                    System.out.println("""
                            Quem você deseja atacar\040""" + jogadorAtual.nome);
                    System.out.println(jogadorAdversario.unidades);
                    int opcaoAdversariaEscolhida = sc.nextInt();

                    for (Classe unidadeAdversariaEscolhida : jogadorAdversario.unidades) {
                        if (jogadorAdversario.unidades.indexOf(unidadeAdversariaEscolhida) == opcaoAdversariaEscolhida) {
                            saida = unidadeEscolhida.especial(unidadeAdversariaEscolhida);
                            System.out.println(saida);
                        }
                    }

                }
                verificaMorte();
            }
        }

    }

    public static void campanha() {
        System.out.println("defina seu nome");
        String nome = sc.next();
        Jogador p1 = new Jogador(1, nome, 0);
        System.out.println(Historia.parte1());
        Guerreiro guerreiro = new Guerreiro("Kael", 100, 10, 0, 2, 2, 20, 1);
        p1.unidades.add(guerreiro);
        Ladino ladino = new Ladino("Selene", 100, 30, 0, 5, 5, 20, 2);
        p1.unidades.add(ladino);
        Arqueiro arqueiro = new Arqueiro("Lyra", 100, 25, 0, 5, 5, 30, 3);
        p1.unidades.add(arqueiro);
        Mago mago = new Mago("Arin", 100, 20, 0, 10, 2, 25, 4);
        p1.unidades.add(mago);
        System.out.println("Determinados a enfrentar os inimigos, eles entram na batalha");
        nivel1();
    }

    public static ArrayList<Classe> nivel1() {
        Orc orcComum = new Orc("Orc Comum", 50, 10, 0, 2, 2, 0, 0);
        Orc orcDaFloresta = new Orc("Orc da Floresta", 100, 20, 0, 5, 5, 30, 0);
        unidadesAdversarias.clear();
        unidadesAdversarias.add(orcComum);
        unidadesAdversarias.add(orcComum);
        unidadesAdversarias.add(orcDaFloresta);
        return unidadesAdversarias;
    }
}
