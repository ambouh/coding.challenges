//P: [https://leetcode.com/problems/add-strings/]

class Solution {
    public String addStrings(String num1, String num2) {

        //check for size (size appropriation)
        if(num1.length() < num2.length() ) {
            return addStrings(num2, num1);
        }

        //init n1 and n2 and etc.
        int n1 = 0, n2 = 0, ones = 0, tens = 0, sum = 0;
        int n1curr = num1.length()-1,
                n2curr = num2.length()-1;

        //init stringbuilder that will keep results
        StringBuilder sb = new StringBuilder();

        //while that add two strings -here we go!
        while(n1curr >= 0) {

            //init value 1
            n1 = (n1curr >= 0)?( num1.charAt(n1curr--) - '0'): 0;
            //init value 2
            n2 = (n2curr >= 0)?(num2.charAt(n2curr--)- '0'): 0;

            System.out.println(tens+ " " + n1 + " " + n2);

            sum = tens + n1 + n2;
            //check add sum >= tens
            tens = sum/10;
            ones = (sum % 10);

            System.out.println(">10: " + sum + " "+ tens + " " + ones);


            sb.append(ones);

            System.out.println("index: " + n1curr);

        }


        if(tens > 0) { //takes care of that last remaining tens
            sb.append(tens);
        }



        return sb.reverse().toString();

    }
}
