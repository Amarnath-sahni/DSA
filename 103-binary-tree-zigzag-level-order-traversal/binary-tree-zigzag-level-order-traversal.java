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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       List<List<Integer>> ZigZaglevel = new ArrayList<>();
       Queue<TreeNode> q = new LinkedList<>();
       if(root == null) return ZigZaglevel;

       q.add(root);
       boolean leftToRight = true;

       while(!q.isEmpty()){
        int levelSize = q.size();
        List<Integer>level = new ArrayList<>();

        for(int i=0; i<levelSize; i++){
            TreeNode curr = q.poll();
            if(curr!=null) level.add(curr.val);

            if(curr!=null){
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }   
        }

        if(!leftToRight){
            Collections.reverse(level);
        }
        ZigZaglevel.add(level);
        leftToRight = !leftToRight;
       } 

       return ZigZaglevel;
    }
}