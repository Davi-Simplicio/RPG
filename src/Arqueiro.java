import java.util.Random;


public class Arqueiro extends Classe{
    Random sc = new Random();

    public Arqueiro(String nome,int vida,int dano, int defesa, int chaceCritico,
                    int chanceEsquivar, int especial, int id,String item) {
        super(nome,vida,dano, defesa, chaceCritico, chanceEsquivar, especial, id,item);

    }


    @Override
    public String especial(Classe unidadeAdversariaEscolhida) {
        String texto="";
        for (int i = 0; i < 3; i++) {
            if (unidadeAdversariaEscolhida.getDefesa() <= 0) {
                unidadeAdversariaEscolhida.setVida(unidadeAdversariaEscolhida.getVida() - this.getDano());
                arrumarDefesa();
                texto = this.getNome() + " infringiu " + this.getDano() + " de dano em " + unidadeAdversariaEscolhida.getNome() +
                        " que agora está com " + unidadeAdversariaEscolhida.getVida() + " de vida"+"\n";
            } else {
                unidadeAdversariaEscolhida.setDefesa(unidadeAdversariaEscolhida.getDefesa() - this.getDano());
                arrumarDefesa();
                texto = (this.getNome() + " infringiu " + this.getDano() + " de dano em " + unidadeAdversariaEscolhida.getNome() +
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
