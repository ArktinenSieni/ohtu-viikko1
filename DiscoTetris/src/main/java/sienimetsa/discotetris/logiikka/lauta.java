package sienimetsa.discotetris.logiikka;

public class lauta {

    private palikka[][] areena;

    public lauta() {
        areena = new palikka[5][12];

    }

    public void tyhjenna() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 5; j++) {
                this.areena[i][j].setVari(0);

            }
        }
    }

    public void generoiAloitus() {
        for (int i = 1; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                this.areena[i][j].arvoVari();
            }
        }
    }

    public void generoiUusiRivi() {
        for (int i = 0; i < 5; i++) {
            this.areena[i][0].arvoVari();
        }
    }

    public void pudotaPystyrivi(int vaaka) {
        int tyhjienMaara = 0;
        int pysty = 1;
        
        while (areena[vaaka][pysty].getVari() == 0 && pysty < 12) {
            tyhjienMaara ++;
            pysty ++;
        }
        
        for (int i = 1; i <= 12 - tyhjienMaara; i++) {
            this.areena[vaaka][i].vaihdaVareja(this.areena[vaaka][i + tyhjienMaara]);
        }
        
    }

    public void painoFakinVoima() {
        for (int vaaka = 0; vaaka < 5; vaaka++) {
            pudotaPystyrivi(vaaka);
        }
    }

}
