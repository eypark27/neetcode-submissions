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
    public List<Integer> preorderTraversal(TreeNode root) {
        Queue<Integer> queue = new LinkedList<>();
        traverse(root, queue);
        List<Integer> answer = queue.stream().collect(Collectors.toList());

        return answer;
    }

    private void traverse(TreeNode root, Queue queue) {
        if (root == null) {
            return;
        }

        queue.add(root.val);
        traverse(root.left, queue);
        traverse(root.right, queue);
    }
}