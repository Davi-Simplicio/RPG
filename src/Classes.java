
import java.util.Random;

public abstract class Classes {
    Random sc = new Random();
    private String nome;
    private int vida;
    private int dano;
    private int defesa;
    private int chaceCritico;
    private int chanceEsquivar;
    private int id;
    private int especial;

    public Classes(String nome,int vida, int dano, int defesa, int chaceCritico,
                   int chanceEsquivar, int especial,int id) {
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
        this.defesa = defesa;
        this.chaceCritico = chaceCritico;
        this.chanceEsquivar = chanceEsquivar;
        this.especial = especial;
        this.id = id;

    }

    public int getVida() {
        return vida;
    }

    public int getDano() {
        return dano;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getChaceCritico() {
        return chaceCritico;
    }

    public int getChanceEsquivar() {
        return chanceEsquivar;
    }

    public int getEspecial() {
        return especial;
    }

    public int getId(){return id;}

    public void setChaceCritico(int chaceCritico) {
        this.chaceCritico = chaceCritico;
    }

    public void setChanceEsquivar(int chanceEsquivar) {
        this.chanceEsquivar = chanceEsquivar;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public String getNome(){return nome;}

    public void setId(int id){
        this.id = id;
    }


    public abstract String atacar(Classes unidadeAdversariaEscolhida);

    public abstract String especial(Classes unidadeAdversariaEscolhida);

    public void defender() {
        this.setDefesa(this.getDefesa()+25);;
    }


    public void setVida(int vida) {
        if (vida<0){
            vida=0;
        }
        this.vida = vida;
    }

    public void setDefesa(int defesa) {
        if (defesa<0){
            defesa=0;
        }
        this.defesa = defesa;
    }

    @Override
    public String toString() {
        return  "["+id+"]"+
                "vida=" + vida +
                ", dano=" + dano +
                ", defesa=" + defesa +
                ", chaceCritico=" + chaceCritico +
                ", chanceEsquivar=" + chanceEsquivar +
                ", especial=" + especial +
                '}';
    }
    public void arrumarDefesa(){
        for (Jogador jogador:Executavel.jogadores) {
            for (Classes unidade: jogador.unidades){
                if (unidade.getDefesa()<0){
                    unidade.setDefesa(0);
                }
            }
        }

    }


}
