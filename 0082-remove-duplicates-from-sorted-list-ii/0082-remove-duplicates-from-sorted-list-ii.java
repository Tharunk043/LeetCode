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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0, head); // dummy before head
        ListNode prev = dummy; // last node before a potential duplicate group
        ListNode curr = head;

        while (curr != null) {
            // Check if curr is a start of duplicate group
            boolean isDuplicate = false;
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next; // skip duplicates
                isDuplicate = true;
            }

            if (isDuplicate) {
                // Skip the entire group
                prev.next = curr.next;
            } else {
                // No duplicate, move prev forward
                prev = prev.next;
            }

            curr = curr.next; // move forward
        }

        return dummy.next;
    }
}
