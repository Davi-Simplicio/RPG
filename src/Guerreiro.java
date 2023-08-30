public class Guerreiro extends Classe {
    public Guerreiro(int id) {
        super("Guerreiro", 100, 10, 50, 2, 1, 100, id);
    }
    public Guerreiro(){
        this(0);
        this.setDefesa(0);
    }


    public String especial(Classe unidadeEscolhida){
        this.setDano(this.getDano()+10);
        this.setChaceCritico(this.getChaceCritico()+50);
        return "Sua chance de ataque critico aumentou em 50% e seu dano foi aumentado para "+getDano()*2;
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
