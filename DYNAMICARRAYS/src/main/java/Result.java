import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    // List<List<Integer>> seqList;
    static int lastAnswer = 0;
    int minCap = 5;
    static List<Integer> result;
    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> seqList = new ArrayList<List<Integer>>(n);
        int x;
        int y;
        int type;
        result = new ArrayList<Integer>();

        //initiate each sequence in seqList
        for (int i= 0; i < n; i++){
            seqList.add(new ArrayList<Integer>());
        }

        //iterate through the queries
        for(List<Integer> query: queries) {
            //work on whether it is Q1 OR Q2
            type = query.get(0);
            x = query.get(1);
            y = query.get(2);

            //find index to know which sequence to use in seqList
            int index = (x^lastAnswer) % n;
            List<Integer>seq = seqList.get(index);

            if(type == 1) { //QUERY 1
                System.out.println("Query 1");
                runQuery1(seq, x, y);
            } else { //QUERY 2
                System.out.println("Query 2");
                runQuery2(seq, x, y, result);
            }
        }

        //return result of all  (lastAnswer) added
        return result;

    }

    // find the sequence
    public static void runQuery1(List<Integer> seq, int x, int y) {
        //append integer y to seq
        seq.add(y);
    }

    public static void runQuery2(List<Integer> seq, int x, int y, List<Integer> result) {
        //append integer y to seq
        int elementIndex = y%seq.size();

        //find element and assign it to lastAnswer
        lastAnswer = seq.get(elementIndex);

        //print lastAnswer
        System.out.println(lastAnswer);

        Result.result.add(lastAnswer);
    }

}