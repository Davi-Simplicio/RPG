import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Campanha {
    static Scanner sc = new Scanner(System.in);
    static Random ra = new Random();
    public ArrayList<Classe> unidadesAdversarias = new ArrayList<>();
    private boolean trava;

    public Campanha(boolean trava) {
        this.trava = trava;
    }

    public String ataqueAdversarioCampanha(Jogador p1) {
        if (this.unidadesAdversarias.size() != 0 && p1.getUnidadeDeCombate().size() != 0) {
            int numeroDeAdversariosVivos = this.unidadesAdversarias.size();
            int numeroDePersonagensVivos = p1.getUnidadeDeCombate().size();
            int personagemQuevaiatacar = ra.nextInt(numeroDeAdversariosVivos);
            int escolhaParaAtacar = ra.nextInt(numeroDePersonagensVivos);

            for (Classe unidadeInimiga : this.unidadesAdversarias) {
                if (this.unidadesAdversarias.indexOf(unidadeInimiga) == personagemQuevaiatacar) {
                    for (Classe unidadeQueSeraAtacada : p1.getUnidadeDeCombate()) {
                        if (p1.getUnidadeDeCombate().indexOf(unidadeQueSeraAtacada) == escolhaParaAtacar) {
                            String saida = unidadeInimiga.atacar(unidadeQueSeraAtacada);
                            return (saida);
                        }
                    }
                }
            }
        }
        return "";
    }

    public void setTrava(boolean trava) {
        this.trava = trava;
    }

    public boolean isTrava() {
        return trava;
    }
}
