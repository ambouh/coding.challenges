public class Solution_Actual_2 {
    int[] char_map;
    public boolean isAlienSorted(String[] words, String order) {
        //init character map
        char_map = new int[26];
        char ch;
        //maps old alphabet order location with new order place as value to output
        for (int i = 0; i < order.length(); i++){
            ch = order.charAt(i);
            char_map[ch - 'a'] = i;
        }

        //compare the words each other
        for(int i = 1; i < words.length; i++) {
            if(compare(words[i-1],words[i]) > 0)
                return false;

        }

        return true;

    }

    public int compare(String word1, String word2) {
        int i = 0, j = 0;
        int char_cal = 0;
        char c1 = 0, c2 = 0;
        while(i < word1.length() && j < word2.length() && char_cal == 0){
            c1 = word1.charAt(i);
            c2 = word2.charAt(j);
            char_cal = (char_map[c1-'a'] - char_map[c2-'a']);

            //means it's greater, not ordered
            if(char_cal > 0)
                return char_cal;
            i++;
            j++;
        }

        //same but the length would make the difference
        if(char_cal == 0){
            return word1.length() - word2.length();
        }

        //means it's less but in order
        return char_cal;
    }
}
