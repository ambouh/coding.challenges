//P: [https://leetcode.com/problems/merge-two-sorted-lists/]
 // Definition for singly-linked list.
class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//[!!NOT CORRECT YET!!]
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //init temp, curr, next and result ListNode;
        ListNode temp = null,
                result = l1,
                curr = result,
                next = null;

        //traverse if l1 or l2 have elements
        while (l1 != null || l2 != null){
            //determine if:
            if(l1 != null && l2 == null){ //l1 valid but l2 is null (add l1.val)
                temp = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l2 !=null && l1 == null) { //l2 valid but l1 is null (add l2.val)
                temp = new ListNode(l2.val);
                l2 = l2.next;
            } else { //both valid (compare)
                if (l1.val < l2.val){
                    temp = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    temp = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }

            //there will always be temp declared for appendage
            next = curr.next;
            curr.next = temp;
            temp.next = next;
        }

        return result;

    }


}
