import java.util.ArrayList;

public class Bota extends Item{
    static ArrayList<Bota>botas = new ArrayList<>();


    public Bota(String raridade, String nome, double chanceDeObter, double valorBuff) {
        super(raridade, nome,chanceDeObter,valorBuff);
    }

    @Override
    public String toString() {
        return "Bota{} " + super.toString();
    }
}
