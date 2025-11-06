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
   static int dia_m;
    public int diameterOfBinaryTree(TreeNode root) {
       dia_m = 0;
       height(root);
       return dia_m;
    }

    private int height(TreeNode root){
        if(root == null) return 0;

        int  left = height(root.left);
        int  right = height(root.right);

        dia_m = Math.max(dia_m, left+right);

        return 1 + Math.max(left, right);
    }
}