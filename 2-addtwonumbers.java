/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(-1);
        ListNode head = first;
        int count = 0;
        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            int sum = val1 + val2 + count;
            count = 0;
            if (sum >= 10) {
                count = 1;
            }
            sum = sum % 10;
            ListNode newNode = new ListNode(sum);
            head.next = newNode;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + count;
            count = 0;
            if (sum >= 10) {
                count = 1;
            }
            sum = sum % 10;
            ListNode newNode = new ListNode(sum);
            head.next = newNode;
            head = head.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + count;
            count = 0;
            if (sum >= 10) {
                count = 1;
            }
            sum = sum % 10;
            ListNode newNode = new ListNode(sum);
            head.next = newNode;
            head = head.next;
            l2 = l2.next;
        }
        if (count == 1) {
            ListNode newNode = new ListNode(1);
            head.next = newNode;
        }
        return first.next;
    }
}
