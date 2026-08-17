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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode n1 = list1;
        ListNode n2 = list2;

        ListNode head = null;
        ListNode tail = null;

        while (n1 != null || n2 != null) {

            // iterate either n1 or n2 
            ListNode chosen = null;
            if (n2 == null || (n1 != null && n1.val <= n2.val)) {
                chosen = n1;
                n1 = n1.next;
            } else {
                chosen = n2;
                n2 = n2.next;
            }

            // detach chosen node
            chosen.next = null;

            // assign the head
            if (head == null) {
                head = chosen;
                tail = chosen;

            // add chosen node to merged list
            } else {
                tail.next = chosen;
                tail = chosen;
            }
        }

        return head;
    }
}