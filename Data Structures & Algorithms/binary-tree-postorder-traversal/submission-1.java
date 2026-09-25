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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();

        if (root != null) {
            recurse(root, answer);
        }
        
        return answer;
    }

    private void recurse(TreeNode node, List<Integer> answer) {
        if (node.left != null) {
            recurse(node.left, answer);
        }

        if (node.right != null) {
            recurse(node.right, answer);
        }

        answer.add(node.val);
    }
}