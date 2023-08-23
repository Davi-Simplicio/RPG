import java.util.ArrayList;
import java.util.Random;

public class Jogador {
    static Random ra = new Random();
    String nome;
    int id;
    int especial;
    public ArrayList<Classe> unidades = new ArrayList<>();
    public ArrayList<Item>inventario = new ArrayList<>();

    public Jogador(int id, String nome, int especial) {
        this.nome = nome;
        this.id = id;
        this.especial = especial;

    }
    public ArrayList<Classe> getUnidades() {
        return unidades;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getEspecial() {
        return especial;
    }

    public void setEspecial(int especial) {
        this.especial = especial;
    }

    public String recompensa() {
        int itemAleatorio = ra.nextInt(5);
        int recompensaEscolhida = ra.nextInt(100);
        System.out.println(itemAleatorio);
        System.out.println(recompensaEscolhida);
        if (itemAleatorio == 1) {
            System.out.println(Amuleto.amuletos);
            for (Item item : Amuleto.amuletos) {
                if (item.getRaridade().equals(escolhaDeRaridade(recompensaEscolhida, item))) {
                    this.inventario.add(item);
                    return "Você Ganhou " + item.getNome() + "  " + item.getRaridade() + "que tinha " + item.getChanceDeObter() + "% chance de obter";
                }
            }
        } else if (itemAleatorio == 2) {
            System.out.println(Armadura.armaduras);
            for (Item item : Armadura.armaduras) {
                if (item.getRaridade().equals(escolhaDeRaridade(recompensaEscolhida, item))) {
                    this.inventario.add(item);
                    return "Você Ganhou " + item.getNome() + "  " + item.getRaridade() + " que tinha " + item.getChanceDeObter() + "% chance de obter";
                }
            }
        } else if (itemAleatorio == 3) {
            for (Item item : Bota.botas) {
                if (item.getRaridade().equals(escolhaDeRaridade(recompensaEscolhida, item))) {
                    this.inventario.add(item);
                    return "Você Ganhou " + item.getNome() + "  " + item.getRaridade() + " que tinha " + item.getChanceDeObter() + "% chance de obter";
                }
            }
        }else if (itemAleatorio == 4) {
            for (Item item : Pergaminho.pergaminhos) {
                if (item.getRaridade().equals(escolhaDeRaridade(recompensaEscolhida, item))) {
                    this.inventario.add(item);
                    return "Você Ganhou " + item.getNome() + "  " + item.getRaridade() + " que tinha " + item.getChanceDeObter() + "% chance de obter";
                }
            }
        }else{
            for (Item item : Runa.runas) {
                if (item.getRaridade().equals(escolhaDeRaridade(recompensaEscolhida, item))) {
                    this.inventario.add(item);
                    return "Você Ganhou " + item.getNome() + "  " + item.getRaridade() + " que tinha " + item.getChanceDeObter() + "% chance de obter";
                }
            }
        }
        return ("deu errado "+itemAleatorio);
    }

    public String escolhaDeRaridade(int numeroRandom,Item item){
        for (int i = 0; i < 100; i++) {
              if (i<=item.getChanceDeLendario()){
                if (numeroRandom==i){
                    return "Lendário";
                }
            }else  if (i<=item.getChanceDeEpico()){
                  if (numeroRandom==i){
                      return "Épico";
                  }
              }else  if (i<=item.getChanceDeRaro()){
                  if (numeroRandom==i){
                      return "Raro";
                  }
              }else  if (i<=item.getChanceDeIncomum()){
                  if (numeroRandom==i){
                      return "Incomum";
                  }
              }else if (i>=item.getChanceDeComum()){
                if (numeroRandom==i){
                    return "Comum";
                }
            }
        }
        return "";
    }
}
