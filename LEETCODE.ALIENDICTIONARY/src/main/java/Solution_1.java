//PROBLEM: https://leetcode.com/problems/verifying-an-alien-dictionary/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        char oLetter, wLetter;
        String wNext;
        int o_pos = 0, w_pos = 0;
        boolean isBothOrdered;
        while(o_pos <= (order.length()-1) && w_pos <= (words.length-1)) {


            //System.out.println(o_pos + " " + w_pos);

            //check if next word is available
            oLetter = order.charAt(o_pos);
            wLetter = words[w_pos].charAt(0);

            //System.out.println(oLetter + " " + wLetter);

            //find a current letter that matches the word
            if(oLetter == wLetter){
                //find a current letter also matches next word

                if((w_pos+1) < words.length){
                    wNext = words[w_pos+1];
                    isBothOrdered = currentAndNextInOrder(words[w_pos], wNext, w_pos, order);
                } else {
                    o_pos = order.length();
                }

                w_pos++;
            } else {//if no match, update letter
                o_pos++;
            }
        }

        //outside of while loop, if word didnot reach length
        //words[] is not in order
        if (w_pos < (words.length-1)){
            return false;
        } else {
            return true;
        }
    }
    public boolean currentAndNextInOrder(String firstw, String secondw, int w_pos, String order) {
        //go through order
        int len = Math.min(firstw.length(), secondw.length());

        int o_pos = 0;
        //determine which word b/t first and second goes first
        while(w_pos <= len && o_pos <= (order.length()-1)) {

            //first word letter and second word letter
            //is equal, update position to go to next letter
            System.out.println(firstw.charAt(w_pos) + " " + secondw.charAt(w_pos));
            if(firstw.charAt(w_pos) == secondw.charAt(w_pos))
                w_pos++;
            else{
                //if not, determine which goes first based on order
                o_pos = 0;
                while (o_pos < order.length()) {
                    if (firstw.charAt(w_pos)
                            == order.charAt(o_pos)){
                        return true;
                    } else if (secondw.charAt(w_pos)
                            == order.charAt(o_pos)){
                        return false;
                    } else {
                        o_pos++;
                    }
                }
            }
        }


        //determine who goes first based on length,
        // if they are the same
        if (firstw.length() < secondw.length())
            return true;
        else
            return false;
    }
}
