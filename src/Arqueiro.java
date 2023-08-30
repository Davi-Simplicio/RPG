import java.util.Random;


public class Arqueiro extends Classe{
    Random sc = new Random();

    public Arqueiro(int id) {
        super("Arqueiro", 100, 30, 25, 5, 10, 90, id);
    }
    public Arqueiro(){
        this(2);
        this.setDefesa(0);
    }


    @Override
    public String especial(Classe unidadeAdversariaEscolhida) {
        String texto="";
        for (int i = 0; i < 3; i++) {
            if (unidadeAdversariaEscolhida.getDefesa() <= 0) {
                unidadeAdversariaEscolhida.setVida(unidadeAdversariaEscolhida.getVida() - this.getDano());
                arrumarDefesa();
                if (unidadeAdversariaEscolhida.getVida() < 0) {
                    unidadeAdversariaEscolhida.setVida(0);
                }
                texto += this.getNome() + " infringiu " + this.getDano() + " de dano em " + unidadeAdversariaEscolhida.getNome() +
                        " que agora está com " + unidadeAdversariaEscolhida.getVida() + " de vida"+"\n";
            } else {
                unidadeAdversariaEscolhida.setDefesa(unidadeAdversariaEscolhida.getDefesa() - this.getDano());
                arrumarDefesa();
                texto += (this.getNome() + " infringiu " + this.getDano() + " de dano em " + unidadeAdversariaEscolhida.getNome() +
                        " que agora está com " + unidadeAdversariaEscolhida.getDefesa() + " de defesa" + "\n");
            }
        }
        return texto;
    }

    @Override
    public String defender() {
        {
            if (this.getDefesa()>=100){
                return "Você já está com a defesa máxima";
            }else{
                this.setDefesa(this.getDefesa()+25);;
                return "Você aumentou 25 de escudo";
            }

        }
    }


    @Override
    public String toString() {
        return "\n"+this.getNome()+" " + super.toString();
    }
}
