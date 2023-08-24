import java.util.ArrayList;

public class Bota extends Item{
    static ArrayList<Bota>botas = new ArrayList<>();


    public Bota(String raridade, String nome, double chanceDeObter, double valorBuff) {
        super(raridade, nome,chanceDeObter,valorBuff);
    }

    public static void defineBotas(){
        Bota botaDePano = new Bota("Comum","Bota de Pano",getChanceDeComum()-getChanceDeIncomum(),5);
        Bota botaDeMalha = new Bota("Incomum","Bota de malha",getChanceDeIncomum()-getChanceDeRaro(),10);
        Bota botaDeCouro = new Bota("Raro","Bota de Couro",getChanceDeRaro()-getChanceDeEpico(),20);
        Bota botaDeEscamasDeDragao = new Bota("Épico","Bota de Escamas de Dragão",getChanceDeEpico()-getChanceDeLendario(),35);
        Bota botaDeZeus = new Bota("Lendário","Bota de Zeus",getChanceDeLendario(),50);

        botas.add(botaDePano);
        botas.add(botaDeMalha);
        botas.add(botaDeCouro);
        botas.add(botaDeEscamasDeDragao);
        botas.add(botaDeZeus);

    }

    @Override
    public String toString() {
        return "Bota{} " + super.toString();
    }
}
