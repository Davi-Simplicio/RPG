public class Guerreiro extends Classe {
    public Guerreiro(String nome,int vida,int dano, int defesa, int chaceCritico,
                     int chanceEsquivar, int especial, int id,Item item) {
        super(nome,vida,dano, defesa, chaceCritico, chanceEsquivar, especial, id,item);
    }


    public String especial(Classe unidadeEscolhida){
        this.setDano(this.getDano()+10);
        this.setChaceCritico(this.getChaceCritico()+100);
        return "Sua chance de ataque critico aumentou em 100% e seu dano foi aumentado para 20";
    }

    @Override
    public String defender() {
        {
            if (this.getDefesa()>=100){
                return "Você já está com a defesa máxima";
            }else{
                this.setDefesa(this.getDefesa()+50);;
                return "Você aumentou 25 de escudo";
            }

        }
    }

    @Override
    public String toString() {
        return  "\n"+this.getNome()+" " + super.toString();
    }
}
