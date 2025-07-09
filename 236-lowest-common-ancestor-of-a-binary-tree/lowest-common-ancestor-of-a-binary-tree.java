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
      ArrayList<TreeNode> path1 = new ArrayList<>();
      ArrayList<TreeNode> path2 = new ArrayList<>();

      //call for root to n1 distnce and root to n2 distance
      if(!findPath(root, p, path1) || !findPath(root, q, path2)){
        return null;
      }

      //compare not equal to
      int i =0;
      for(; i<path1.size() && i<path2.size(); i++){
        if(path1.get(i)!=path2.get(i)){
            break;
        }
      }
      return path1.get(i-1);
    }
    private static boolean findPath(TreeNode root, TreeNode n, ArrayList<TreeNode> path){
        if(root==null) return false;

        path.add(root);

        //chack root node is child node
        if(root==n) return true;

        //left and right both return true
        if(findPath(root.left, n , path) || findPath(root.right, n, path)){
            return true;
        }
        //if left right not return true then return false
        path.remove(path.size()-1);
        return false;
    }
}