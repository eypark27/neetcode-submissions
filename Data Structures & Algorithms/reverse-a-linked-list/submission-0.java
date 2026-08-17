/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        ListNode prev = null;

        while (node.next != null) {
            ListNode next = node.next;
            node.next = prev;

            prev = node;
            node = next;
        }

        node.next = prev;
        return node;
    }
}
