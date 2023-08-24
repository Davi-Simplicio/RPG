import java.util.ArrayList;
import java.util.Random;

public class Jogador {
    static Random ra = new Random();
    String nome;
    int id;
    int especial;
    private ArrayList<Classe> unidades = new ArrayList<>();
    private ArrayList<Classe> unidadeDeCombate = new ArrayList<>();
    private ArrayList<Item>inventario = new ArrayList<>();

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

    public ArrayList<Item> getInventario() {
        return inventario;
    }

    public ArrayList<Classe> getUnidadeDeCombate() {
        return unidadeDeCombate;
    }

    public void setInventario(ArrayList<Item> inventario) {
        this.inventario = inventario;
    }

    public String recompensa() {
        int itemAleatorio = ra.nextInt(5);
        int recompensaEscolhida = ra.nextInt(100);
        if (itemAleatorio == 0) {
            for (Item item : Amuleto.amuletos) {
                if (item.getRaridade().equals(escolhaDeRaridade(recompensaEscolhida))) {
                    this.inventario.add(item);
                    return "Você Ganhou " + item.getNome() + "  " + item.getRaridade() + " que tinha " + item.getChanceDeObter() + "% chance de obter " + recompensaEscolhida;
                }
            }
        } else if (itemAleatorio == 1) {
            for (Item item : Armadura.armaduras) {
                if (item.getRaridade().equals(escolhaDeRaridade(recompensaEscolhida))) {
                    this.inventario.add(item);
                    return "Você Ganhou " + item.getNome() + "  " + item.getRaridade() + " que tinha " + item.getChanceDeObter() + "% chance de obter " + recompensaEscolhida;
                }
            }
        } else if (itemAleatorio == 2) {
            for (Item item : Bota.botas) {
                if (item.getRaridade().equals(escolhaDeRaridade(recompensaEscolhida))) {
                    this.inventario.add(item);
                    return "Você Ganhou " + item.getNome() + "  " + item.getRaridade() + " que tinha " + item.getChanceDeObter() + "% chance de obter " + recompensaEscolhida;
                }
            }
        }else if (itemAleatorio == 3) {
            for (Item item : Pergaminho.pergaminhos) {
                if (item.getRaridade().equals(escolhaDeRaridade(recompensaEscolhida))) {
                    this.inventario.add(item);
                    return "Você Ganhou " + item.getNome() + "  " + item.getRaridade() + " que tinha " + item.getChanceDeObter() + "% chance de obter " + recompensaEscolhida;
                }
            }
        }else{
            for (Item item : Runa.runas) {
                if (item.getRaridade().equals(escolhaDeRaridade(recompensaEscolhida))) {
                    this.inventario.add(item);
                    return "Você Ganhou " + item.getNome() + "  " + item.getRaridade() + " que tinha " + item.getChanceDeObter() + "% chance de obter " + recompensaEscolhida;
                }
            }
        }
        return ("deu errado "+itemAleatorio);
    }

    public String escolhaDeRaridade(int numeroRandom){
        for (int i = 0; i <= 100; i++) {
              if (i<=Item.getChanceDeLendario()){
                if (numeroRandom==i){
                    return "Lendário";
                }
            }else  if (i<=Item.getChanceDeEpico()){
                  if (numeroRandom==i){
                      return "Épico";
                  }
              }else  if (i<=Item.getChanceDeRaro()){
                  if (numeroRandom==i){
                      return "Raro";
                  }
              }else  if (i<=Item.getChanceDeIncomum()){
                  if (numeroRandom==i){
                      return "Incomum";
                  }
              }else if (i<=Item.getChanceDeComum()){
                if (numeroRandom==i){
                    return "Comum";
                }
            }
        }
        return "Comum";
    }
    public void resetaStatus() {
        for (Classe unidade : this.getUnidades()) {
            unidade.setDefesa(0);
            unidade.setVida(100);
            if (unidade instanceof Guerreiro) {
                unidade.setDano(10);
                unidade.setChanceEsquivar(2);
                unidade.setChaceCritico(2);
            } else if (unidade instanceof Ladino) {
                unidade.setDano(30);
                unidade.setChaceCritico(5);
                unidade.setChanceEsquivar(5);
            } else if (unidade instanceof Arqueiro) {
                unidade.setDano(25);
                unidade.setChanceEsquivar(5);
                unidade.setChaceCritico(5);
            } else {
                unidade.setDano(20);
                unidade.setChanceEsquivar(2);
                unidade.setChaceCritico(10);
            }
            unidade.defineBuff();
        }
    }
}
