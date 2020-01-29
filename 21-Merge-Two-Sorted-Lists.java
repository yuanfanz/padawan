/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            int value = 0;
            if (l1.val > l2.val) {
                value = l2.val;
                l2 = l2.next;
            } else {
                value = l1.val;
                l1 = l1.next;
            }
            ListNode newNode = new ListNode(value);
            head.next = newNode;
            head = head.next;
        }
        while (l1 != null) {
            ListNode newNode = new ListNode(l1.val);
            head.next = newNode;
            head = head.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            ListNode newNode = new ListNode(l2.val);
            head.next = newNode;
            head = head.next;
            l2 = l2.next;
        }
        return dummy.next;
    }
}
