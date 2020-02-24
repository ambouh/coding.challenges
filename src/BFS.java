import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BFS {

    // Complete the bfs function below.
    public static int[] bfs(int n, int m, int[][] edges, int s) {
        //get an adjacent list
        HashMap<Integer,List<Integer>> hMap = adjacentList(edges);

        //solve by:
        // making a queue
        LinkedList<Integer> queue = new LinkedList<>();
        int[] distance = new int[n-1];
        int count = 1;
        int weight = 6;

        //add start node to queue
        queue.add(s);

        //for loop that goes through the queue
        for(Integer node : queue) {

            //marks as visited to the visited array,
            //remove visited node from queue
            queue.poll();

            // run through its neighbors
             List<Integer> neighbors = hMap.get(node);
            for(Integer neighbor : neighbors) {
                //if not added, add them to queue
                queue.add(neighbor);
                //add their score to the score array
                distance[neighbor] = weight;
            }


            //update count
            count++;

            //update score
            weight = weight * count;
        }

        return convertIntegers(hMap.get(s));
    }

    //returns the adjacent list needed to solve the breadth first search
    public static HashMap<Integer,List<Integer>> adjacentList(int[][] edges){
        //create hashmap to represent an adjacent list
        HashMap<Integer,List<Integer>> hMap = new HashMap<>();
        List<Integer> _edges;
        Integer parent;

        //go through 2D array
        for(int i = 0; i < edges.length; i++){
            //in a j-row of array, add key and new list (if node not added)
            parent = new Integer(edges[i][0]);
            _edges = new ArrayList<>();

            for (int j  = 0; j < edges[i].length; j++){

                if(!hMap.containsKey(parent)){ //not added & j is 1st
                    hMap.put(parent, _edges);
                } else {//add to list using parent
                    if (!parent.equals(edges[i][j])){ //doesn't add parent as edge
                        _edges = hMap.get(parent);
                        _edges.add(edges[i][j]);
                    }
                }
            }
        }

        //prints to see if number has been added
        System.out.println("Map: " + hMap);

        return hMap;
    }

    public static int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  throws IOException {

        /*2
        4 2
        1 2
        1 3
          */
        int[][] array2D = {{1,2}, {1,3}};

        bfs(4, 2, array2D, 1);

        /*
        3 1
        2 3
        2
        */
        array2D = new int[][]{{3, 1}, {2, 3}};
        bfs(3, 1, array2D, 2);
        //runBFS();
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
