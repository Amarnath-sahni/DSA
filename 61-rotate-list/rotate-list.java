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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // find length and tail
        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // normalize k
        k %= n;
        if (k == 0) return head;

        // move fast k steps ahead
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        // move slow & fast until fast at tail
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // rotate
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }
}
