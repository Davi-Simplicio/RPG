import java.util.ArrayList;

public class Nivel {
    static ArrayList<Classe>unidadesAdversarias = new ArrayList<>();
    public static ArrayList<Classe> nivel1() {
        Orc orcComum = null;
        Orc orcDaFloresta = null;
        for (int i = 0; i <= 2; i++) {
            if (i == 2) {
                orcDaFloresta = new Orc("Orc da Floresta", 100, 20, 0, 5, 5, 30, i, null);
                unidadesAdversarias.add(orcDaFloresta);
            } else {
                orcComum = new Orc("Orc Comum", 50, 10, 0, 2, 2, 0, i, null);
                unidadesAdversarias.add(orcComum);
            }
        }
        return unidadesAdversarias;
    }
    public static ArrayList<Classe> nivel2() {
        Orc orcComum = null;
        Esqueleto esqueletoComum = null;
        for (int i = 0; i <= 3; i++) {
            if (i == 2 || i==3) {
                esqueletoComum = new Esqueleto("Esqueleto Comum", 50, 30, 0, 10, 10, 30, i, null);
                unidadesAdversarias.add(esqueletoComum);
            } else {
                orcComum = new Orc("Orc Comum", 50, 10, 0, 2, 2, 0, i, null);
                unidadesAdversarias.add(orcComum);
            }
        }
        return unidadesAdversarias;
    }
    public static ArrayList<Classe> nivel3() {
        Esqueleto esqueletoDoPantano = null;
        Orc orcDaFloresta = null;
        for (int i = 0; i <= 1; i++) {
            if (i == 1) {
                orcDaFloresta = new Orc("Orc da Floresta", 100, 20, 0, 5, 5, 30, i, null);
                unidadesAdversarias.add(orcDaFloresta);
            } else {
                esqueletoDoPantano = new Esqueleto("Esqueleto Do Pântano", 100, 40, 0, 15, 15, 0, i, null);
                unidadesAdversarias.add(esqueletoDoPantano);
            }
        }
        return unidadesAdversarias;
    }
    public static ArrayList<Classe> nivel4() {
        Orc orcComum = null;
        Esqueleto esqueletoDoPantano = null;
        for (int i = 0; i <= 3; i++) {
            if (i == 3) {
                esqueletoDoPantano = new Esqueleto("Esqueleto Do Pântano", 100, 40, 0, 15, 15, 0, i, null);
                unidadesAdversarias.add(esqueletoDoPantano);
            } else {
                orcComum = new Orc("Orc Comum", 50, 10, 0, 2, 2, 0, i, null);
                unidadesAdversarias.add(orcComum);
            }
        }
        return unidadesAdversarias;
    }

    public static ArrayList<Classe> nivel5() {
        Esqueleto esqueletoComum = null;
        Orc orcComum = null;
        Orc orcDasMontanhas = null;

        for (int i = 0; i <= 5; i++) {
            if (i == 5) {
                orcDasMontanhas = new Orc("Orc das Montanhas", 150, 50, 0, 10, 0, 0, i, null);
                unidadesAdversarias.add(orcDasMontanhas);
            } else if (i == 1 || i == 2) {
                orcComum = new Orc("Orc Comum", 50, 10, 0, 2, 2, 0, i, null);
                unidadesAdversarias.add(orcComum);
            } else {
                esqueletoComum = new Esqueleto("Esqueleto Comum", 50, 30, 0, 20, 20, 0, i, null);
                unidadesAdversarias.add(esqueletoComum);
            }
        }
        return unidadesAdversarias;
    }

    public static ArrayList<Classe> nivel10() {
        Orc orcDaFloresta = null;
        Esqueleto esqueletoDoPantano = null;
        OrcRei orcRei = null;
        for (int i = 0; i <= 7; i++) {
            if (i == 7) {
                orcRei = new OrcRei("Orc Rei, O devastador", 500, 100, 0, 10, 0, 0, i, null);
                unidadesAdversarias.add(orcRei);
            } else if (i >= 1 && i <= 4) {
                orcDaFloresta = new Orc("Orc da Floresta", 100, 20, 0, 5, 5, 30, i, null);
                unidadesAdversarias.add(orcDaFloresta);
            } else {
                esqueletoDoPantano = new Esqueleto("Esqueleto do Pântano", 100, 30, 0, 20, 20, 0, i, null);
                unidadesAdversarias.add(esqueletoDoPantano);
            }
        }
        return unidadesAdversarias;
    }
}
