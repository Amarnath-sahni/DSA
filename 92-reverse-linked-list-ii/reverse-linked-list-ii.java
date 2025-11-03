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
    public ListNode reverseBetween(ListNode head, int left, int right) {
      if(head==null || left==right ) return head;
      if(head.next==null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 1: Move leftPrev to the node just before 'left'
        ListNode leftPrev = dummy;
        for (int i = 1; i < left; i++) {
            leftPrev = leftPrev.next;
        }

        // Step 2: Reverse sublist from left to right
        ListNode curr = leftPrev.next;
        ListNode sublistHead = curr;
        ListNode PreNode = null;
        for(int i=0; i<right-left+1; i++){
            ListNode nextNode = curr.next;
            curr.next = PreNode;
            PreNode = curr;
            curr = nextNode;
        }

        leftPrev.next = PreNode;
        sublistHead.next = curr;

        return dummy.next;
    }
}