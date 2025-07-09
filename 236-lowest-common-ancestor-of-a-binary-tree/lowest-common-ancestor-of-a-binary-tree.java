/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root== null) return null;

        if(root==p || root==q) return root;//one root then ancestor is root

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left==null){ //left LCA is null then return right LCA
            return right;
        }
        if(right == null){//righ LCA is null then return left LCA
            return left;
        }
        //if both null then return root
        return root;
    }
}