import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int[] distance = new int[n];
        int count = 0;
        int weight = 6;
        boolean[] visited = new boolean[n+1];
        //int[] visited = new int[n+1];
        Integer node = null;
        //add start node to queue
        queue.add(s);

        //for loop that goes through the queue
        while(!queue.isEmpty()) {

            //marks as visited to the visited array,
            //remove visited node from queue
            node = queue.poll();

            // run through its neighbors
            List<Integer> neighbors;

            if ( hMap.get(node) != null ) { //hMap always an object it is best to check hMap.get(node), where as neighbors is null
                neighbors = hMap.get(node);
                //update count when neighbors exist, neighbors determine the level
                count++;

                //update score
                weight*=(count);

                for (Integer neighbor : neighbors) {

                    /*if not added, add them to queue and neighbor != start-node - skips vertex
                     * (so distance array doesn't  go out of bounds)
                     */
                    if (!visited[neighbor]) { //if neighbor isn't visited or visited[x] == 0
                        queue.add(neighbor);
                        visited[neighbor] = true;
                        //add their score to the score array
                        if (neighbor>=1 || neighbor <=n) //makes sure it's not out of bounds
                            distance[neighbor-1] = weight;
                    }
                }
            }
        }

        return makeArray(distance, s);
    }

    //returns the adjacent list needed to solve the breadth first search
    public static HashMap<Integer,List<Integer>> adjacentList(int[][] edges){
        //create hashmap to represent an adjacent list
        HashMap<Integer,List<Integer>> hMap = new HashMap<Integer, List<Integer>>();
        List<Integer> _edges;
        Integer parent;

        //go through 2D array
        for(int i = 0; i < edges.length; i++){
            //in a j-row of array, add key and new list (if node not added)
            parent = new Integer(edges[i][0]);
            _edges = new ArrayList<Integer>();

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

    public static int[] makeArray(int[] distance, int s) {
        int[] new_dist = new int[distance.length-1];
        int i = 0;
        int j = 0;
        int startPos = (s - 1);
        while (i < distance.length){
            if(i != startPos) { //skips starting position
                if (distance[i] == 0) //assigns (-1) to unreachable
                {new_dist[j] = -1; } //str += " " + -1;
                else
                {new_dist[j] = distance[i]; } //str += " " + distance[i];
                j++;
            }
            i++;
        }
        return new_dist;
    }

    public static String stringify(int[] arr) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            str.append(" " + arr[i]);
        }

        return str.toString();
    }
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
        array2D = new int[][]{{2, 3}};
        bfs(3, 1, array2D, 2);

        /*
        5 3
        1 2
        1 3
        3 4
        1
        */
        array2D = new int[][]{{1, 2},{1, 3},{3, 4}};
        bfs(5, 3, array2D, 1);
        //runBFS();
    }

    public static int[] runBFS(Scanner scanner) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] result = new int[0];
        int q = scanner.nextInt();
        /*
         * skip any:
         * \r\n (Windows) = new line
         * */
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

            result = BFS.bfs(n, m, edges, s);

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

        return result;
    }
}
