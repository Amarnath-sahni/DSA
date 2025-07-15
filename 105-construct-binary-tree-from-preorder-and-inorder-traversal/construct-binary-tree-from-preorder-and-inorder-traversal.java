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
    private int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildBtree(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildBtree(int[] preorder,int[] inorder, int left, int right){
        if(left > right) return null; //base case

        TreeNode root = new TreeNode(preorder[preIdx]); //create root node
        preIdx++;

        int inIdx = inoderIdx(inorder, left, right, root.val);//root node pointing idx in Inorder 

        //call recurssiverly for left sub tree and right sub tree;
        root.left = buildBtree(preorder, inorder, left, inIdx-1);
        root.right = buildBtree(preorder, inorder, inIdx+1, right);

        return root;
    }

    private int inoderIdx(int[] inorder, int left, int right, int val){
        for(int i=left; i<=right; i++){
            if(inorder[i]==val){
                return i;
            }
        }
        return -1;
    }
}