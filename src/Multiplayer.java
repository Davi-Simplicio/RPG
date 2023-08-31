import java.util.ArrayList;

public class Multiplayer extends ModoDeJogo {

    @Override
    public ArrayList<Classe> definirUnidades(Usuario jogadorE) {
        for (int i = 0; i <= 2; ) {
            int opcao;
            System.out.println(jogadorE.nome + """ 
                     Escolha um personagem para seu time:
                    [1]Arqueiro
                    [2]Guerreiro
                    [3]Ladino
                    [4]Mago""");
            opcao = sc.nextInt();
            int id = jogadorE.getUnidades().size();
            switch (opcao) {
                case 1:
                    Arqueiro arqueiro = new Arqueiro(id);
                    jogadorE.getUnidades().add(arqueiro);
                    break;
                case 2:
                    Guerreiro guerreiro = new Guerreiro(id);
                    jogadorE.getUnidades().add(guerreiro);
                    break;
                case 3:
                    Ladino ladino = new Ladino(id);
                    jogadorE.getUnidades().add(ladino);
                    break;
                case 4:
                    Mago mago = new Mago(id);
                    jogadorE.getUnidades().add(mago);
                    break;
            }
        }
    }

    @Override
    public void menu() {
        int opcao;
        do {
            System.out.println("""
                    [1]Mostrar Times
                    [2]Lutar
                    [3]Sair""");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    mostrarTime();
                    break;
                case 2:
                    lutarMultiplayer();
                    break;
                case 3:
                    break;
            }
        } while (opcao != 3);
    }
}
