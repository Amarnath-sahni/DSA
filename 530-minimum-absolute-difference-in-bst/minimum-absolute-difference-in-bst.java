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
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer>InorderStore = new ArrayList<>();
        inorder(root, InorderStore);
        int min = Integer.MAX_VALUE;
        
        for(int i = 1; i<InorderStore.size(); i++){
            min = Math.min(Math.abs(InorderStore.get(i) - InorderStore.get(i-1)), min);
        }
        return min;
    }

    private void inorder(TreeNode root, ArrayList<Integer>in){
        if(root == null) return;
        inorder(root.left, in);
        in.add(root.val);
        inorder(root.right, in);
    }
}