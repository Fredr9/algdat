# algdat
Oblig2 Algoritmer og datastrukturer.

Denne oppgaven er obligatorisk oppgave 2 i Algoritmer og datastrukturer.

Oppgaven er levert av folgende studenter.

Alex Tran s336111 Fredrik Vogt s315714 Jesper Østervold s341861

Beskrivelse om hvordan oppgavene ble lost;
Vi har samarbeidet på oppgavene, og tatt noe problemløsning hver for oss.


Oppgave 1:
Her har vi brukt en foreach lokke og saa lenge t ikke er null saa oppdateres hode.
videre oppdateres antall og hale hvis naavaende ikke er null.

Oppgave 2:
Her sjekker vi forst om den er tom, hvis den ikke er tom benytter vi oss av StringBuilder til å sette sammen listen til en char liste.
Så lenge hode ikke er null så "omformer" head.verdi til char.

Oppgave 3:
a: Her bruker vi en hjelpe variabel for å sjekke hvilken ende av listen finnNode metoden skal jobbe fra. Hent metoden brukes for å returnere indeksen til noden, og Oppdater metoden brukes returnere verdien til noden.

b: subliste metoden lager og returnerer en liste av verider i en eksisterende liste, de velges startverdi og sluttverdi. metoden gir feilmeldinger for ugyldige verdier.
Verdier blir lagt inn i den nye listen ved hjelp av en while lokke

Oppgave 4:Vi har brukt en if sjekk for å returnere -1 om verdi er null.
Videre sjekker vi om p er lik verdi i en for lokke, og loper gjennom listen, og den returnerer indeks. 


Oppgave 5: Starter med oppgaven med å sjekke etter nullverdier
Deretter sjekker vi storrelse på indeksen og setter ny verdi

Oppgave 6: Koden går gjennom listen etter dersom verdien er null, så vil den bli fjernet. 
Dette gjores da når den har gaatt gjennom hele listen. 


Oppgave 7: Oppgaven ble lost på to forskjellige maater, med en while lokke og en for lokke. While lokken var simpel aa implementere da den kan fjerne indeks 0 så lenge antall ikke er 0. For lokken bruker neste og forrige pekere for å navigere seg gjennom listen for å fjerne noder og sette hode/hale til null. For lokken viste seg å vaare den raskere av de to maatene.

Oppgave 8:Her har vi benyttet oss av en foreach lokke som går igjennom a, hvis t ikke er null saa sjekker gaar man inn og så lenge naavaernde er null så peker naaverende på hode, ellers blir naavernde neste.forrige peker på naavaernde. 
Antall okes.  Hvis naavernede ikke er lik null saa peker hale paa naaverande. 


Oppgave 9:Sjekker forst om endringer og iteratorendringer , ogsa gaar vi gjennom og sjekker over list med de føringene gitt i oppgpavene, og om man kommer igjennom de saa lages det nye noder som peker til null slik at antall blir mindre og endring/iteratorendrigner oker. 

Oppgave 10:Her har vi forst en if test for å sjekke at antall er storre enn 1, hvis den er det gaar den videre
Videre brukes en for lokke(og vi benytter oss av bubble sort) for å lope gjennom listen aa hente verdiene til de to forste verdiene og sammenligner de i while lokken med en boolean, og saa lenge den er sann saa bytter de plass. 

Alle testene i tesprogrammet kommer ut med gront hake, uten feilmelding!

Warnings beskivelse:
Vi har 4 warnings vi ikke klarer å gjore noe med.
Den ene er en "Unchecked cast" paa linje 135, som vi ikke har fatt til aa fjerne.
De tre andre warningsene er "Method will throw an exception when parameter is null" og disse metodene
skal kaste exceptions, saa derfor faar vi ikke fjernet warningsene.

btw, tror du har glemt å ta i bruk antallFeil i testprogrammet ;)
