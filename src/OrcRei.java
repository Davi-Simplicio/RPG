public class OrcRei extends Classe{
    public OrcRei(String nome, int vida, int dano, int defesa, int chaceCritico, int chanceEsquivar, int especial, int id) {
        super(nome, vida, dano, defesa, chaceCritico, chanceEsquivar, especial, id);
    }

    @Override
    public String especial(Classe unidadeAdversariaEscolhida) {
        return null;
    }

    @Override
    public String defender() {
        return null;
    }
}
