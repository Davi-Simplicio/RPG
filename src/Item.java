import java.util.ArrayList;

public abstract class Item {
    private String raridade;
    private String nome;
    private double chanceDeObter;
    private double valorBuff;
    private static int chanceDeComum = 100;
    private static int chanceDeIncomum = 50;
    private static int chanceDeRaro = 25;
    private static int chanceDeEpico = 10;
    private static int chanceDeLendario = 3;

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

    public static int getChanceDeComum() {
        return chanceDeComum;
    }

    public static void setChanceDeComum(int chance) {
        chanceDeComum = chance;
    }

    public static int getChanceDeIncomum() {
        return chanceDeIncomum;
    }

    public static void setChanceDeIncomum(int chance) {
        chanceDeIncomum = chance;
    }

    public static int getChanceDeRaro() {
        return chanceDeRaro;
    }

    public static void setChanceDeRaro(int chance) {
        chanceDeRaro = chance;
    }

    public static int getChanceDeEpico() {
        return chanceDeEpico;
    }

    public static void setChanceDeEpico(int chance) {
        chanceDeEpico = chance;
    }

    public static int getChanceDeLendario() {
        return chanceDeLendario;
    }



    public static void setChanceDeLendario(int chance) {
        chanceDeLendario = chance;
    }

    @Override
    public String toString() {
        return nome + '\'' +
               raridade + '\'' +
                " chanceDeObter=" + chanceDeObter +
                " valorBuff=" + valorBuff;
    }
}
