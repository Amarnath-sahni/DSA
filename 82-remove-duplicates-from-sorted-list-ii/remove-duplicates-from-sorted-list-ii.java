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
        if(head==null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;
       
        while(curr!=null){
            boolean duplicate = false;
            while(curr.next!=null && curr.val == curr.next.val){
                duplicate = true;
                curr = curr.next;
            }
            //if dupblicate
            if(duplicate){
                prev.next = curr.next;
            }else{
                prev = prev.next;
            }
            
            curr = curr.next;
        }

         

        return dummy.next;
    }
}