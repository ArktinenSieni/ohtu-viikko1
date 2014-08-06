package sienimetsa.discotetris.logiikka;

public class lauta {

    private palikka[][] areena;

    public lauta() {
        areena = new palikka[5][13];

    }

    public palikka[][] getAreena() {
        return areena;
    }
    

    // koko laudan hallinta
    
    public void tyhjenna() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 5; j++) {
                this.areena[i][j].setVari(0);

            }
        }
    }

    public void generoiAloitus() {
        for (int i = 1; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                
                this.areena[j][i].arvoVari();
            }
        }
    }
    

    public void generoiUusiRivi() {
        for (int i = 0; i < 5; i++) {
            this.areena[i][0].arvoVari();
            
            if (this.areena[i][0].getVari() == 0) {
                while (this.areena[i][0].getVari() == 0) {
                    this.areena[i][0].arvoVari();
                }
                
            }
        }
    }

    // palikoiden liikuttaminan
    
    public void pudotaPalikka(int sijaintiVaaka, int sijaintiPysty, int matka) {
        palikka pudotettava = this.areena[sijaintiVaaka][sijaintiPysty];
        
        if ( (sijaintiPysty - matka) <= 1) {
            palikka kohdePaikka = this.areena[sijaintiVaaka][sijaintiPysty - matka];
            pudotettava.vaihdaVareja(kohdePaikka);
        }
    }
}
