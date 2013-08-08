package ValidateBinarySearchTree;
//第一种方法 BruteForce
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
//第二种方法 in-order BST的inoder一定严格increased
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
//第三种 是用参数作为界的方法
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
