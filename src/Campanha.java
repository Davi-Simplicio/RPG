import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Campanha extends ModoDeJogo{
    static Scanner sc = new Scanner(System.in);
    static Random ra = new Random();
    public ArrayList<Classe> unidadesAdversarias = new ArrayList<>();
    private boolean trava;

    public Campanha(boolean trava) {
        this.trava = trava;
    }

    @Override
    public void cadastraJogador(){
        super.cadastraJogador();
        jogadores.add(new Computador());
    }
    public String ataqueAdversarioCampanha(Usuario p1) {
        if (this.unidadesAdversarias.size() != 0 && p1.getUnidadeDeCombate().size() != 0) {
            int numeroDeAdversariosVivos = this.unidadesAdversarias.size();
            int numeroDePersonagensVivos = p1.getUnidadeDeCombate().size();
            int personagemQuevaiatacar = ra.nextInt(numeroDeAdversariosVivos);
            int escolhaParaAtacar = ra.nextInt(numeroDePersonagensVivos);

            for (Classe unidadeInimiga : this.unidadesAdversarias) {
                if (this.unidadesAdversarias.indexOf(unidadeInimiga) == personagemQuevaiatacar) {
                    for (Classe unidadeQueSeraAtacada : p1.getUnidadeDeCombate()) {
                        if (p1.getUnidadeDeCombate().indexOf(unidadeQueSeraAtacada) == escolhaParaAtacar) {
                            String saida = unidadeInimiga.atacar(unidadeQueSeraAtacada);
                            return (saida);
                        }
                    }
                }
            }
        }
        return "";
    }

    public void setTrava(boolean trava) {
        this.trava = trava;
    }

    public boolean isTrava() {
        return trava;
    }

    public void defineItens(){
        defineAmuletos();
        defineArmaduras();
        defineBotas();
        definePergaminhos();
        defineRunas();
    }

    public static void defineAmuletos(){
        Amuleto amuletoDeBronze = new Amuleto("Comum","Amuleto de Bronze",Item.getChanceDeComum()-Item.getChanceDeIncomum(),25);
        Amuleto amuletoDePrata = new Amuleto("Incomum","Amuleto de Prata",Item.getChanceDeIncomum()-Item.getChanceDeRaro(),50);
        Amuleto amuletoDeOuro = new Amuleto("Raro","Amuleto de Ouro",Item.getChanceDeRaro()-Item.getChanceDeEpico(),75);
        Amuleto amuletoDosMonges = new Amuleto("Épico","Amuleto dos Monges",Item.getChanceDeEpico()-Item.getChanceDeLendario(),110);
        Amuleto amuletoDivino = new Amuleto("Lendário","Amuleto Divino",Item.getChanceDeLendario(),200);
        Amuleto.amuletos.add(amuletoDeBronze);
        Amuleto.amuletos.add(amuletoDePrata);
        Amuleto.amuletos.add(amuletoDeOuro);
        Amuleto.amuletos.add(amuletoDosMonges);
        Amuleto.amuletos.add(amuletoDivino);
    }
    public static void defineArmaduras(){
        Armadura armaduraDeBronze = new Armadura("Comum","Armadura De Bronze",Item.getChanceDeComum()-Item.getChanceDeIncomum(),25);
        Armadura armaduraDePrata = new Armadura("Incomum","Armadura De Prata",Item.getChanceDeIncomum()-Item.getChanceDeRaro(),50);
        Armadura armaduraDeOuro = new Armadura("Raro","Armadura De Ouro",Item.getChanceDeRaro()-Item.getChanceDeEpico(),75);
        Armadura armaduraDoProtetor = new Armadura("Épico","Armadura Do Protetor",Item.getChanceDeEpico()-Item.getChanceDeLendario(),110);
        Armadura armaduraDosDeuses = new Armadura("Lendário","Armadura Dos Deuses",Item.getChanceDeLendario(),200);

        Armadura.armaduras.add(armaduraDeBronze);
        Armadura.armaduras.add(armaduraDePrata);
        Armadura.armaduras.add(armaduraDeOuro);
        Armadura.armaduras.add(armaduraDoProtetor);
        Armadura.armaduras.add(armaduraDosDeuses);
    }
    public static void defineBotas(){
        Bota botaDePano = new Bota("Comum","Bota de Pano",Item.getChanceDeComum()-Item.getChanceDeIncomum(),5);
        Bota botaDeMalha = new Bota("Incomum","Bota de malha",Item.getChanceDeIncomum()-Item.getChanceDeRaro(),10);
        Bota botaDeCouro = new Bota("Raro","Bota de Couro",Item.getChanceDeRaro()-Item.getChanceDeEpico(),20);
        Bota botaDeEscamasDeDragao = new Bota("Épico","Bota de Escamas de Dragão",Item.getChanceDeEpico()-Item.getChanceDeLendario(),35);
        Bota botaDeZeus = new Bota("Lendário","Bota de Zeus",Item.getChanceDeLendario(),50);

        Bota.botas.add(botaDePano);
        Bota.botas.add(botaDeMalha);
        Bota.botas.add(botaDeCouro);
        Bota.botas.add(botaDeEscamasDeDragao);
        Bota.botas.add(botaDeZeus);

    }
    public static void definePergaminhos(){
        Pergaminho pergaminhoVelho = new Pergaminho("Comum","Pergaminho Velho",Item.getChanceDeComum()-Item.getChanceDeIncomum(),5);
        Pergaminho pergaminhoDaVerdade = new Pergaminho("Incomum","Pergaminho da Verdade",Item.getChanceDeIncomum()-Item.getChanceDeRaro(),10);
        Pergaminho pergaminhoDoEspirito = new Pergaminho("Raro","Pergaminho do Espirito",Item.getChanceDeRaro()-Item.getChanceDeEpico(),20);
        Pergaminho pergaminhoDoAnciao = new Pergaminho("Épico","Pergaminho do Ancião",Item.getChanceDeEpico()-Item.getChanceDeLendario(),35);
        Pergaminho pergaminhoDaFlorestaNegra = new Pergaminho("Lendário","Pergaminho da Floresta Negra",Item.getChanceDeLendario(),50);

        Pergaminho.pergaminhos.add(pergaminhoVelho);
        Pergaminho.pergaminhos.add(pergaminhoDaVerdade);
        Pergaminho.pergaminhos.add(pergaminhoDoEspirito);
        Pergaminho.pergaminhos.add(pergaminhoDoAnciao);
        Pergaminho.pergaminhos.add(pergaminhoDaFlorestaNegra);
    }
    public static void defineRunas(){
        Runa runaDaforca = new Runa("Comum","Runa da Força",Item.getChanceDeComum()-Item.getChanceDeIncomum(),20);
        Runa runaPura = new Runa("Incomum","Runa da Força",Item.getChanceDeIncomum()-Item.getChanceDeRaro(),35);
        Runa runaDoMinotauro = new Runa("Raro","Runa do Minotauro",Item.getChanceDeRaro()-Item.getChanceDeEpico(),60);
        Runa runaDoRei = new Runa("Épico","Runa do Rei",Item.getChanceDeEpico()-Item.getChanceDeLendario(),75);
        Runa runaDeAres = new Runa("Lendário","Runa de Ares",Item.getChanceDeLendario(),110);

        Runa.runas.add(runaDaforca);
        Runa.runas.add(runaPura);
        Runa.runas.add(runaDoMinotauro);
        Runa.runas.add(runaDoRei);
        Runa.runas.add(runaDeAres);
    }

    @Override
    public ArrayList<Classe> definirUnidades(Usuario jogador) {
        Guerreiro guerreiro = new Guerreiro();
        jogador.getUnidades().add(guerreiro);
        Ladino ladino = new Ladino();
        jogador.getUnidades().add(ladino);
        Arqueiro arqueiro = new Arqueiro();
        jogador.getUnidades().add(arqueiro);
        Mago mago = new Mago();
        jogador.getUnidades().add(mago);
    }

    @Override
    public int menu() {
        int opcao;
        int contador = 0;
        do {
            jogadorAtual.resetaStatus();
            System.out.println("""
                    [1]Ver personagens
                    [2]Ver Inventario
                    [3]Continuar Historia
                    [4]Sair""");
             opcao = sc.nextInt();

        } while (opcao < 1 || opcao > 4 );
        return opcao;
    }

    @Override
    public void executarAcao(int opcao) {
        switch (opcao){
            case 1:
                mostrarTime();
                break;
            case 2:
                verInventario();
                break;
            case 3:
                lutar();
                break;
            case 4:
                break;
        }
    }
}
