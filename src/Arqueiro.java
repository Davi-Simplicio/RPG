import java.util.Random;


public class Arqueiro extends Classes{
    Random sc = new Random();

    public Arqueiro(String nome,int vida,int dano, int defesa, int chaceCritico,
                    int chanceEsquivar, int especial, int id) {
        super(nome,vida,dano, defesa, chaceCritico, chanceEsquivar, especial, id);

    }
    @Override
    public String atacar(Classes unidadeAdversariaEscolhida) {

        int numeroAleatorio = sc.nextInt(100);
        if(numeroAleatorio > this.getChanceEsquivar()){
            if(numeroAleatorio > this.getChaceCritico()){
                if(unidadeAdversariaEscolhida.getDefesa()<=0){
                    unidadeAdversariaEscolhida.setVida(unidadeAdversariaEscolhida.getVida() - this.getDano());
                    arrumarDefesa();
                    return this.getNome()+" infringiu "+this.getDano()+" de dano em "+unidadeAdversariaEscolhida.getNome()+
                            " que agora está com "+unidadeAdversariaEscolhida.getVida()+" de vida";
                }else{
                    unidadeAdversariaEscolhida.setDefesa(unidadeAdversariaEscolhida.getDefesa() - this.getDano());
                    arrumarDefesa();
                    return (this.getNome()+" infringiu "+this.getDano()+" de dano em "+unidadeAdversariaEscolhida.getNome()+
                            " que agora está com "+unidadeAdversariaEscolhida.getDefesa()+" de defesa");
                }
            }else{
                if(unidadeAdversariaEscolhida.getDefesa()<=0){
                    unidadeAdversariaEscolhida.setVida(unidadeAdversariaEscolhida.getVida() - this.getDano()*2);
                    arrumarDefesa();
                    return ("Ataque Crítico! "+this.getNome()+" infringiu "+this.getDano()*2+" de dano em "+unidadeAdversariaEscolhida.getNome()+
                            " que agora está com "+unidadeAdversariaEscolhida.getVida()+" de vida");
                }else{
                    unidadeAdversariaEscolhida.setDefesa(unidadeAdversariaEscolhida.getDefesa() - this.getDano()*2);
                    arrumarDefesa();
                    return ("Ataque Crítico! "+this.getNome()+" infringiu "+this.getDano()*2+" de dano em "+unidadeAdversariaEscolhida.getNome()+
                            " que agora está com "+unidadeAdversariaEscolhida.getDefesa()+" de defesa");
                }
            }
        }else{
            return (unidadeAdversariaEscolhida.getNome() + " desviou do ataque");
        }
    }

    @Override
    public String especial(Classes unidadeAdversariaEscolhida) {
        String texto="";
        for (int i = 0; i < 3; i++) {
            if (unidadeAdversariaEscolhida.getDefesa() <= 0) {
                unidadeAdversariaEscolhida.setVida(unidadeAdversariaEscolhida.getVida() - this.getDano());
                arrumarDefesa();
                texto = this.getNome() + " Lançou uma chuva de flechas que causaram " + this.getDano()*3 + " de dano em " + unidadeAdversariaEscolhida.getNome() +
                        " que agora está com " + unidadeAdversariaEscolhida.getVida() + " de vida"+"\n";
            } else {
                unidadeAdversariaEscolhida.setDefesa(unidadeAdversariaEscolhida.getDefesa() - this.getDano());
                arrumarDefesa();
                texto = (this.getNome() + " Lançou uma chuva de flechas que causaram " + this.getDano()*3 + " de dano em " + unidadeAdversariaEscolhida.getNome() +
                        " que agora está com " + unidadeAdversariaEscolhida.getDefesa() + " de defesa" + "\n");
            }
        }
        return texto;
    }


    @Override
    public String toString() {
        return "\n"+"Arqueiro " + super.toString();
    }
}
