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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        //step1 
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        //step2
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
            //voila case
            //case 1 --> leaf node
            if(root.left==null && root.right == null){
                return null;
            }
            
            if(root.left==null){ //case 2 single child
                return deleteNode(root.right, key);
            }else if(root.right == null){
                return deleteNode(root.left, key);
            }
            //case 3 two chiid

            TreeNode IS = minFind(root.right);
            root.val = IS.val;
            root.right = deleteNode(root.right, IS.val);

        }
         return root;

    }

    public static TreeNode minFind(TreeNode root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    } 
}