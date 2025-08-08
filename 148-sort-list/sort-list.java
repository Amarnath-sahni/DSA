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
        if (head == null || head.next == null) return head;

        // Step 1: Count the number of nodes
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // Step 2: Store values in array
        int[] arr = new int[size];
        temp = head;
        int i = 0;
        while (temp != null) {
            arr[i++] = temp.val;
            temp = temp.next;
        }

        // Step 3: Sort the array
        Arrays.sort(arr);

        // Step 4: Rebuild the linked list
        ListNode dummy = new ListNode(arr[0]);
        ListNode curr = dummy;
        for (int j = 1; j < arr.length; j++) {
            curr.next = new ListNode(arr[j]);
            curr = curr.next;
        }

        return dummy;
    }
}