import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args)  throws IOException {
        runBFS();
    }

    public static void runBFS() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = BFS.bfs(n, m, edges, s);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
