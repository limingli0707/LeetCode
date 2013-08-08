package FlattenBinaryTreetoLinkedList;
//找到规律之后，实际上是将左子树插入到根节点和右子树中，使用的是先根遍历
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
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode lastNode = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (lastNode != null) {
                lastNode.left = null;
                lastNode.right = node;
            }
            lastNode = node;
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
        }
    }
}
