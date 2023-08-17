import java.util.Random;

import java.util.Random;

public abstract class Classe {
    Random sc = new Random();
    private String nome;
    private int vida;
    private int dano;
    private int defesa;
    private int chaceCritico;
    private int chanceEsquivar;
    private int id;
    private int especial;

    public Classe(String nome, int vida, int dano, int defesa, int chaceCritico,
                  int chanceEsquivar, int especial, int id) {
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

    public int getId() {
        return id;
    }

    public void setChaceCritico(int chaceCritico) {
        this.chaceCritico = chaceCritico;
    }

    public void setChanceEsquivar(int chanceEsquivar) {
        this.chanceEsquivar = chanceEsquivar;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String atacar(Classe unidadeAdversariaEscolhida) {

        int numeroAleatorio = sc.nextInt(100);
        if (numeroAleatorio > this.getChanceEsquivar()) {
            if (numeroAleatorio > this.getChaceCritico()) {
                if (unidadeAdversariaEscolhida.getDefesa() <= 0) {
                    unidadeAdversariaEscolhida.setVida(unidadeAdversariaEscolhida.getVida() - this.getDano());
                    arrumarDefesa();
                    return this.getNome() + " infringiu " + this.getDano() + " de dano em " + unidadeAdversariaEscolhida.getNome() +
                            " que agora está com " + unidadeAdversariaEscolhida.getVida() + " de vida";
                } else {
                    unidadeAdversariaEscolhida.setDefesa(unidadeAdversariaEscolhida.getDefesa() - this.getDano());
                    arrumarDefesa();
                    return (this.getNome() + " infringiu " + this.getDano() + " de dano em " + unidadeAdversariaEscolhida.getNome() +
                            " que agora está com " + unidadeAdversariaEscolhida.getDefesa() + " de defesa");
                }
            } else {
                if (unidadeAdversariaEscolhida.getDefesa() <= 0) {
                    unidadeAdversariaEscolhida.setVida(unidadeAdversariaEscolhida.getVida() - this.getDano() * 2);
                    arrumarDefesa();
                    return ("Ataque Crítico! " + this.getNome() + " infringiu " + this.getDano() * 2 + " de dano em " + unidadeAdversariaEscolhida.getNome() +
                            " que agora está com " + unidadeAdversariaEscolhida.getVida() + " de vida");
                } else {
                    unidadeAdversariaEscolhida.setDefesa(unidadeAdversariaEscolhida.getDefesa() - this.getDano() * 2);
                    arrumarDefesa();
                    return ("Ataque Crítico! " + this.getNome() + " infringiu " + this.getDano() * 2 + " de dano em " + unidadeAdversariaEscolhida.getNome() +
                            " que agora está com " + unidadeAdversariaEscolhida.getDefesa() + " de defesa");
                }
            }
        } else {
            return (unidadeAdversariaEscolhida.getNome() + " desviou do ataque");
        }
    }

    public abstract String especial(Classe unidadeAdversariaEscolhida);

    public abstract String defender();


    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    @Override
    public String toString() {
        return "[" + id + "]" +
                "vida=" + vida +
                ", dano=" + dano +
                ", defesa=" + defesa +
                ", chaceCritico=" + chaceCritico +
                ", chanceEsquivar=" + chanceEsquivar +
                ", especial=" + especial +
                '}';
    }

    public void arrumarDefesa() {
        for (Jogador jogador : Executavel.jogadores) {
            for (Classe unidade : jogador.unidades) {
                if (unidade.getDefesa() < 0) {
                    unidade.setDefesa(0);
                }
            }
        }

    }

}
