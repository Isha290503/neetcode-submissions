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
    int ind=0;
    HashMap<Integer,Integer> mpp=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            mpp.put(inorder[i],i);
        }
        return recurse(preorder,0,inorder.length-1);
    }
    public TreeNode recurse(int[] pre,int l,int r){
        if(l>r) return null;
        int val=pre[ind++];
        TreeNode root=new TreeNode(val);
        int mid=mpp.get(val);
        root.left=recurse(pre,l,mid-1);
        root.right=recurse(pre,mid+1,r);
        return root;
    }
}
