import java.util.ArrayList;

public class Amuleto extends Item{
    static ArrayList<Amuleto> amuletos = new ArrayList<>();
    public Amuleto(String raridade, String nome,double chanceDeObter,double valorBuff) {
        super(raridade, nome,chanceDeObter,valorBuff);
    }
    public static void defineAmuletos(){
        Amuleto amuletoDeBronze = new Amuleto("Comum","Amuleto de Bronze",50,25);
        Amuleto amuletoDePrata = new Amuleto("Incomum","Amuleto de Prata",25,50);
        Amuleto amuletoDeOuro = new Amuleto("Rara","Amuleto de Ouro",15,75);
        Amuleto amuletoDosMonges = new Amuleto("Épico","Amuleto dos Monges",7,110);
        Amuleto amuletoDivino = new Amuleto("Lendário","Amuleto Divino",3,200);
        amuletos.add(amuletoDeBronze);
        amuletos.add(amuletoDePrata);
        amuletos.add(amuletoDeOuro);
        amuletos.add(amuletoDosMonges);
        amuletos.add(amuletoDivino);
    }

    @Override
    public String toString() {
        return "Amuleto{} " + super.toString();
    }
}
