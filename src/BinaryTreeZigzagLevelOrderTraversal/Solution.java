package BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> currentLevel = new LinkedList<TreeNode>();
        int level = 0;
        if(root != null) 
            currentLevel.add(root);
        while(!currentLevel.isEmpty()){
            LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(TreeNode node : currentLevel){
                list.add(node.val);
                if(node.left != null)
                    nextLevel.add(node.left);
                if(node.right != null)
                    nextLevel.add(node.right);
            }
            if(level%2 == 1)
                Collections.reverse(list);
            ans.add(list);
            currentLevel = nextLevel;
            level++;
        }
        return ans;
    }
}