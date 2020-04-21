import java.util.*;

public class PQueue < T extends Comparable<T>> {

    private  int heapSize = 0;

    private int heapCapacity = 0;

    private List<T> heap = null;

    private Map<T, TreeSet<Integer>> map = new HashMap<T, TreeSet<Integer>>();


    public PQueue() {
        this(1);
    }

    public PQueue(int sz) {
        heap = new ArrayList<T>(sz);
    }

    //heapifying
    public PQueue(T[] elems) {
        heapSize = heapCapacity = elems.length;
        heap = new ArrayList<T>( heapCapacity );
        
        for(int i = 0; i < heapSize; i++ ) {
            mapAdd(elems[i], i);
            heap.add(elems[i]);
        }

        for (int i = Math.max(0, (heapSize/2)-1); i >= 0; i-- ){
            sink(i);
        }

    }

    public PQueue (Collection<T> elems) {
        this(elems.size());
        for(T elem: elems) add(elem);
    }

    //Returns true/false depending on if the priority queue is empty
    public boolean isEmpty(){
        return heapSize == 0;
    }

    //Removes the root of the heap, O(log(n))
    public T poll(){
        return removeAt(0);
    }

    //Test if an element is in heap, O(1)
    public boolean contains (T elem) {
        //Map lookup to check containment, O(1) - w/ map (USE THIS for lots of add and remove)
        if(elem == null ) return false;
        return map.containsKey(elem);

        /*
        * Linear scan to check containment, O(N) - w/o map
        * for(int i = 0; i < heapSize; i++)
        *   if (heap.get(i).equals(elem))
        *       return true;
        * return false;
        * */
    }

    //Adds an element to the priority queue,
    // the element must not be null, O(logn)
    private void add(T elem) {
        if(elem == null) throw new IllegalArgumentException();

        if(heapSize < heapCapacity) {
            heap.set(heapSize, elem);
        } else {
            heap.add(elem);
            heapCapacity++;
        }

        swim(heapCapacity);
        heapSize++;
    }
    // Tests if the value of node i <= node j
    // This method assumes i & j are valid indices, O(1)
    private boolean less(int i, int j) {
        T node1 = heap.get(i);
        T node2 = heap.get(j);
        return node1.compareTo(node2) <= 0;
    }

    //Bottom up node swim, O(log(n))
    private void swim(int k) {
        // Grab the index of the next parent node WRT to k
        int parent = (k-1) / 2;

        //Keep swimming while we have not reach the
        // root and while we're less than our parent.
        while (k > 0 && less(k, parent)) {
            //Exchange k with the parent
            swap(parent, k);
            k = parent;

            //Grab the index of the next parent node WRT to k
            parent = (k -1) / 2;
        }
    }


    // Top down node sink, O(log(n))
    private void sink(int k) {
        while (true) {
            int left = 2 * k + 1; // Left  node
            int right = 2 * k + 2; // Right node
            int smallest = left; // Assume left is the smallest node of the two children

            // Find which is smaller left or right
            // If right is smaller set smallest to be right
            if (right < heapSize && less(right, left)) smallest = right;

            // Stop if we're outside the bounds of the tree
            // or stop early if we cannot sink k anymore
            if (left >= heapSize || less(k, smallest)) break;

            // Move down the tree following the smallest node
            swap(smallest, k);
            k = smallest;
        }
    }


    // Swap two nodes. Assumes i & j are valid, O(1)
    private void swap(int i, int j) {
        T elem_i = heap.get(i);
        T elem_j = heap.get(j);

        heap.set(i, elem_j);
        heap.set(j, elem_i);
    }



    private T removeAt(int i) {
    }

    //Clears everthing inside the heap, O(n)
    public void clear(){
        for(int i = 0; i < heapCapacity; i++ ){
            heap.set(i, null);
        }
        heapSize = 0;
        map.clear();
    }





    private void mapAdd(T elem, int i) {
    }

}
