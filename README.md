# algdat
Oblig2 Algoritmer og datastrukturer.

Denne oppgaven er obligatorisk oppgave 2 i Algoritmer og datastrukturer.

Oppgaven er levert av følgende studenter.

Alex Tran s336111 Fredrik Vogt s315714 Jesper Østervold s341861

Beskrivelse om hvordan oppgavene ble løst;
Vi har samarbeidet på oppgavene, og tatt noe problemløsning hver for oss.


Oppgave 1:
Her har vi brukt en foreach løkke og så lenge t ikke er null så oppdateres hode.
videre oppdateres antall og hale hvis naavaende ikke er null.

Oppgave 2:
Her sjekker vi først om den er tom, hvis den ikke er tom benytter vi oss av StringBuilder til å sette sammen listen til en char liste.
Så lenge hode ikke er null så "omformer" head.verdi til char.

Oppgave 3:
a: Her bruker vi en hjelpe variabel for å sjekke hvilken ende anv listen finnNode metoden skal jobbe fra. Hent metoden brukes for å returnere indeksen til noden, og Oppdater metoden brukes returnere verdien til noden.

b: subliste metoden lager og returnerer en liste av verider i en eksisterende liste, de velges startverdi og sluttverdi. metoden gir feilmeldinger for ugyldige verdier.
Verdier blir lagt inn i den nye listen ved hjelp av en while lokke

Oppgave 4:Vi har brukt en if sjekk for å returnere -1 om verdi er null.
Videre sjekker vi om p er lik verdi i en for løkke, og løper gjennom listen, og den returnerer indeks. 


Oppgave 5:

Oppgave 6:

Oppgave 7: Oppgaven ble lost på to forskjellige maater, med en while lokke og en for lokke. While lokken var simpel å implementere da den kan fjerne indeks 0 så lenge antall ikke er 0. For lokken bruker neste og forrige pekere for å navigere seg gjennom listen for å fjerne noder og sette hode/hale til null. For lokken viste seg å vaare den raskere av de to maatene.

Oppgave 8:Her har vi benyttet oss av en foreach løkke som går igjennom a, hvis t ikke er null så sjekker går man inn og så lenge naavaernde er null så peker naaverende på hode, ellers blir naavernde neste.forrige peker på naavaernde. 
Antall økes.  Hvis naavernede ikke er lik null så peker hale på naaverande. 


Oppgave 9:Sjekker først om endringer og iteratorendringer , også går vi gjennom og sjekker over list med de føringene gitt i opgpavene, og om man kommer igjennom de så lages det nye noder som peker til null slik at antall blir mindre og endring/iteratorendrigner øker. 

Oppgave 10:Her har vi først en if test for å sjekke at antall er større enn 1, hvis den er det går den videre
Videre brukes en for løkke(og vi benytter oss av bubble sort) for å løpe gjennom listen å hente verdiene til de to første verdiene og sammenligner de i while løkken med en boolean, og så lenge den er sann så bytter de plass. 



Warnings beskivelse:
Vi har 4 warnings vi ikke klarer å gjøre noe med.
Den ene er en "Unchecked cast" på linje 135, som vi ikke har fått til å fjerne.
De tre andre warningsene er "Method will throw an exception when parameter is null" og disse metodene
skal kaste exceptions, så derfor får vi ikke fjernet warningsene.
