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
    public ListNode removeNodes(ListNode head) {
        // Step 1: Reverse the list
        ListNode rev = reverse(head);

        // Step 2: Traverse reversed list and filter
        int maxSoFar = Integer.MIN_VALUE;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (rev != null) {
            if (rev.val >= maxSoFar) {
                maxSoFar = rev.val;
                curr.next = rev;   // keep this node
                curr = curr.next;
            }
            rev = rev.next;
        }
        curr.next = null; // cut off remaining nodes

        // Step 3: Reverse again to restore original order
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
