
import javax.sound.midi.Soundbank;
import java.awt.color.CMMException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Executavel {
    static Random ra = new Random();
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<Jogador> jogadores = new ArrayList<>();
    static Campanha campanha = new Campanha(false);

    public static void main(String[] args) {
        Amuleto.defineAmuletos();
        Armadura.defineArmaduras();
        Bota.defineBotas();
        Pergaminho.definePergaminhos();
        Runa.defineRunas();
        modoDeJogo();
    }

    public static void defineTime() {
        for (Jogador jogadorE : jogadores) {
            if (jogadorE.getUnidades().size() == 0) {
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
                            Arqueiro arqueiro = new Arqueiro("Arqueiro", 100, 30, 25, 5, 10, 90, id, null);
                            jogadorE.getUnidades().add(arqueiro);
                            i++;
                            break;
                        case 2:
                            Guerreiro guerreiro = new Guerreiro("Guerreiro", 100, 10, 50, 2, 1, 100, id, null);
                            jogadorE.getUnidades().add(guerreiro);
                            i++;
                            break;
                        case 3:
                            Ladino ladino = new Ladino("Ladino", 100, 50, 0, 8, 10, 90, id, null);
                            jogadorE.getUnidades().add(ladino);
                            i++;
                            break;
                        case 4:
                            Mago mago = new Mago("Mago", 100, 30, 25, 0, 20, 50, id, null);
                            jogadorE.getUnidades().add(mago);
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
                    cadastraUsuario();
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
                        vez = 0;
                    } else {
                        System.out.println(p1.nome + " Venceu o jogo");
                        vez = 0;
                    }
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
            } else {
                System.out.println("Defina um time antes de lutar");
                vez = 0;
            }


        } while (vez != 0);

    }

    public static void desistir(Jogador jogadorE) {
        jogadorE.getUnidades().removeIf(Objects::nonNull);
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
                jogador.getUnidades().removeIf(Objects::nonNull);
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
                    lutarMultiplayer();
                    break;
                case 4:
                    break;
            }
        } while (opcao != 4);

    }

    public static void mostrarTime() {
        for (Jogador jogadorE : jogadores) {
            System.out.println("Time de " + jogadorE.nome + "\n");
            for (Classe unidade : jogadorE.getUnidades()) {
                System.out.println(unidade + "\n");
            }
        }
    }

    public static void atacar(Jogador jogadorAtual, ArrayList<Classe> unidadesAdversarias) {
        int opcaoParaAtacarEscolhida = 0;
        Classe personagemMorto = null;
        System.out.println(jogadorAtual.nome + " " + """
                Escolha um personagem para atacar o Adversario""");
        System.out.println(jogadorAtual.getUnidades());
        int opcao = sc.nextInt();
        for (Classe unidadeEscolhida : jogadorAtual.getUnidades()) {
            if (jogadorAtual.getUnidades().indexOf(unidadeEscolhida) == opcao) {
                System.out.println("""
                        Quem você deseja atacar\040""" + jogadorAtual.nome);
                System.out.println(unidadesAdversarias);
                opcaoParaAtacarEscolhida = sc.nextInt();
                for (Classe unidadeAdversariaEscolhida : unidadesAdversarias) {
                    if (unidadesAdversarias.indexOf(unidadeAdversariaEscolhida) == opcaoParaAtacarEscolhida) {
                        System.out.println(unidadesAdversarias.indexOf(unidadeAdversariaEscolhida));
                        String saida = unidadeEscolhida.atacar(unidadeAdversariaEscolhida);
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
        }
        verificaMorte();
    }

    static public void defender(Jogador jogadorAtual) {
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
        int i = 0;
        for (Jogador jogadorE : jogadores) {
            for (Classe unidadeEncontrada : jogadorE.getUnidades()) {
                if (unidadeEncontrada.getVida() <= 0) {
                    jogadorE.getUnidades().remove(unidadeEncontrada);
                    break;
                }
            }
            recompilar(jogadorE.getUnidades());
        }

    }

    public static void recompilar(ArrayList<Classe> unidades) {
        int i = 0;
        for (Classe unidadeSendoRecompilada : unidades) {
            unidadeSendoRecompilada.setId(i);
            i++;
        }
    }

    public static boolean verificaVitoria() {
        for (Jogador jogadorE : jogadores) {
            if (jogadorE.getUnidades().size() == 0) {
                return true;
            }

        }
        return false;
    }

    public static void especial(Jogador jogadorAtual, ArrayList<Classe> unidadesAdversarias) {
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
        System.out.println("defina seu nome");
        String nome = sc.next();
        Jogador p1 = new Jogador(1, nome, 0);
        jogadores.add(p1);
        Guerreiro guerreiro = new Guerreiro("Jay", 100, 10, 0, 2, 2, 20, 0, null);
        p1.getUnidades().add(guerreiro);
        Ladino ladino = new Ladino("Pedro", 100, 30, 0, 5, 5, 20, 1, null);
        p1.getUnidades().add(ladino);
        Arqueiro arqueiro = new Arqueiro("Cleo", 100, 25, 0, 5, 5, 30, 2, null);
        p1.getUnidades().add(arqueiro);
        Mago mago = new Mago("Isa", 100, 20, 0, 10, 2, 25, 3, null);
        p1.getUnidades().add(mago);
        menuInicialCampanha(p1);

    }

    public static void defineNivel(Jogador jogador, int contador, ArrayList<Classe> unidadesAdversarias) {
        unidadesAdversarias.clear();

        int numeroAleatorio = ra.nextInt(100);
        if (contador > 3 && numeroAleatorio < 20 && !campanha.isTrava()) {
            salaDeTesouros(jogador);
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

    public static void menuDeBatalhaCampanha(Jogador p1, ArrayList<Classe> unidadesAdversarias) {
        p1.setEspecial(0);
        String especialString = " [̷3̷]̷E̷s̷p̷e̷c̷i̷a̷l̷";
        int opcao = 0;
        int contador = 2;
        do {
            if (p1.getEspecial() >= 3) {
                especialString = ("[3]Especial");
                contador = 3;
            }
            if (unidadesAdversarias.size() == 0 || p1.getUnidades().size() == 0) {
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
                    atacar(p1, unidadesAdversarias);
                    break;
                case 2:
                    defender(p1);
                    break;
                case 3:
                    if (p1.getEspecial() >= 3) {
                        especial(p1, unidadesAdversarias);
                        contador = 2;
                    } else {
                        System.out.println("Especial não carregado");
                    }
                    break;
            }
            p1.setEspecial(p1.getEspecial() + 1);
            System.out.println(campanha.ataqueAdversarioCampanha(p1));
        } while (unidadesAdversarias.size() != 0 || p1.getUnidades().size() != 0);
        System.out.println(p1.recompensa());
        resetaStatus(p1);
    }

    public static void menuInicialCampanha(Jogador jogador) {
        int opcao = 0;
        int contador = 0;
        do {
            for (Classe unidade : jogador.getUnidades()) {
                    unidade.setVida(100);
                    unidade.defineBuff();
            }
            System.out.println("""
                    [1]Ver personagens
                    [2]Ver Inventario
                    [3]Continuar Historia
                    [4]Sair""");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    mostrarTime();
                    break;
                case 2:
                    if (jogador.getInventario().size() == 0) {
                        System.out.println("Você não possui itens");
                    } else {
                        verInventario(jogador);
                    }
                    break;
                case 3:
                    defineNivel(jogador, contador, campanha.unidadesAdversarias);
                    contador++;
                    break;
                case 4:
                    break;
            }
        } while (opcao != 4 && jogador.getUnidades().size() != 0);
    }

    private static void verInventario(Jogador jogador) {
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

    public static void decideItem(Jogador jogador) {
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
            }else {
                unidadeEscolhida.setItem(item);
                jogador.getInventario().remove(item);
            }
        } while (!continuar);
    }

    public static void salaDeTesouros(Jogador jogador) {

        System.out.println("""
                Protetor Do Tesouro: Deseja me desafiar?
                Caso você ganhe te dou todo meu Tesouro
                Deseja desafiar o protetor?
                [1]Sim
                [2]Não""");
        campanha.unidadesAdversarias.clear();
        Protetor protetor = new Protetor("Protetor Do Tesouro", 500, 50, 0, 10, 10, 0, 0, null);
        campanha.unidadesAdversarias.add(protetor);
        if (protetor.getVida() == 0) {
            jogador.recompensa();
            jogador.recompensa();
            jogador.recompensa();
            jogador.recompensa();
            jogador.recompensa();
            campanha.setTrava(true);
        }
    }

    public static void resetaStatus(Jogador jogador) {
        for (Classe unidade : jogador.getUnidades()) {
            if (unidade instanceof Guerreiro) {
                unidade.setChaceCritico(2);
                unidade.setDano(10);
            } else if (unidade instanceof Ladino) {
                unidade.setChanceEsquivar(5);
            }
        }
    }
}
