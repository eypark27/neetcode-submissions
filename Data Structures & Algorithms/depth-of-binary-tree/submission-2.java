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
    public int maxDepth(TreeNode root) {
        return maxDepthTraverse(root, 0);
    }

    private int maxDepthTraverse(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        int newDepth = depth + 1;
        if (node.left == null && node.right == null) {
            return newDepth;
        }

        return Math.max(maxDepthTraverse(node.left, newDepth), maxDepthTraverse(node.right, newDepth));
    }
}
