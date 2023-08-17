public class Ladino extends Classe{
    public Ladino(String nome,int vida,int dano, int defesa, int chaceCritico,
                  int chanceEsquivar, int especial, int id) {
        super(nome,vida,dano, defesa, chaceCritico, chanceEsquivar, especial, id);
    }


    @Override
    public String especial(Classe unidadeAdversariaEscolhida) {
        this.setChanceEsquivar(this.getChanceEsquivar()+40);
        return ("Sua chance de esquivar aumentou em 40%");
    }

    @Override
    public String defender() {
        {
            if (this.getDefesa()>=100){
                return "Você já está com a defesa máxima";
            }else{
                this.setDefesa(this.getDefesa()+10);;
                return "Você aumentou 25 de escudo";
            }

        }
    }

    @Override
    public String toString() {
        return  "\n"+"Ladino " + super.toString();
    }
}
