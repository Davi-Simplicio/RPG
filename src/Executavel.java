import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Executavel {
    static ModoDeJogo jogo;
    static Random ra = new Random();
    static Scanner sc = new Scanner(System.in);
    static Campanha campanha = new Campanha(false);


    public static void main(String[] args) {
        jogo = modoDeJogo();
        jogo.cadastraUsuario();
    }


    public static ModoDeJogo modoDeJogo() {
        int opcao;
        do {
            System.out.println("Você deseja jogar Campanha ou Multiplayer?\n[1]Campanha\n[2]Multiplayer\n[3]Sair");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    return new Campanha();
                case 2:
                    return new Multiplayer();
                case 3:
                    System.exit(0);
            }
        } while (true);
    }

    public static void mostrarTime() {
        for (Usuario jogadorE : jogadores) {
            System.out.println("Time de " + jogadorE.nome + "\n");
            for (Classe unidade : jogadorE.getUnidades()) {
                System.out.println(unidade + "\n");
            }
        }
    }

    public static void lutarMultiplayer() {
        int vez = 1;
        int opcaoMenuLuta;
        Usuario p1 = null;
        Usuario p2 = null;
        Usuario jogadorAtual = null;
        Usuario jogadorAdversario = null;
        do {

            for (Usuario jogadorE : jogadores) {
                if (jogadorE.id == 1) {
                    p1 = jogadorE;
                } else {
                    p2 = jogadorE;
                }
            }
            if (p1.getUnidades().size() != 0 || p2.getUnidades().size() != 0) {
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
                    for (Usuario jogador : jogadores) {
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
            } else {
                System.out.println("Defina um time antes de lutar");
                vez = 0;
            }


        } while (vez != 0);

    }

    public static void desistir(Usuario jogadorE) {
        jogadorE.getUnidades().removeIf(Objects::nonNull);
    }

    public static boolean empate() {
        int empate = 0;
        int resposta;
        for (Usuario jogadorEmpate : jogadores) {
            System.out.println(jogadorEmpate.nome + " Aceita o empate?\n[1]Sim\n[2]Não");
            resposta = sc.nextInt();

            if (resposta == 1) {
                empate++;
            }
        }
        if (empate == 2) {
            System.out.println("O jogo terminou empatado");
            for (Usuario jogador : jogadores) {
                jogador.getUnidades().removeIf(Objects::nonNull);
            }
            return true;
        } else {
            System.out.println("Não houve empate");
            return false;
        }
    }


    public static boolean atacar(Usuario jogadorAtual, ArrayList<Classe> unidadesAdversarias) {
        int opcaoParaAtacarEscolhida;
        boolean escolherAtaqueBoolean = false;
        Classe personagemMorto = null;
        System.out.println(jogadorAtual.nome + " " + """
                Escolha um personagem para atacar o Adversario""");
        System.out.println(jogadorAtual.getUnidades());
        int opcao = sc.nextInt();
        for (Classe unidadeEscolhida : jogadorAtual.getUnidades()) {
            if (unidadeEscolhida.getId() == opcao) {
                do {
                    System.out.println("""
                            Quem você deseja atacar\040""" + jogadorAtual.nome);
                    System.out.println(unidadesAdversarias);
                    opcaoParaAtacarEscolhida = sc.nextInt();
                    for (Classe unidadeAdversariaEscolhida : unidadesAdversarias) {
                        if (unidadeAdversariaEscolhida.getId() == opcaoParaAtacarEscolhida) {
                            String saida = unidadeEscolhida.atacar(unidadeAdversariaEscolhida);
                            System.out.println(saida);
                            if (unidadeAdversariaEscolhida.getVida() == 0) {
                                personagemMorto = unidadeAdversariaEscolhida;
                            }
                            escolherAtaqueBoolean = true;
                        }

                    }
                } while (!escolherAtaqueBoolean);
                if (personagemMorto != null) {
                    unidadesAdversarias.remove(personagemMorto);
                }
                return true;
            }
        }
        verificaMorte();
        return false;
    }

    static public void defender(Usuario jogadorAtual) {
        System.out.println("Qual personagem  deseja recuperar a defesa?");
        System.out.println(jogadorAtual.getUnidades());
        int opcao = sc.nextInt();
        for (Classe unidadeEscolhida : jogadorAtual.getUnidades()) {
            if (jogadorAtual.getUnidades().indexOf(unidadeEscolhida) == opcao) {
                unidadeEscolhida.defender();
            }
        }

    }

    public static void verificaMorte() {
        for (Usuario jogadorE : jogadores) {
            for (Classe unidadeEncontrada : jogadorE.getUnidades()) {
                if (unidadeEncontrada.getVida() <= 0) {
                    jogadorE.getUnidades().remove(unidadeEncontrada);
                    break;
                }
            }
        }
    }
    public static boolean verificaVitoria() {
        for (Usuario jogadorE : jogadores) {
            if (jogadorE.getUnidades().size() == 0) {
                return true;
            }

        }
        return false;
    }

    public static void especial(Usuario jogadorAtual, ArrayList<Classe> unidadesAdversarias) {
        Classe personagemMorto = null;
        String saida;
        System.out.println(jogadorAtual.nome + " " + """
                Escolha um personagem para usar o especial""");
        System.out.println(jogadorAtual.getUnidades());
        int opcao = sc.nextInt();
        for (Classe unidadeEscolhida : jogadorAtual.getUnidades()) {
            if (jogadorAtual.getUnidades().indexOf(unidadeEscolhida) == opcao) {
                if (unidadeEscolhida instanceof Guerreiro || unidadeEscolhida instanceof Ladino) {
                    saida = unidadeEscolhida.especial(unidadeEscolhida);
                    System.out.println(saida);

                } else if (unidadeEscolhida instanceof Mago) {
                    System.out.println(jogadorAtual.nome + " " + """
                            Quem você deseja curar?""");
                    System.out.println(jogadorAtual.getUnidades());
                    int opcao2 = sc.nextInt();
                    for (Classe unidadeEscolhidaParaCurar : jogadorAtual.getUnidades()) {
                        if (jogadorAtual.getUnidades().indexOf(unidadeEscolhidaParaCurar) == opcao2) {
                            saida = unidadeEscolhida.especial(unidadeEscolhidaParaCurar);
                            System.out.println(saida);
                        }
                    }
                } else if (unidadeEscolhida instanceof Arqueiro) {
                    System.out.println("""
                            Quem você deseja atacar\040""" + jogadorAtual.nome);
                    System.out.println(unidadesAdversarias);
                    int opcaoAdversariaEscolhida = sc.nextInt();

                    for (Classe unidadeAdversariaEscolhida : unidadesAdversarias) {
                        if (unidadesAdversarias.indexOf(unidadeAdversariaEscolhida) == opcaoAdversariaEscolhida) {
                            saida = unidadeEscolhida.especial(unidadeAdversariaEscolhida);
                            System.out.println(saida);
                            if (unidadeAdversariaEscolhida.getVida() == 0) {
                                personagemMorto = unidadeAdversariaEscolhida;
                            }
                        }
                    }
                    if (personagemMorto != null) {
                        unidadesAdversarias.remove(personagemMorto);
                        recompilar(unidadesAdversarias);
                    }
                }
                verificaMorte();
            }
        }

    }

    public static void campanha() {
        campanha.defineItens();
        cadastraUsuario();
        menuInicialCampanha(p1);

    }

    public static void defineNivel(Usuario jogador, int contador, ArrayList<Classe> unidadesAdversarias) {
        unidadesAdversarias.clear();

        int numeroAleatorio = ra.nextInt(100);
        if (contador > 3 && numeroAleatorio <= 20 && !campanha.isTrava()) {
            salaDeTesouros();
        } else {
            contador++;
            if (contador == 1) {
                unidadesAdversarias.addAll(Nivel.nivel1());
                System.out.println(Historia.parte1());
            } else if (contador == 2) {
                unidadesAdversarias.addAll(Nivel.nivel2());
            } else if (contador == 3) {
                unidadesAdversarias.addAll(Nivel.nivel3());
            } else if (contador == 4) {
                unidadesAdversarias.addAll(Nivel.nivel4());
            } else if (contador == 5) {
                unidadesAdversarias.addAll(Nivel.nivel5());
                System.out.println(Historia.parte2());
            } else if (contador == 6) {
                unidadesAdversarias.addAll(Nivel.nivel6());
            } else if (contador == 7) {
                unidadesAdversarias.addAll(Nivel.nivel7());
            } else if (contador == 8) {
                unidadesAdversarias.addAll(Nivel.nivel8());
            } else if (contador == 9) {
                unidadesAdversarias.addAll(Nivel.nivel9());
            } else if (contador == 10) {
                unidadesAdversarias.addAll(Nivel.nivel10());
                System.out.println(Historia.parte3());
            } else if (contador == 11) {
                System.out.println("Parabens você ganhou");
                jogador.getUnidades().clear();
            }
        }
        menuDeBatalhaCampanha(jogador, campanha.unidadesAdversarias);
    }
    public static void menuDeBatalhaCampanha(Usuario p1, ArrayList<Classe> unidadesAdversarias) {
        p1.getUnidadeDeCombate().clear();
        p1.getUnidadeDeCombate().addAll(p1.getUnidades());
        p1.setEspecial(0);
        boolean salaDeTesourosBoolean = false;
        String especialString = " [̷3̷]̷E̷s̷p̷e̷c̷i̷a̷l̷";
        boolean atacarBoolean = false;
        int opcao;
        if (unidadesAdversarias.get(0) instanceof Protetor) {
            salaDeTesourosBoolean = true;
        }
        do {
            if (p1.getEspecial() >= 3) {
                especialString = ("[3]Especial");
            }
            if (unidadesAdversarias.size() == 0 || p1.getUnidadeDeCombate().size() == 0) {
                break;
            }
            System.out.println("""
                    O que você deseja fazer?
                    [1]Atacar
                    [2]Defender
                    """ + especialString);
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    do {
                        atacarBoolean = atacar(p1, unidadesAdversarias);
                    } while (!atacarBoolean);
                    break;
                case 2:
                    defender(p1);
                    break;
                case 3:
                    if (p1.getEspecial() >= 3) {
                        especial(p1, unidadesAdversarias);
                        p1.setEspecial(0);
                    } else {
                        System.out.println("Especial não carregado");
                    }
                    break;
            }
            p1.setEspecial(p1.getEspecial() + 1);
            System.out.println(campanha.ataqueAdversarioCampanha(p1));
            p1.getUnidadeDeCombate().removeIf(unidade -> unidade.getVida() == 0);
            if (p1.getUnidadeDeCombate().size() == 0) {
                p1.getUnidades().clear();
            }
        } while (unidadesAdversarias.size() != 0 || p1.getUnidadeDeCombate().size() != 0);

        if (salaDeTesourosBoolean) {
            System.out.println("Você foi derrotado Miseravelmente");
            System.out.println("Os quatro amigos encontram muitos baús dentro da masmorra");
            System.out.println(p1.recompensa());
            System.out.println(p1.recompensa());
            System.out.println(p1.recompensa());
            System.out.println(p1.recompensa());
            campanha.setTrava(true);
        } else {
            System.out.println(p1.recompensa());
        }
    }

    private static void mostrarTimeCurto(Usuario jogador) {
        int opcao;
        do {
            for (Classe unidade : jogador.getUnidades()) {
                System.out.println(unidade.toStringCurto());
            }


            System.out.println("Deseja ver detalhes de algum personagem?\n[" + (jogador.getUnidades().size()) + "] Sair");
            opcao = sc.nextInt();
            if (opcao < jogador.getUnidades().size()) {
                System.out.println(jogador.getUnidades().get(opcao) + "\n");
            }
        } while (opcao != jogador.getUnidades().size());

    }

    private static void verInventario(Usuario jogador) {
        int i = 0;

        for (Item item : jogador.getInventario()) {
            System.out.println("[" + i + "] " + item);
            i++;
        }


        System.out.println("""
                Deseja usar algum item em suas unidades?
                [1]Sim
                [2]Não""");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                decideItem(jogador);
                break;
            case 2:
                break;
        }

    }

    public static void decideItem(Usuario jogador) {
        boolean continuar = true;
        Item item;
        Classe unidadeEscolhida;
        do {
            System.out.println("""
                    Escolha um item
                        """);
            int escolhaDeItem = sc.nextInt();
            item = jogador.getInventario().get(escolhaDeItem);
            System.out.println("""
                    Em qual unidade deseja usar este item?""");
            mostrarTime();
            int escolhaDeUnidade = sc.nextInt();
            unidadeEscolhida = jogador.getUnidades().get(escolhaDeUnidade);
            if (unidadeEscolhida.getItem() != null) {
                System.out.println("""
                        Deseja trocar o item já equipado?
                        [1]Sim
                        [2]Não""");
                int opcao = sc.nextInt();
                if (opcao == 1) {
                    jogador.getInventario().add(unidadeEscolhida.getItem());
                    unidadeEscolhida.setItem(item);
                    jogador.getInventario().remove(item);
                } else {
                    continuar = false;
                }
            } else {
                unidadeEscolhida.setItem(item);
                jogador.getInventario().remove(item);
            }
        } while (!continuar);
    }

    public static void salaDeTesouros() {

        System.out.println("""
                Protetor Do Tesouro: Deseja me desafiar?
                Caso você ganhe te dou todo meu Tesouro
                Deseja desafiar o protetor?
                [1]Sim
                [2]Não""");
        int opcao = sc.nextInt();
        if (opcao == 2) {
        } else {
            campanha.unidadesAdversarias.clear();
            Protetor protetor = new Protetor("Protetor Do Tesouro", 500, 50, 0, 10, 10, 0, 0, null);
            campanha.unidadesAdversarias.add(protetor);
        }
    }
}
