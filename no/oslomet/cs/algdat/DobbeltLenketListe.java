package no.oslomet.cs.algdat;

import com.sun.security.auth.UnixNumericUserPrincipal;

import java.util.*;
import java.util.function.Predicate;

////////////////// class DobbeltLenketListe //////////////////////////////


////////////////// class DobbeltLenketListe //////////////////////////////


public class DobbeltLenketListe<T> implements Liste<T> {


    public static void main(String[] args) {
     /*   // Liste<String> liste = new DobbeltLenketListe<>();
        // System.out.println(liste.antall() + " " + liste.tom());

        String[] s = {"1", null, "2", "3", null};
        Liste<String> listen = new DobbeltLenketListe<>(s);
        int[] a = {1, 3, 4};

        // System.out.println(listen.antall() + " " + liste.tom());
        //  System.out.println(listen);

        listen.tom();
        @


        String[] s1 = {}, s2 = {"A"}, s3 = {null, " A", null, "B", null};
        String[] jala = {"1","2","3"};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);
        DobbeltLenketListe<String> lala3 = new DobbeltLenketListe<>(jala);
        System.out.println(l1.toString() + " " + l2.toString() + " " + l3.toString() + " " + l1.omvendtString() + " " + l2.omvendtString() + " " + l3.omvendtString());
        System.out.println(lala3.omvendtString());



        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>(); System.out.println(liste.toString() + " " + liste.omvendtString());
        for (int i = 1; i <= 3; i++) {
            liste.leggInn(i);

            System.out.println(liste.toString() + " " + liste.omvendtString()); }

    }

      */
        Character[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',};
        DobbeltLenketListe<Character> liste = new DobbeltLenketListe<>(c);
        System.out.println(liste.subliste(3, 8));

        //  [D, E, F, G, H]
        System.out.println(liste.subliste(5, 5));
        // []
        System.out.println(liste.subliste(8, liste.antall())); //
        // [I, J] //
        System.out.println(liste.subliste(0, c.length + 1));
        // skal kaste unntak
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

    }

    public DobbeltLenketListe(T[] a) {
        Node<T> naavaerende = null;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] == null) {
                // ignorerer null verdier
            } else {
                if (naavaerende == null) {
                    hode = new Node<T>(a[i]);
                    naavaerende = hode;
                } else {
                    naavaerende.neste = new Node<T>(a[i]);
                    naavaerende.neste.forrige = naavaerende;
                    naavaerende = naavaerende.neste;
                }
                antall++;
            }
        }
        if (naavaerende != null) {
            hale = naavaerende;
        }
    }

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
    public boolean leggInn(T verdi) {
        /*Objects.requireNonNull(verdi, "Det skal ikke være null objekter");
        if (tom()) {
            hode = hale = new Node<T>(verdi, null, null);
        } else {
            hale = hale.neste = new Node<T>(verdi, hale, null);
        }
        endringer++;
        antall++;
        return true;

         */

        Objects.requireNonNull(verdi);

        if (hode == null || hale == null) {
            hode = new Node<>(verdi);
            hale = hode;
        } else{
            hale.neste = new Node<>(verdi);
            hale.neste.forrige = hale;
            hale = hale.neste;
        }
                              antall++;
        return true;

    }

    @Override
    public void leggInn(int indeks, T verdi) {
        // sjekker etter null verdier
    /*    Objects.requireNonNull(verdi, "Det kan ikke være nullverdier");

        if (indeks < 0) {
            throw new IndexOutOfBoundsException();
        } else if (indeks > antall) {
            throw new IndexOutOfBoundsException();
        }

        if (antall == 0 && indeks == 0) {
            hode = hale = new Node<T>(verdi, null, null);
        } else if (indeks == 0) {
            hode = new Node<T>(verdi, null, hode);
            hode.neste.forrige = hode;
        } else if (indeks == antall) {
            hale = new Node<T>(verdi, hale, null);
            hale.forrige.neste = hale;
        } else {
            Node<T> nHode = hode;
            for (int i = 0; i < indeks; ++i) {
                nHode = nHode.neste;
                nHode = new Node<T>(verdi, nHode.forrige, nHode);
                nHode.neste.forrige = nHode.forrige.neste = nHode;
            }
            ++antall;
            ++endringer;
        }

     */


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
    public T oppdater(int indeks, T nyverdi) {
        Objects.requireNonNull(nyverdi);
        this.indeksKontroll(indeks, false);
        Node<T> node = finnNode(indeks);
        T gammelVerdi = node.getVerdi();
        node.setNyVerdi(nyverdi);
        return gammelVerdi;
    }

    @Override
    public boolean fjern(T verdi) {
        return false;
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
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
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


