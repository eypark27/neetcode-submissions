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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // return early for null trees
        if (root == null && subRoot == null) {
            return true;
        }

        // both trees must have null parity
        if (root == null ^ subRoot == null) {
            return false;
        }

        if (root.val == subRoot.val && treeIsEqual(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean treeIsEqual(TreeNode root1, TreeNode root2) {
        // return early for null trees
        if (root1 == null && root2 == null) {
            return true;
        }

        // both trees must have parity for nulity
        if (root1 == null ^ root2 == null) {
            return false;
        }

        // both trees must hold the same value
        if (root1.val != root2.val) {
            return false;
        }

        // left subtree must be equivalent
        if (!treeIsEqual(root1.left, root2.left)) {
            return false;
        }

        // right subtree must be equivalent
        if (!treeIsEqual(root1.right, root2.right)) {
            return false;
        }

        return true;
    }
}
