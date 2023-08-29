import java.util.ArrayList;

public class Runa extends Item{
    static ArrayList<Runa>runas = new ArrayList<>();
    public Runa(String raridade, String nome,double chanceDeObter,double valorBuff) {
        super(raridade, nome,chanceDeObter,valorBuff);

    }

    @Override
    public String toString() {
        return "Runa{} " + super.toString();
    }
}
