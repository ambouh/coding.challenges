public class UnionFind {
    //The number of elements in this union find
    private int size;

    //Used to track the sizes of each of the components
    //track the size of a set, the index is the as the id.
    //this is to identify the corresponding id(Set) with size in the set
    private int[] sz;

    //id[i] points to the parent of i, if id[i] = i then i is a root node
    private int[] id;

    //Tracks the number of components in the union find
    //tracks how many sets there are
    private int numComponents;

    public UnionFind(int size){
        if (size <= 0)
            throw new IllegalArgumentException("Size <=0 is not allowed");


        this.size = numComponents = size;
        sz = new int[size];
        id = new int[size];

        for(int i = 0; i < size; i++) {
            id[i] = i; //Link to itself (self root)
            sz[i] = 1; //Each component is size one originally
        }
    }

    //Find which components/set 'p' belongs to, takes amortized constant time
    public int find(int p){

        //Find the root of the component/set
        int root = p;
        while ( root != id[root] ){ //to be parent id must link to itself
                                    //if it links to another component,
            root = id[root]; //assign root to this component and check in while loop
        }

        //Compress the path leading back to the root.
        //doing this operation is called "PATH COMPRESSION"
        // and is what gives amortized constant time complexity
        while(p != root){
            int next = id[p]; //finds the component's id that precedes/links p
            id[p] = root; // replaces the preceding id with root id
            p = next;  //makes p point to root. root is now its precedent
        }

        return root;
    }

    //Return whether or not the elements 'p' and 'q'
    //are in the same components/set.
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    //Return the size of the components/set 'p' belongs to
    public int componentSize(int p){

        return sz[find(p)]; //finds the root of p to determine the size of component which p is in
        //root node will always have/find the size of the component
    }

    public int size(){
        return size;
    }

    //Returns the number of remaining components/sets
    public int components() {
        return numComponents;
    }

    //Unify the components/sets containing elements 'p' and 'q'
    public void unify(int p, int q) {
        int root1 = find(p);
        int root2 = find(q);

        //These elements are in the same group!
        if (root1 == root2) return;

        //Merge two components/sets together.
        //Merge smaller component/set into the larger one.
        if(sz[root1] < sz[root2]){
            sz[root2] += sz[root1];
            id[root1] = root2;
        } else {
            sz[root1] += sz[root2];
            id[root2] = root1;
        }

        // Since the roots found are different we know that the
        // number of components/sets has decreased by one
        numComponents--;

    }


}
