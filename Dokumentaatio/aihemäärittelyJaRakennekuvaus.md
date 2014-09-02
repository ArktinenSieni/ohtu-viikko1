#__ Disco Tetris__

##__Aihe:__ 
 Tarkoituksena tuottaa pulmapeli [Tetris Attackin](http://www.geek-pride.co.uk/wp-content/uploads/2014/03/tetris-attack-04.png) innoittamana. 
Pelissä nostetaan ruudukon alalaidasta riveittäin erivärisiä kuutoita. Pelaajan tehtävänä on vaihtaa kahden palikan paikkaa niin,
että saman väriset tuottavat vähintään kolmen kuution vaaka- tai pystyrivejä. Tämän tapahtuessa pelaaja saa pisteitä ja lisää aikaa. Poistattaessa
onnistuneesti 3-4 kuutiota, saa pelaaja 100 pistettä kuutiota kohden, ja yhden lisäsekunnin. 5-6 kuutiota, 300/kuutio ja kaksi sekuntia, ja 
näitä suuremmissa 500/kuutio ja 3 lisäsekuntia. Pelaajalla on käytettävissä pelin alkaessa kaksi minuuttia aikaa. Pelaaja voi nostaa rivi kerrallaan
kuutioita. Vaihtoehtoisesti kuutiorivit nousevat tietyin aikavälein. Aikaväli pienenee ajan edetessä. Pelin alkaessa kuutiot nousevat kerran
kymmenessä sekunnissa, kun taas kahden minuutin kohdalla kerran kahden sekunnin välein. Peli päättyy ajan loppuessa tai jos kuutiot nousevat 
yli pelialueen. Pelin päättyessä pisteet lisätään listaan, ja peli alkaa alusta.

###__Käyttäjät:__
 Pelaaja

###__Pelaajan toiminnot:__
* Palikoiden paikan vaihtaminen
* Palikkarivin nostaminen
* Pelin uudelleen aloittaminen

##__Rakennekuvaus__

###__Logiikka__
Pelin logiikka kiteytyy Lauta-luokan ympärille. Se hallinnoi ja pitää yllä tietoa Palikka-olioista. Kursorin tarkoituksena on tarjota metodit
Näppäimistönkuuntelijan, eli siis pelaajan käyttöön. Se vaihtaa palikoiden värejä Laudalla. Tarkastajan tehtävänä on tarkastaa mm. mahdolliset
poistettavat kuutiot, ja tarkastaa ylimmän rivin, eli ns. pelin loppumista merkitsevän rivin sisältö.

###__Peli__
Discopeli pyörittää pelin logiikkaa, ja kokoaa logiikan metodit käyttöliittymän tarpeisiin. Lisäksi Peli-pakettiin kuuluu Pisteytys ja 
Tiedostonlukija. Pisteytys olio pitää muistissa pisteitä ja hallinnoi pelin aikaa. Tiedostonlukijan tehtävänä on lukea high-score-lista ja 
tallentaa pisteet jokaisen pelin päätyttyä.

###__Käyttöliittymä__
Käyttöliittymä luo ja alustaa ikkunan. Näppäimistönkuuntelija ottaa vastaan pelaajan antamat komennot. Piirtoalustan tehtävänä on piirtää
pelilauta kuutioineen, sivupalkki sekä itse kursori. 


