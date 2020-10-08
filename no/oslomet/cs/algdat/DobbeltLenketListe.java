package no.oslomet.cs.algdat;


import java.util.*;


////////////////// class DobbeltLenketListe //////////////////////////////


////////////////// class DobbeltLenketListe //////////////////////////////


public class DobbeltLenketListe<T> implements Liste<T> {


    public static void main(String[] args) {

    }


    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere


        public T getVerdi() {
            return this.verdi;
        }

        public void setNyVerdi(T verdi) {
            this.verdi = verdi;
        }

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }


        private Node(T verdi) {
            this(verdi, null, null);
        }
    }


    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen


    // hjelpemetode
    private Node<T> finnNode(int indeks) {
        // Regner ut midtindeks
        int midtIndeks = antall / 2;
        Node<T> denne;
        // sjekker om indeksen er i andre halvdel
        if (indeks > midtIndeks) {
            // legger inn verdien i hale om indeksen er større en halvparten
            denne = hale;
            int denneIndeksen = antall - 1;
            while (denne != null) {

                if (denneIndeksen == indeks) {
                    return denne;
                }
                denneIndeksen--;
                denne = denne.forrige;
            }
            //
        } else {
            denne = hode;
            int denneIndeksen = 0;
            while (denne != null) {
                if (denneIndeksen == indeks) {
                    return denne;
                }
                denneIndeksen++;
                denne = denne.neste;
            }
        }
        throw new IllegalStateException();
    }


    public DobbeltLenketListe() {
        hode = null;
        hale = null;

        antall = 0;
        endringer = 0;
    }

    public DobbeltLenketListe(T[] a) {
        Node<T> naavaerende = null;
        for (T t : a) {
            if (t != null) {
                if (naavaerende == null) {
                    hode = new Node<>(t);
                    naavaerende = hode;
                } else {
                    naavaerende.neste = new Node<>(t);
                    naavaerende.neste.forrige = naavaerende;
                    naavaerende = naavaerende.neste;
                }
                antall++;
            }
            // ignorerer null verdier

        }
        if (naavaerende != null) {
            hale = naavaerende;
        }
    }
   @SuppressWarnings("Unchecked")
    public Liste<T> subliste(int fra, int til) {
        int nyttArrayStorrelse = til - fra;
        if (nyttArrayStorrelse < 0) {
            throw new IllegalArgumentException();
        } else if (nyttArrayStorrelse == 0) {
            return new DobbeltLenketListe<>();
        }
        this.indeksKontroll(fra, false);
        this.indeksKontroll(til - 1, false);

        Object[] resultatArray = new Object[nyttArrayStorrelse];

        Node<T> denne = finnNode(fra);
        int denneIndeksen = 0;
        while (denne != null && (denneIndeksen + fra) < til) {
            resultatArray[denneIndeksen++] = denne.getVerdi();
            denne = denne.neste;
        }
        // Klarer ikke løse dette på en måte hvor det ikke er warning.
        return new DobbeltLenketListe<>((T[]) resultatArray);
    }


    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return (antall == 0 && hode == null && hale == null);
    }


    @Override
    @SuppressWarnings("Null verdier skal kaste exception")
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi);

        if (hode == null || hale == null) {
            hode = new Node<>(verdi);
            hale = hode;
        } else {
            hale.neste = new Node<>(verdi);
            hale.neste.forrige = hale;
            hale = hale.neste;
        }
        antall++;
        endringer++;
        return true;


    }

    @Override
    @SuppressWarnings("Null verdier skal kaste exception")
    public void leggInn(int indeks, T verdi) {
        // sjekker etter null verdier
        Objects.requireNonNull(verdi, "Det kan ikke være nullverdier");

        if (indeks < 0) {
            throw new IndexOutOfBoundsException();
        } else if (indeks > antall) {
            throw new IndexOutOfBoundsException();
        }

        if (antall == 0) {
            hode = hale = new Node<>(verdi, null, null);
        } else if (indeks == 0) {
            hode = new Node<>(verdi, null, hode);
            hode.neste.forrige = hode;
        } else if (indeks == antall) {
            hale = new Node<>(verdi, hale, null);
            hale.forrige.neste = hale;
        } else {
            Node<T> nHode = hode;
            for (int i = 0; i < indeks; i++) nHode = nHode.neste;
            {
                nHode = new Node<>(verdi, nHode.forrige, nHode);
            }
            nHode.neste.forrige = nHode.forrige.neste = nHode;
        }
        ++antall;
        ++endringer;


    }


    @Override
    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1;
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        return finnNode(indeks).getVerdi();
    }

    @Override
    public int indeksTil(T verdi) {

        if (verdi == null) {
            return -1;
        }

        Node<T> p = hode;
        for (int indeks = 0; indeks < antall; indeks++) {
            if (p.verdi.equals(verdi)) return indeks;
            p = p.neste;
        }
        return -1;

    }

    @Override
    @SuppressWarnings("Null verdier skal kaste exception")
    public T oppdater(int indeks, T nyverdi) {
        Objects.requireNonNull(nyverdi);
        this.indeksKontroll(indeks, false);
        Node<T> node = finnNode(indeks);
        T gammelVerdi = node.getVerdi();
        node.setNyVerdi(nyverdi);
        endringer++;
        return gammelVerdi;
    }

    @Override
    public boolean fjern(T verdi) {
        if (verdi == null) {
            return false;
        }
        Node<T> head = hode;
        while (head != null) {
            if (head.verdi.equals(verdi)) {
                break;
            }
            head = head.neste;
        }
        if (head == null) {
            return false;
        }
        if (head == hode) {
            hode = hode.neste;

            if (hode != null) {
                hode.forrige = null;
            } else {
                hale = null;
            }
        } else if (head == hale) {
            hale = hale.forrige;
            hale.neste = null;
        } else {
            head.forrige.neste = head.neste;
            head.neste.forrige = head.forrige;
        }
        head.verdi = null;
        head.forrige = head.neste = null;

        antall--;
        endringer++;

        return true;


    }


    @Override
    public T fjern(int indeks) {
        indeksKontroll(indeks, false);

        indeksKontroll(indeks, false);

        Node<T> midlertidig;
        /*if (indeks < 0 || tom() || indeks > antall-1) {
            throw new IndexOutOfBoundsException();

        }*/

        if (indeks == 0) {
            midlertidig = hode;
            hode = hode.neste;
            if (antall == 1) {
                hale = null;
            } else {
                hode.forrige = null;
            }
        } else if (indeks == antall - 1) {
            midlertidig = hale;
            hale = hale.forrige;
            hale.neste = null;
        } else {
            Node<T> n = finnNode(indeks - 1);

            midlertidig = n.neste;
            n.neste = n.neste.neste;
            n.neste.forrige = n;
        }
        antall--;
        endringer++;
        return midlertidig.verdi;
    }

    @Override
    public void nullstill() {
        Node<T> denne = hode;

        for (int i = 0; i < antall; ++i) {
            Node<T> mellomlagring = denne;
            denne.forrige = null;
            denne = denne.neste;
            mellomlagring.neste = null;
            mellomlagring.setNyVerdi(null);
            if (denne == null) {
                return;

            }
            antall--;
            endringer++;
        }
        antall = 0;
        hode = null;
        hale = null;


// Denne er enklere, men virker og være marginalt mer krevende.
        //  while(antall !=0){
        //     fjern(0);

    }

    @Override
    public String toString() {
        if (tom()) {
            return "[]";
        }

        StringBuilder tegnStreng = new StringBuilder();
        tegnStreng.append('[');

        Node<T> head = hode;

        tegnStreng.append(head.verdi);
        head = head.neste;

        while (head != null) {
            tegnStreng.append(',').append(' ').append(head.verdi);
            head = head.neste;
        }
        tegnStreng.append(']');
        return tegnStreng.toString();
    }


    public String omvendtString() {
        if (tom()) {
            return "[]";
        }
        StringBuilder tegnStreng = new StringBuilder();
        tegnStreng.append("[");

        Node<T> tail = hale;

        for (; tail != null; tail = tail.forrige) {

            tegnStreng.append(tail.verdi);

            if (tail != hode) {
                tegnStreng.append(", ");
            }
        }


        tegnStreng.append("]");

        return tegnStreng.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new DobbeltLenketListeIterator();
    }

    public Iterator<T> iterator(int indeks) {
        //   if(/*indeks < 0 || indeks >= antall*/){
        indeksKontroll(indeks, false);
        //throw new IndexOutOfBoundsException();

        return new DobbeltLenketListeIterator(indeks);
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;


        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }


        private DobbeltLenketListeIterator(int indeks) {
            denne = finnNode(indeks);
            fjernOK = false;
            iteratorendringer = endringer;
        }


        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            if (iteratorendringer != endringer) {
                throw new ConcurrentModificationException();

            } else if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                fjernOK = true;
                T returVerdi = denne.getVerdi();
                denne = denne.neste;
                return returVerdi;

            }
        }

        @Override
        public void remove() {
            if (endringer != iteratorendringer) {
                throw new ConcurrentModificationException();
            }
            if (antall == 0 || !fjernOK) {
                throw new IllegalStateException();
            } else if (antall == 1) {
                hode = null;
                hale = null;
            } else if (denne == null) {
                hale = hale.forrige;
                hale.neste.forrige = null;
                hale.neste = null;
            } else if (denne.forrige == hode) {
                hode = hode.neste;
                hode.forrige.neste = null;
                hode.forrige = null;
            } else {
                Node<T> nodeSlette = denne.forrige;
                Node<T> nodeFoer = nodeSlette.forrige;
                Node<T> nodeEtter = denne;
                nodeFoer.neste = nodeEtter;
                nodeEtter.forrige = nodeFoer;
                nodeSlette.forrige = null;
                nodeSlette.neste = null;
            }
            antall--;
            iteratorendringer++;
            endringer++;
            fjernOK = false;

        }
    }


    // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        if (liste.antall() <= 1) {
            return;
        }
        // løper igjennom listen
        for (int i = 0; i < liste.antall(); ++i) {
            int denneIndeks = 0;
            int nesteIndeks = 1;
            T denne = liste.hent(denneIndeks);
            T neste = liste.hent(nesteIndeks);

            while (neste != null) {
                // sjekker om denne noden er større enn neste, de må også
                // vaere stoerre enn 0;
                boolean nodeErStoerreEnnNeste = c.compare(denne, neste) > 0;
                // Hvis nodeErstoerreEnnNeste er sann så bytter man denne og neste.
                if (nodeErStoerreEnnNeste) {
                    // bytter
                    liste.fjern(denne);
                    liste.leggInn(nesteIndeks, denne);
                    // ellers skal denne være lik neste, slik at den sorterer
                    //     neste element.
                } else {
                    denne = neste;
                }
                // sjekker om man har nådd slutten av listen
                if (nesteIndeks + 1 >= liste.antall()) {
                    // går ut av løkken om man har naadd slutten
                    break;

                }
                neste = liste.hent(nesteIndeks + 1);
                nesteIndeks++;

            }
        }
    }
}


// class DobbeltLenketListe


