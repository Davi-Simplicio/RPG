import java.util.ArrayList;

public class Runa extends Item{
    static ArrayList<Runa>runas = new ArrayList<>();
    public Runa(String raridade, String nome,double chanceDeObter,double valorBuff) {
        super(raridade, nome,chanceDeObter,valorBuff);

    }

        public static void defineRunas(){
        Runa runaDaforca = new Runa("Comum","Runa da Força",getChanceDeComum()-getChanceDeIncomum(),20);
        Runa runaPura = new Runa("Incomum","Runa da Força",getChanceDeIncomum()-getChanceDeRaro(),35);
        Runa runaDoMinotauro = new Runa("Raro","Runa do Minotauro",getChanceDeRaro()-getChanceDeEpico(),60);
        Runa runaDoRei = new Runa("Épico","Runa do Rei",getChanceDeEpico()-getChanceDeLendario(),75);
        Runa runaDeAres = new Runa("Lendário","Runa de Ares",getChanceDeLendario(),110);

        runas.add(runaDaforca);
        runas.add(runaPura);
        runas.add(runaDoMinotauro);
        runas.add(runaDoRei);
        runas.add(runaDeAres);
    }

    @Override
    public String toString() {
        return "Runa{} " + super.toString();
    }
}
