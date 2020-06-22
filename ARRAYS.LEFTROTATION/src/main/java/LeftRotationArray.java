import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LeftRotationArray {

    public static int[] leftRotation(int n, int d, int[] a){
        int[] rotated = new int[n];
        int [] temp = new int[d];
        /*first copy everything that will be out-of-bounds into temp array
        * - up to d elements considering the d steps*/
        for (int i = 0; i < d; i++){
          temp[i] = a[i];
        }

        //add the in-bounds to the front of the rotated array
        for (int i=d; i < n; i++){
            rotated[i-d] = a[i];
        }

        /*add the out-bounds to the rest of the rotated array
        * WRONG:
        * i = 0
        * condition: i < (n-d), so it only goes to the amount of in temp to 2, should be 3
        * rotated[i+d], so it can at index (d) to insert rem. element but this start is 1 index off since array is zero-based
        *   it should have been index before (d)
        * temp[i], starts at 0 since it must start there for all out bounds items stored in temp array
        *
        * TO FIX:
        * condition: i < n,
        * i = (n-d), starts from index before (d) but also accounts for zero-based array,
        * rotated[i], adds from index before (d) and iterates until the end
        * temp[i - (n+d)], starts at 0 because they cancel each other*/
        for(int i= (n-d); i < n; i++) {
            rotated[i] = temp[i-n+d];
        }

        return rotated;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //System.out.println("ADD A LINE: ");
        String ndString = "5 3";
        String[] nd = ndString.split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];
        String aItemsString = "1 2 3 4 5";
        String[] aItems = aItemsString.split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        // scanner.close();

        System.out.println("n:  " + n + " d:  " + d + " arr:  " + Arrays.toString(a) );

        int[] result = leftRotation(n, d, a);

        System.out.println("result: " + Arrays.toString(result));
    }
}
