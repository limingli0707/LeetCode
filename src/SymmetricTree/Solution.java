package SymmetricTree;

/**
 * Definition for binary tree*/
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        return isMiror(root.left, root.right);
        
    }
    
    public boolean isMiror(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null && n2 != null) return false;
        if (n1 != null && n2 == null) return false;
        if (n1.val != n2.val) return false;
        return isMiror(n1.left, n2.right) && isMiror(n1.right, n2.left);
    }
}