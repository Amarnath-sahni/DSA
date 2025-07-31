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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        if(root==null) return ans;

        q.add(root);
        while(!q.isEmpty()){
            int last = q.size();
            TreeNode rightView = null;

            for(int i=0; i<last; i++){
             TreeNode curr = q.poll();

             if(curr!=null){
                 rightView = curr; //overRide the value until they come last val 

             if(curr.left!=null) q.add(curr.left); //I'm maked mistake here adding root that inifinitily adding children
             if(curr.right!=null) q.add(curr.right);
            }
             }
            
            //if rightmostview have val then add the ans
            if(rightView!=null){
                ans.add(rightView.val);
            }
        }
        return ans;
    }
}