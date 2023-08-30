public class Mago extends Classe{
    public Mago(int id) {
        super("Mago", 100, 30, 25, 0, 20, 50, id);
    }
    public Mago(){
        this(3);
        this.setDefesa(0);
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
