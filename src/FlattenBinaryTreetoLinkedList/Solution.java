package FlattenBinaryTreetoLinkedList;
//�ҵ�����֮��ʵ�����ǽ����������뵽���ڵ���������У�ʹ�õ����ȸ�����
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
