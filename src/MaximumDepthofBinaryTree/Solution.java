package MaximumDepthofBinaryTree;

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
	//recursive way
    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return 0;
        int LeftDepth =maxDepth(root.left);
        int RightDepth =maxDepth(root.right);
        
        return 1+(LeftDepth>RightDepth?LeftDepth:RightDepth);
    }
}

//最小深度， 上面的方法也可以
 class Solution2 {
	//recursive way
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return 0;
        if(root.left==null&& root.right==null){
        	return 1;
        }
        int leftDepth =minDepth(root.left);
        int rightDepth =minDepth(root.right);
        
        if(leftDepth==0)
        	return rightDepth+1;
        else if(rightDepth==0)
        	return leftDepth +1;
        else
        	return Math.min(leftDepth, rightDepth)+1;
        	
        
    }
    //非递归
    /*
 

 
class Solution {
public:
    int maxDepth(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
       
       myTreeNode myroot( root->val , 0);
       stack< myTreeNode * > mystack;
          
       int max = 0; 
       myTreeNode * node = &myroot;
          
       while( (!mystack.empty()) || node!=NULL ){
        
        if( node != NULL) {
            mystack.push( node);
            node = node->left;
            node->level++;
        } else {
            node = mystack.top();
            mystack.pop();
            node = node->right;
            node->level++;
        }
        
        max = (node->level > max) ? node->level : max; 
        return max;
       }   
    }
};



     * */
    
}
