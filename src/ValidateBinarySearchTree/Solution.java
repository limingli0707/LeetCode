package ValidateBinarySearchTree;
//��һ�ַ��� BruteForce
/*
 * bool isSubTreeLessThan(BinaryTree *p, int val) {
    if (!p) return true;
    return (p->data < val &&
            isSubTreeLessThan(p->left, val) &&
            isSubTreeLessThan(p->right, val));
}

bool isSubTreeGreaterThan(BinaryTree *p, int val) {
    if (!p) return true;
    return (p->data > val &&
            isSubTreeGreaterThan(p->left, val) &&
            isSubTreeGreaterThan(p->right, val));
}

bool isBSTBruteForce(BinaryTree *p) {
    if (!p) return true;
    return isSubTreeLessThan(p->left, p->data) &&
    isSubTreeGreaterThan(p->right, p->data) &&
    isBSTBruteForce(p->left) &&
    isBSTBruteForce(p->right);
}
 */
//�ڶ��ַ��� in-order BST��inoderһ���ϸ�increased
/*
 * bool isBSTInOrderHelper(BinaryTree *p, int& prev) {
    if (!p) return true;
    if (isBSTInOrderHelper(p->left, prev)) {
        if (p->data > prev) {
            prev = p->data;
            return isBSTInOrderHelper(p->right, prev);
        } else {
            return false;
        }
    }
    else {
        return false;
    }
}
bool isBSTInOrder(BinaryTree *root) {
    int prev = INT_MIN;
    return isBSTInOrderHelper(root, prev);
}
 */
//������ ���ò�����Ϊ��ķ���
/*
 * bool isBSTHelper(BinaryTree *p, int low, int high) {
    if (!p) return true;
    if (low < p->data && p->data < high)
        return isBSTHelper(p->left, low, p->data) &&
    isBSTHelper(p->right, p->data, high);
    else
        return false;
}

bool isBST(BinaryTree *root) {
    // INT_MIN and INT_MAX are defined in C++'s <climits> library
    return isBSTHelper(root, INT_MIN, INT_MAX);
}
 */
public class Solution {

}
