import java.util.ArrayList;

public class Pergaminho extends Item{
    static ArrayList<Item>pergaminhos = new ArrayList<>();
    public Pergaminho(String raridade, String nome,double chanceDeObter,double valorBuff) {
        super(raridade, nome,chanceDeObter,valorBuff);
        definePergaminhos();
    }

    private static void definePergaminhos(){
        Pergaminho pergaminhoVelho = new Pergaminho("Comum","Pergaminho Velho",50,5);
        Pergaminho pergaminhoDaVerdade = new Pergaminho("Incomum","Pergaminho da Verdade",25,10);
        Pergaminho pergaminhoDoEspirito = new Pergaminho("Raro","Pergaminho do Espirito",15,20);
        Pergaminho pergaminhoDoAnciao = new Pergaminho("Épico","Pergaminho do Ancião",7,35);
        Pergaminho pergaminhoDaFlorestaNegra = new Pergaminho("Lendário","Pergaminho da Floresta Negra",3,50);

        pergaminhos.add(pergaminhoVelho);
        pergaminhos.add(pergaminhoDaVerdade);
        pergaminhos.add(pergaminhoDoEspirito);
        pergaminhos.add(pergaminhoDoAnciao);
        pergaminhos.add(pergaminhoDaFlorestaNegra);
    }

}
