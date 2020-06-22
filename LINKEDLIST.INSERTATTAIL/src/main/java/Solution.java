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

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
    }

    public
    static class SinglyLinkedList {
        public SinglyLinkedListNode head;

        public SinglyLinkedList() {
            this.head = null;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = 5;
        String str = "141 302 164 530 474";
        String[] aItems = str.split(" ");
        for (int i = 0; i < aItems.length; i++) {
            int llistItem = Integer.parseInt(aItems[i]);

            SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);
            llist.head = llist_head;

            System.out.println("\n\nAFTER INSERT: ");
            printSinglyLinkedList(llist.head, " ");

        }


    }

    private static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int llistItem) {
        SinglyLinkedListNode prev, curr = null, newNode;
        if (head == null) {
            head = new SinglyLinkedListNode(llistItem);
            return head;
        }

        curr = head;

        while (curr != null) {
           if (curr.next == null) {
                newNode = new SinglyLinkedListNode(llistItem);
                curr.next = newNode;
                curr = curr.next;
            }

            curr = curr.next;
        }

        return head;
    }

}
