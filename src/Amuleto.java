import java.util.ArrayList;

public class Amuleto extends Item{
    static ArrayList<Amuleto> amuletos = new ArrayList<>();
    public Amuleto(String raridade, String nome) {
        super(raridade, nome);
    }
    private static void devineAmuletos(){
        Amuleto amuletoDeBronze = new Amuleto("Comum","Amuleto de Bronze");
        Amuleto amuletoDePrata = new Amuleto("Incomum","Amuleto de Prata");
        Amuleto amuletoDeOuro = new Amuleto("Rara","Amuleto de Ouro");
        Amuleto amuletoDosMonges = new Amuleto("Épico","Amuleto dos Monges");
        Amuleto amuletoDivino = new Amuleto("Lendário","Amuleto Divino");
        amuletos.add(amuletoDeBronze);
        amuletos.add(amuletoDePrata);
        amuletos.add(amuletoDeOuro);
        amuletos.add(amuletoDosMonges);
        amuletos.add(amuletoDivino);
    }
}
