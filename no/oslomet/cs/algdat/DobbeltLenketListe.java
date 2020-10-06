package no.oslomet.cs.algdat;

import java.util.Objects;
import java.util.function.Predicate;

////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

import java.util.Iterator;


public class DobbeltLenketListe<T> implements Liste<T> {


    public static void main(String[] args) {
        Liste<String> liste = new DobbeltLenketListe<>();
        System.out.println(liste.antall() + " " + liste.tom());
       /*
        String[] s = {"Ole", null, "Per", "Kari", null};
        Liste<String> liste = new DobbeltLenketListe<>(s);
        System.out.println(liste.antall() + "" + liste.tom());

        */
    }

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

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
        throw new UnsupportedOperationException("ikke laget ennå");
    }


    public DobbeltLenketListe() {
        hode = hale = null;
        antall = 0;
        endringer = 0;
    }

    public DobbeltLenketListe(T[] a) {
        antall = 0;
        hode = hale = null;

        Node naavaerende = null;
        /*
        if (a == null) {
            throw new NullPointerException();
        }

        */
        for (int i = 0; i < a.length; ++i) {
            if (a[i] == null) {
                throw new NullPointerException();
                //  endringer++ ikke gjøre noe ignorere null verdier
            } else {
                if (naavaerende == null) {
                    hode = new Node<>(a[i]);
                    naavaerende = hode;

                } else {
                    naavaerende.neste = new Node(a[i]);
                    naavaerende.neste.forrige = naavaerende;
                    naavaerende = naavaerende.neste;
                }
                antall++;

            }

        }
        hale = naavaerende;
        hale.neste = hode;
        hode.forrige = hale;
    }


    public Liste<T> subliste(int fra, int til) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        if (hode == null) {
            return true;
        } else {
            return false;
        }
        return antall == 0;
    }


    @Override
    public boolean leggInn(T verdi) {
        if (verdi == null) {
            throw new NullPointerException();
        }
        antall++;
        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T hent(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indeksTil(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
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
        StringBuilder tegnStreng = new StringBuilder();
        tegnStreng.append("[");

        Node<T> head = hode;

        for (; head != null; head = head.neste) {
            tegnStreng.append(head.verdi);

            if (head != hale) {
                tegnStreng.append(", ");
            }
        }

        tegnStreng.append("]");
        return tegnStreng.toString();
    }

    public String omvendtString() {
        StringBuilder tegnStreng = new StringBuilder();
        tegnStreng.append("[");

        Node<T> tail = hale;

        for (; tail != null; tail = tail.forrige){

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


