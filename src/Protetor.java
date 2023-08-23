public class Protetor extends Classe{
    public Protetor(String nome, int vida, int dano, int defesa, int chaceCritico, int chanceEsquivar, int especial, int id, Item item) {
        super(nome, vida, dano, defesa, chaceCritico, chanceEsquivar, especial, id, item);
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
