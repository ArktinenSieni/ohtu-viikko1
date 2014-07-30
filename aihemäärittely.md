## Disco Tetris

### __Aihe:__ 
 Tarkoituksena tuottaa pulmapeli [Tetris Attackin](http://www.geek-pride.co.uk/wp-content/uploads/2014/03/tetris-attack-04.png) innoittamana. Pelissä nousee ruudukon alalaidasta riveittäin erivärisiä kuutoita. Pelaajan tehtävänä on vaihtaa kahden palikan paikkaa niin,
että saman väriset tuottavat vähintään kolmen vaaka- tai pystyrivejä. Tämän tapahtuessa pelaaja saa pisteitä. Lisäpisteitä saa kun yhdistelmään kuuluu useampi kuin vain kolme palikkaa, tai kun
palikoiden poistaminen saa aikaan toisen vähintään kolmen yhdistelmän. Pelaajalla on käytettävissä vielä toistaiseksi määrittelemätön määrä aikaa, jona aikana hän saa yhdistelmiä tehdä. Pisteiden
lisäksi pelaaja saa myös lisää aikaa. Mitä enemmän aikaa kuluu, sitä tiuhempaan tahtiin palikoita nousee ruuudukon alalaidasta. Peli päättyy joko ajan loppumiseen, tai kun palikat saavuttavat
ruudukon ylälaidan. Pelin loputtua pelaaja näkee pistemääränsä, joka asetetaan highscore listaan.

### __Käyttäjät:__
 Pelaaja

### __Pelaajan toiminnot:__
* Pelin aloittaminen
  * Palikoiden paikan vaihtaminen
  * Valikkoon palaaminen
  * Ennätyksen tallentaminen (pelin loppuessa)
    * Nimen asettaminen ennätykseen
* Highscorelistan tarkastelu
* Pelin lopettaminen

### __Satunnaisia merkintöjä:__
* Ajatuksena on tehdä taulukko, joka periaatteessa on täynnä ~~palikoita~~. Tyhjät kohdat ovat toisin sanoen tyhjiä palikoita.
Taulukosta lienee helppo graafiseen käyttöliittymän lukea pelin tila.
  * palikoiden sijaan ajattelen kuutiot jonkinlaisina valoina. "kuutiot" liikkuvat siten että palikat vaihtavat
keskenään väriä. Eräänlaisia diskovaloja valitsemani nimen mukaan
* Palikoiden logiikka
* Käyttöliittymä
* _Aikalaskuri_
* Highscore-lista
* Vaihtuuko palikoiden paikat kahta vierekkäistä palaa painamalla, vai onnistuukohan kursorin väsääminen innoittavan pelin tyyliin?
* Valitut värit:
  * sininen 1
  * keltainen 2
  * punainen 3
  * violetti 4
  * valkoinen 5
* Tarkastaja
* ~~Gravity~~

