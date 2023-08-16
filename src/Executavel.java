
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Executavel {
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<Jogador> jogadores = new ArrayList<>();

    public static void main(String[] args) {
        cadastraUsuario();
    }

    public static Classes escolhaDeAtaque() {

        return null;
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

    public static void lutar() {
        int vez = 1;
        int opcaoMenuLuta = 0;
        Jogador p1 = null;
        Jogador p2 = null;
        Jogador jogadorAtual = null;
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
                } else if (vez == 2) {
                    jogadorAtual = p2;
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
                        atacarMain(jogadorAtual);
                        break;
                    case 2:
                        defenderMain(jogadorAtual);
                        break;
                    case 3:
                        especial(jogadorAtual);
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
                        break;
                    } else {
                        System.out.println(p1.nome + " Venceu o jogo");
                        vez = 0;
                        break;
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
                    lutar();
                    break;
                case 4:
                    break;
            }
        } while (opcao != 4);

    }

    public static void mostrarTime() {
        for (Jogador jogadorE : jogadores) {
            System.out.println("Time de " + jogadorE.nome + "\n");
            for (Classes a : jogadorE.unidades) {
                System.out.println(a + "\n");
            }
        }
    }

    public static void atacarMain(Jogador jogadorE) {
        System.out.println(jogadorE.nome + " " + """
                Escolha um personagem para atacar o Adversario""");
        System.out.println(jogadorE.unidades);
        int opcao = sc.nextInt();
        for (Classes unidadeEscolhida : jogadorE.unidades) {
            if (jogadorE.unidades.indexOf(unidadeEscolhida) == opcao) {
                System.out.println("""
                        Quem você deseja atacar\040""" + jogadorE.nome);
                if (jogadorE.id == 1) {
                    for (Jogador jogadorE2 : jogadores) {
                        if (jogadorE2.id == 2) {
                            System.out.println(jogadorE2.unidades);
                        }
                    }
                } else if (jogadorE.id == 2) {
                    for (Jogador jogadorE2 : jogadores) {
                        if (jogadorE2.id == 1) {
                            System.out.println(jogadorE2.unidades);
                        }

                    }
                }
                int opcaoAdversariaEscolhida = sc.nextInt();
                if (jogadorE.id == 1) {
                    for (Jogador jogadorE2 : jogadores) {
                        if (jogadorE2.id == 2) {
                            for (Classes unidadeAdversariaEscolhida : jogadorE2.unidades) {
                                if (jogadorE2.unidades.indexOf(unidadeAdversariaEscolhida) == opcaoAdversariaEscolhida) {
                                    String saida = unidadeEscolhida.atacar(unidadeAdversariaEscolhida);
                                    System.out.println(saida);

                                }
                            }
                        }
                    }
                } else if (jogadorE.id == 2) {
                    for (Jogador jogadorE2 : jogadores) {
                        if (jogadorE2.id == 1) {
                            for (Classes unidadeAdversariaEscolhida : jogadorE2.unidades) {
                                if (jogadorE2.unidades.indexOf(unidadeAdversariaEscolhida) == opcaoAdversariaEscolhida) {
                                    String saida = unidadeEscolhida.atacar(unidadeAdversariaEscolhida);
                                    System.out.println(saida);
                                }
                            }
                        }
                    }
                }
            }
            verificaMorte();
        }
    }

    static public void defenderMain(Jogador jogadorE) {
        System.out.println("Qual personagem  deseja recuperar a defesa?");
        System.out.println(jogadorE.unidades);
        int opcao = sc.nextInt();
        for (Classes unidadeEscolhida : jogadorE.unidades) {
            if (jogadorE.unidades.indexOf(unidadeEscolhida) == opcao) {
                unidadeEscolhida.defender();
            }
        }

    }

    public static void verificaMorte() {
        int i = 0;
        for (Jogador jogadorE : jogadores) {
            for (Classes unidadeEncontrada : jogadorE.unidades) {
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
        for (Classes unidadeSendoRecompilada : jogadorE.unidades) {
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

    public static void especial(Jogador jogadorAtual) {
        String saida;
        System.out.println(jogadorAtual.nome + " " + """
                Escolha um personagem para usar o especial""");
        System.out.println(jogadorAtual.unidades);
        int opcao = sc.nextInt();
        for (Classes unidadeEscolhida : jogadorAtual.unidades) {
            if (jogadorAtual.unidades.indexOf(unidadeEscolhida) == opcao) {
                if (unidadeEscolhida instanceof Guerreiro || unidadeEscolhida instanceof Ladino) {
                    saida = unidadeEscolhida.especial(unidadeEscolhida);
                    System.out.println(saida);

                } else if (unidadeEscolhida instanceof Mago) {
                    System.out.println(jogadorAtual.nome + " " + """
                            Quem você deseja curar?""");
                    System.out.println(jogadorAtual.unidades);
                    int opcao2 = sc.nextInt();
                    for (Classes unidadeEscolhidaParaCurar : jogadorAtual.unidades) {
                        if (jogadorAtual.unidades.indexOf(unidadeEscolhidaParaCurar) == opcao2) {
                            saida = unidadeEscolhida.especial(unidadeEscolhidaParaCurar);
                            System.out.println(saida);

                        }
                    }

                } else if (unidadeEscolhida instanceof Arqueiro) {
                    System.out.println("""
                            Quem você deseja atacar\040""" + jogadorAtual.nome);
                    if (jogadorAtual.id == 1) {
                        for (Jogador jogadorE2 : jogadores) {
                            if (jogadorE2.id == 2) {
                                System.out.println(jogadorE2.unidades);
                            }
                        }
                    } else if (jogadorAtual.id == 2) {
                        for (Jogador jogadorE2 : jogadores) {
                            if (jogadorE2.id == 1) {
                                System.out.println(jogadorE2.unidades);
                            }

                        }
                    }
                    int opcaoAdversariaEscolhida = sc.nextInt();
                    if (jogadorAtual.id == 1) {
                        for (Jogador jogadorE2 : jogadores) {
                            if (jogadorE2.id == 2) {
                                for (Classes unidadeAdversariaEscolhida : jogadorE2.unidades) {
                                    if (jogadorE2.unidades.indexOf(unidadeAdversariaEscolhida) == opcaoAdversariaEscolhida) {
                                        saida = unidadeEscolhida.especial(unidadeAdversariaEscolhida);
                                        System.out.println(saida);
                                    }
                                }
                            }
                        }
                    } else if (jogadorAtual.id == 2) {
                        for (Jogador jogadorE2 : jogadores) {
                            if (jogadorE2.id == 1) {
                                for (Classes unidadeAdversariaEscolhida : jogadorE2.unidades) {
                                    if (jogadorE2.unidades.indexOf(unidadeAdversariaEscolhida) == opcaoAdversariaEscolhida) {
                                        saida = unidadeEscolhida.especial(unidadeAdversariaEscolhida);
                                        System.out.println(saida);
                                    }
                                }
                            }
                        }
                    }
                }
                verificaMorte();
            }
        }
    }
}
