/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode>A = new HashSet<>();

        ListNode temp = headA;
        while(temp!=null){
            A.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while(temp!=null){
            if(A.contains(temp)){
                return temp; //found
            }
            temp = temp.next;
        }
        return null;
    }
}