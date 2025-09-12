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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null){
            return null;
        }

        return margelist(lists, 0, lists.length-1);
    }
    private static ListNode margelist(ListNode[] lists, int left, int right){
        if(left == right){
            return lists[left];
        }
        int mid = left+(right-left)/2;
        ListNode l1 = margelist(lists, left, mid);
        ListNode l2 = margelist(lists, mid+1, right);
        return marge(l1, l2);

    }

    public static ListNode marge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(l1 != null && l2 != null){
             if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
             }else{
                curr.next = l2;
                l2 = l2.next;
             }
             curr = curr.next;
        }

        if(l1!=null){
            curr.next = l1;
        }
        if(l2 != null){
            curr.next = l2;
        }

        return dummy.next;
    }
}