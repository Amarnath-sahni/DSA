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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxfindpath(root);
        return max;
    }
    private int maxfindpath(TreeNode root){
           if(root == null){
              return 0;
           }
       int left = Math.max(0,maxfindpath(root.left));
        int right = Math.max(0,maxfindpath(root.right));

         int localmax = left+ right+ root.val;
         //update globle maxima
          max = Math.max(max, localmax);
       return root.val + Math.max(left, right);
    }
}