import java.util.ArrayList;

public class Amuleto extends Item{
    static ArrayList<Amuleto> amuletos = new ArrayList<>();
    public Amuleto(String raridade, String nome,double chanceDeObter,double valorBuff) {
        super(raridade, nome,chanceDeObter,valorBuff);
    }

    @Override
    public String toString() {
        return "Amuleto{} " + super.toString();
    }
}
