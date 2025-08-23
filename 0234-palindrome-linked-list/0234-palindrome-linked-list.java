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
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> al1 =new ArrayList<>();
        ArrayList<Integer> al2 =new ArrayList<>();
        while(head!=null){
            al1.add(head.val);
            al2.add(head.val);
            head = head.next;
        }
        Collections.reverse(al2);
        return al1.equals(al2);
    }
}