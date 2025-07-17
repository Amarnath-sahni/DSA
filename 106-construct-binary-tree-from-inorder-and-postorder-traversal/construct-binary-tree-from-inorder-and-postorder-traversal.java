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
       private int idx;  // to keep track of postorder index

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length - 1; // Start from last element in postorder
        return Btree(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode Btree(int[] inorder, int[] postorder, int left, int right) {
        if (left > right || idx < 0) {
            return null;
        }

        // Get root value from postorder
        int rootVal = postorder[idx--];
        TreeNode root = new TreeNode(rootVal);

        // Find root position in inorder
        int curr = inOrder(inorder, left, right, rootVal);

        // Build right subtree first (because in postorder, right subtree comes before left)
        root.right = Btree(inorder, postorder, curr + 1, right);
        root.left = Btree(inorder, postorder, left, curr - 1);

        return root;
    }

    private int inOrder(int[] inorder, int left, int right, int val) {
        for (int i = left; i <= right; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}