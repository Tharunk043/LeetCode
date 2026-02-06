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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pa = dummy;
        ListNode pb = dummy;
        for(int i= 0;i<n;i++){
            pb = pb.next ;
        }
        while(pb.next!=null){
            pa = pa.next ;
            pb =pb.next ;
        }
        pa.next  = pa.next.next ;
        return dummy.next;
    }
}