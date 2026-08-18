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
    int maxi=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        recurse(root);
        return maxi;
    }
    public int recurse(TreeNode root){
        if(root==null) return 0;
        int left = Math.max(0, recurse(root.left));
        int right = Math.max(0, recurse(root.right));
        maxi=Math.max(maxi,right+left+root.val);
        return root.val+Math.max(left,right);
    }
}
