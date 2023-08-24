import java.util.ArrayList;

public class Armadura extends Item{
    static  ArrayList<Armadura>armaduras = new ArrayList<>();
    public Armadura(String raridade, String nome,double chanceDeObter,double valorBuff) {
        super(raridade, nome,chanceDeObter,valorBuff);
    }

    public static void defineArmaduras(){
        Armadura armaduraDeBronze = new Armadura("Comum","Armadura De Bronze",getChanceDeComum()-getChanceDeIncomum(),25);
        Armadura armaduraDePrata = new Armadura("Incomum","Armadura De Prata",getChanceDeIncomum()-getChanceDeRaro(),50);
        Armadura armaduraDeOuro = new Armadura("Raro","Armadura De Ouro",getChanceDeRaro()-getChanceDeEpico(),75);
        Armadura armaduraDoProtetor = new Armadura("Épico","Armadura Do Protetor",getChanceDeEpico()-getChanceDeLendario(),110);
        Armadura armaduraDosDeuses = new Armadura("Lendário","Armadura Dos Deuses",getChanceDeLendario(),200);

        armaduras.add(armaduraDeBronze);
        armaduras.add(armaduraDePrata);
        armaduras.add(armaduraDeOuro);
        armaduras.add(armaduraDoProtetor);
        armaduras.add(armaduraDosDeuses);
    }

    @Override
    public String toString() {
        return "Armadura{} " + super.toString();
    }
}
