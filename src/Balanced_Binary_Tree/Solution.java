package Balanced_Binary_Tree;


// Definition for binary tree*/
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  
 
public class Solution {
	private int height(TreeNode root){
		if(root==null) return 0;
		
		return 1+Math.max(height(root.left),height(root.right));
	}
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(root==null) return true;
    	
    	if(isBalanced(root.left)&&isBalanced(root.right)&Math.abs(height(root.left)-height(root.right))<2){
    		return true;
    	}
    	else return false;
        
    }
}