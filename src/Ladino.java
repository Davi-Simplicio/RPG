public class Ladino extends Classe{
    public Ladino(int id) {
        super("Ladino", 100, 50, 0, 8, 10, 90, id);
    }
    public Ladino(){
        this(1);
        this.setDefesa(0);
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
        return  "\n"+this.getNome()+" " + super.toString();
    }
}
