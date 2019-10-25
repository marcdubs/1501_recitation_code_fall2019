import java.util.NoSuchElementException;

public class IndexMinPQ<Key extends Comparable<Key>> {
    private int capacity;
    private int size;
    private Key[] keys; //given an index, contains the key of that index
    private int[] pq;   //binary heap using 1-based indexing
    private int[] qp;   //contains the index of the pq array that a specified INDEX resides

    @SuppressWarnings("unchecked")
    public IndexMinPQ(int capacity) {
        this.capacity = capacity;
        size = 0;
        keys = (Key[]) new Comparable[capacity + 1];
        pq = new int[capacity + 1];
        qp = new int[capacity + 1];
        for(int i = 0; i <= capacity; i++) {
            qp[i] = -1;
        }
    }

    /***************************************************************************
    * TODO
    ***************************************************************************/

    public void insert(int i, Key key) {

    }

    public boolean contains(int i) {
        return false;
    }

    public int minIndex() {
        return -1;
    }

    public Key minKey() {
        return null;
    }

    public void deleteMin() {

    }

    public Key delete(int index) {
        return null;
    }

    public Key keyOf(int i) {
        if (i < 0 || i >= capacity) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        else return keys[i];
    }

    /***************************************************************************
    * General helper functions.
    ***************************************************************************/
    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }


   /***************************************************************************
    * Heap helper functions.
    ***************************************************************************/
    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= size) {
            int j = 2*k;
            if (j < size && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
}