import java.util.ArrayList;

public class Pergaminho extends Item{
    static ArrayList<Pergaminho>pergaminhos = new ArrayList<>();
    public Pergaminho(String raridade, String nome,double chanceDeObter,double valorBuff) {
        super(raridade, nome,chanceDeObter,valorBuff);
       ;
    }

    @Override
    public String toString() {
        return "Pergaminho{} " + super.toString();
    }
}
