import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BFS {

    // Complete the bfs function below.
    static int[] bfs(int n, int m, int[][] edges, int s) {
        //create hashmap to represent an adjacent list
        HashMap<Integer,List<Integer>> hMap = new HashMap<Integer, List<Integer>>();
        List<Integer> _edges;
        //_edges.add(1);
        //_edges.add(2);
        // hMap.put(1, _edges);
        //System.out.println(hMap.toString());
            /*Integer parent = new Integer(1);
                _edges = new ArrayList<Integer>();
               _edges.add(1);
               _edges.add(2);
                hMap.put(parent, _edges);
                System.out.println(hMap);
*/
        //go through 2D array
        for(int i = 0; i < edges.length; i++){
            //in a j-row of array, add key and new list (if node not added)
            for (int j  = 0; j < edges[i].length; j++){
                Integer parent = new Integer(edges[i][0]);
                _edges = new ArrayList<Integer>();
                _edges.add(1);
                _edges.add(2);
                if(!hMap.containsKey(parent)){ //not added & j is 1st
                    hMap.put(parent, _edges);
                    System.out.println(hMap);
                } else {//add to list using parent
                    // _edges = hMap.get(parent);
                    // System.out.println(_edges);
                }
            }
        }
        int[] arr =  {1,2,3};
        return arr; // convertIntegers(_edges);
    }
    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }
}
