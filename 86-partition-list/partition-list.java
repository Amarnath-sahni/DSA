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
    public ListNode partition(ListNode head, int x) {
       ListNode small = new ListNode(0);
       ListNode large = new ListNode(0);

       ListNode head1 = small;
       ListNode head2 = large;

       while(head!=null){

        if(head.val < x){
            head1.next = head;
            head1 = head1.next;
        }else{
            head2.next = head;
            head2 = head2.next;
        }
        head = head.next;
       }

       head2.next = null;
       head1.next = large.next;

       return small.next;
    }
}
