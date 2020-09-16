//PROBLEM: https://leetcode.com/problems/merge-sorted-array/

import java.util.Arrays;

public class Solution_1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //add nums2 to nums1
        for (int i=0, j=0; i < m+n && j < n; i++){
            if(nums1[i] == 0){
                nums1[i] = nums2[j];
                j++;
            }
        }

        //once all elements are added, sort the array using buble sort
        int size = nums1.length;
        for(int i = 0; i < size-1; i++){
            for(int j = 0; j < size-i-1; j++){
                if(nums1[j] > nums1[j+1]){
                    int temp = nums1[j+1];
                    nums1[j+1] = nums1[j];
                    nums1[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(nums1));

    }
}
