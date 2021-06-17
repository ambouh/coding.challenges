//P: [https://leetcode.com/problems/roman-to-integer/]
class Solution {
  public int romanToInt(String s) {
    int sum = 0;
    //S: III
    char next = ' ';
    char curr = ' ';
    int count = 0;
    int addend = 0;
    for(int i = 0; i < s.length(); i++){
      curr = s.charAt(i);
      next = (i < (s.length()-1))? s.charAt(i+1): ' ';

      System.out.println("curr:" +  curr +
        "\nnext: " + next);
      if(helper(curr) < helper(next)) {
        addend = helper(next) - helper(curr);
        i++;
      } else {
        addend = helper(curr);
      }

      sum += addend;


    }


    return sum;

  }

  public int helper(char c){
    switch(c) {
      case 'M':
        return 1000;
      case 'D':
        return 500;
      case 'C':
        return 100;

      case 'L':
        return 50;

      case 'X':
        return 10;

      case 'V':
        return 5;

      case 'I':
        return 1;

      default:
        return 0;

    }
  }
    public static void main(String[] args) {
	// write your code here
    }
}
