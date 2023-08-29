import java.util.ArrayList;

public class Armadura extends Item{
    static  ArrayList<Armadura>armaduras = new ArrayList<>();
    public Armadura(String raridade, String nome,double chanceDeObter,double valorBuff) {
        super(raridade, nome,chanceDeObter,valorBuff);
    }

    @Override
    public String toString() {
        return "Armadura{} " + super.toString();
    }
}
