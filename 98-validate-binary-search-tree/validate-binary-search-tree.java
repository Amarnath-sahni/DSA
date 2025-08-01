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
    public boolean isValidBST(TreeNode root) {
        return isValideBST1(root, null, null);
    }

    private static boolean isValideBST1(TreeNode root, TreeNode min, TreeNode max){
        if(root == null) return true;

        if(min!=null && min.val >= root.val ){
            return false;
        }else if(max!=null && max.val <= root.val){
            return false;
        }

        return isValideBST1(root.left, min, root) && isValideBST1(root.right, root, max);
    }
}