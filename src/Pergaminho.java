import java.util.ArrayList;

public class Pergaminho extends Item{
    static ArrayList<Pergaminho>pergaminhos = new ArrayList<>();
    public Pergaminho(String raridade, String nome,double chanceDeObter,double valorBuff) {
        super(raridade, nome,chanceDeObter,valorBuff);
       ;
    }

    public static void definePergaminhos(){
        Pergaminho pergaminhoVelho = new Pergaminho("Comum","Pergaminho Velho",getChanceDeComum()-getChanceDeIncomum(),5);
        Pergaminho pergaminhoDaVerdade = new Pergaminho("Incomum","Pergaminho da Verdade",getChanceDeIncomum()-getChanceDeRaro(),10);
        Pergaminho pergaminhoDoEspirito = new Pergaminho("Raro","Pergaminho do Espirito",getChanceDeRaro()-getChanceDeEpico(),20);
        Pergaminho pergaminhoDoAnciao = new Pergaminho("Épico","Pergaminho do Ancião",getChanceDeEpico()-getChanceDeLendario(),35);
        Pergaminho pergaminhoDaFlorestaNegra = new Pergaminho("Lendário","Pergaminho da Floresta Negra",getChanceDeLendario(),50);

        pergaminhos.add(pergaminhoVelho);
        pergaminhos.add(pergaminhoDaVerdade);
        pergaminhos.add(pergaminhoDoEspirito);
        pergaminhos.add(pergaminhoDoAnciao);
        pergaminhos.add(pergaminhoDaFlorestaNegra);
    }

    @Override
    public String toString() {
        return "Pergaminho{} " + super.toString();
    }
}
