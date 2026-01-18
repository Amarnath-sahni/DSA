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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;

        ListNode curr = head;
        while(curr!=null){
            n++;
            curr = curr.next;
        }

         int arr[] = new int[n];
         int i=0;
         curr = head;
        while(curr!=null){
            arr[i++] = curr.val;
            curr = curr.next;
        }

       return binaryTree(0, n-1, arr);
    }

    private static TreeNode binaryTree(int s, int n , int arr[]){
        if(s > n) return null;

      
            int mid = s+(n-s)/2;
            TreeNode root = new TreeNode(arr[mid]);

           root.left = binaryTree(s, mid-1, arr);
           root.right = binaryTree(mid+1, n, arr);

           return root;
    }
}