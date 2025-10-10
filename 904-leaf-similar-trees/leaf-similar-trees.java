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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer>path1 = new ArrayList<>();
        List<Integer>path2 = new ArrayList<>();

        StoreleafValue(root1, path1);
        StoreleafValue(root2, path2);

        return path1.equals(path2);
    }
    private void StoreleafValue(TreeNode root, List<Integer>path){
        if(root==null) return;

        if(root.left==null && root.right == null){
            path.add(root.val);
        }

        StoreleafValue(root.left, path);
        StoreleafValue(root.right, path);
    }
}