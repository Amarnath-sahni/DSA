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
    public int countNodes(TreeNode root) {
      return countNode(root);
    }
    private int countNode(TreeNode root){
        if(root==null){
            return 0;
        }
        int count =0;
        count++; 
        int left = countNode(root.left);
        int right = countNode(root.right);

        count = left+right+1;
        return count;
    }
}