import java.util.*;
//P: https://leetcode.com/problems/first-unique-character-in-a-string/

class Solution {
    public int firstUniqChar(String s) {
        int lowestIndex = -1;

        //init a hashmap
        HashMap<Character, Integer> map =
                new HashMap<Character, Integer>();

        //iterate through the string s and add charact (if duplicated, updated count)
        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i); //current character

            if (!map.containsKey(c)) { //if c doesn't exist, add key 'c' and value '1'
                map.put(c, 1);
            } else { //if c exists, update count
                int count = map.get(c);
                count++;
                map.replace(c, count);
            }

            i++;
        }
        //System.out.println("map: \n" + map.toString());


        //interate thru string string s
        //if value = 1, return index.

        i= 0;
        while (i < s.length()){
            char c = s.charAt(i);
            if(map.get(c) == 1) {
                return s.indexOf(c);
            }

            i++;
        }

        return lowestIndex;
    }
}
