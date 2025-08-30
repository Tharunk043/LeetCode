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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode mid = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            mid = mid.next;
            fast = fast.next.next;
        }
        ListNode right = mid.next;
        mid.next = null;// to break the list
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(right);
        return merge(l1,l2);
    }
    ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy= new ListNode();
        ListNode curr = dummy;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                curr.next =l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1!=null?l1:l2;
        return dummy.next;
    }
}
