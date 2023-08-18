import java.util.ArrayList;

public abstract class Item {
    String raridade;
    String nome;
    double chanceDeObter;
    double valorBuff;
    private int chanceDeComum = 50;
    private int chanceDeIncomum = 25;
    private int chanceDeRaro = 15;
    private int chanceDeEpico = 7;
    private int chanceDeLendario = 3;

    public Item(String raridade, String nome,double chanceDeObter,double valorBuff) {
        this.raridade = raridade;
        this.nome = nome;
        this.chanceDeObter = chanceDeObter;
        this.valorBuff = valorBuff;
    }

    public double getChanceDeObter() {
        return chanceDeObter;
    }

    public void setChanceDeObter(double chanceDeObter) {
        this.chanceDeObter = chanceDeObter;
    }

    public double getValorBuff() {
        return valorBuff;
    }

    public void setValorBuff(double valorBuff) {
        this.valorBuff = valorBuff;
    }

    public String getRaridade() {
        return raridade;
    }

    public String getNome() {
        return nome;
    }

    public int getChanceDeComum() {
        return chanceDeComum;
    }

    public void setChanceDeComum(int chanceDeComum) {
        this.chanceDeComum = chanceDeComum;
    }

    public int getChanceDeIncomum() {
        return chanceDeIncomum;
    }

    public void setChanceDeIncomum(int chanceDeIncomum) {
        this.chanceDeIncomum = chanceDeIncomum;
    }

    public int getChanceDeRaro() {
        return chanceDeRaro;
    }

    public void setChanceDeRaro(int chanceDeRaro) {
        this.chanceDeRaro = chanceDeRaro;
    }

    public int getChanceDeEpico() {
        return chanceDeEpico;
    }

    public void setChanceDeEpico(int chanceDeEpico) {
        this.chanceDeEpico = chanceDeEpico;
    }

    public int getChanceDeLendario() {
        return chanceDeLendario;
    }

    public void setChanceDeLendario(int chanceDeLendario) {
        this.chanceDeLendario = chanceDeLendario;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                "raridade='" + raridade + '\'' +
                "chanceDeObter=" + chanceDeObter +
                "valorBuff=" + valorBuff +
                '}';
    }
}
