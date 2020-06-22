import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
    }

    // Complete the insertNodeAtPosition function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode prev = null, curr = null, newNode;

        if(head == null){
            return head;
        }

        curr = head;

        for (int i = 0; curr != null ; i++){
            //System.out.println(curr.data);
            if(i == position){
                newNode = new SinglyLinkedListNode(data);
                newNode.next = curr;
                if (prev != null)
                    prev.next = newNode;
            }
            prev = curr;
            curr = curr.next;

        }



        // System.out.println(head.data);
        return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = 3;
        String str = "16 13 7";
        String[] aItems = str.split(" ");
        for (int i = 0; i < aItems.length; i++) {
            int llistItem = Integer.parseInt(aItems[i]);

            llist.insertNode(llistItem);
        }

        String dataStr = "1", posStr = "2";

        int data = Integer.parseInt(dataStr);
        int position = Integer.parseInt(posStr);

        System.out.println("BEFORE INSERT: ");
        printSinglyLinkedList(llist.head, " ");

        SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);

        System.out.println("\n\nAFTER INSERT: ");
        printSinglyLinkedList(llist_head, " ");
    }
}
