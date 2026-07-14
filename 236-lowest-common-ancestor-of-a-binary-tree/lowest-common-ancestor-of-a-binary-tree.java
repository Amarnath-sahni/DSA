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
         // Base case
        if(root == null) {
            return null;
        }


        // If current node is one of p or q
        if(root == p || root == q) {
            return root;
        }


        // Search left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);


        // Search right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);



        // p and q found in different subtrees
        if(left != null && right != null) {
            return root;
        }


        // Return the side where we found p or q
        return left != null ? left : right;
    }
}