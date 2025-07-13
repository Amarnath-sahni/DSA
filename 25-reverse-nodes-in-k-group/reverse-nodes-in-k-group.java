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
    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode curr = head;
       int cnt = 0;
       //base case no more node exist
       while(cnt < k){
        if(curr == null){ //if there is no more node exist
            return head;
        }
        curr = curr.next;
        cnt++;
       }

       //reverse the node afte the kth node
       ListNode prevNode = reverseKGroup(curr , k);

       //reverse the linkedlist from start to kth node
       cnt = 0;
       curr = head;
       while(cnt < k){
        ListNode next = curr.next;
        curr.next = prevNode;
        prevNode = curr;
        curr = next;
        cnt++;
       }

       return prevNode;
    }
}