public class Mago extends Classe{
    public Mago(String nome,int vida,int dano, int defesa, int chaceCritico,
                int chanceEsquivar, int especial, int id,Item item) {
        super(nome,vida,dano, defesa, chaceCritico, chanceEsquivar, especial, id,item);
    }

    

    @Override
    public String especial(Classe unidadeAdversariaEscolhida) {
        int vidaFalta = unidadeAdversariaEscolhida.getVida()-100;
        unidadeAdversariaEscolhida.setVida(unidadeAdversariaEscolhida.getVida()+(-vidaFalta));
        return ("Você curou "+(-vidaFalta) +" em "+ unidadeAdversariaEscolhida.getNome()+ ", Que agora está com vida máxima");
    }
    @Override
    public String defender() {
        {
            if (this.getDefesa()>=100){
                return "Você já está com a defesa máxima";
            }else{
                this.setDefesa(this.getDefesa()+20);;
                return "Você aumentou 25 de escudo";
            }

        }
    }

    @Override
    public String toString() {
        return  "\n"+this.getNome()+" " + super.toString();
    }
}
