//PROBLEM: https://leetcode.com/problems/add-binary/

class Solution {
    public String addBinary(String a, String b) {
        //init variables
        StringBuilder sb = new StringBuilder();
        int x = a.length()-1, y = b.length()-1, sum = 0, carry = 0;

        while(x >= 0 || y >= 0){
            sum = carry;

            //convert string to int
            if(x >= 0) sum += a.charAt(x) - '0';
            if(y >= 0) sum += b.charAt(y) - '0';

            //append and/or assign carry the remainder
            sb.append( sum%2);
            carry = (sum/2); //should store 1 or 0

            x--;
            y--;
        }

        if(carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
