package sienimetsa.discotetris.logiikka;

public class lauta {
    private palikka[][] areena;
    
    public lauta() {
        areena = new palikka[6][12];
    }
    
    public void tyhjenna() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                this.areena[i][j].setVari(0);
            }
        }
    }
    
    
}
