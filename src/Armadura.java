import java.util.ArrayList;

public class Armadura extends Item{
    static  ArrayList<Item>armaduras = new ArrayList<>();
    public Armadura(String raridade, String nome,double chanceDeObter,double valorBuff) {
        super(raridade, nome,chanceDeObter,valorBuff);
        defineArmaduras();
    }

    private static void defineArmaduras(){
        Armadura armaduraDeBronze = new Armadura("Comum","Armadura De Bronze",50,25);
        Armadura armaduraDePrata = new Armadura("Incomum","Armadura De Prata",25,50);
        Armadura armaduraDeOuro = new Armadura("Raro","Armadura De Ouro",15,75);
        Armadura armaduraDoProtetor = new Armadura("Épico","Armadura Do Protetor",7,110);
        Armadura armaduraDosDeuses = new Armadura("Lendário","Armadura Dos Deuses",3,200);

        armaduras.add(armaduraDeBronze);
        armaduras.add(armaduraDePrata);
        armaduras.add(armaduraDeOuro);
        armaduras.add(armaduraDoProtetor);
        armaduras.add(armaduraDosDeuses);
    }
}
