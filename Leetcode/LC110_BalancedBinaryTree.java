package Leetcode;
import Leetcode.TreeNode;

public class LC110_BalancedBinaryTree {
    class Solution {
        // since the height of a tree is always greater than or equal to 0
        // we use -1 as a flag to indicate if the subtree is not balanced
        public boolean isBalanced(TreeNode root) {
            return getHeight(root) != -1;
        }

        private int getHeight(TreeNode node) {
            if (node == null) return 0;

            int left = getHeight(node.left);
            int right = getHeight(node.right);

            // left, right subtree is unbalanced or cur tree is unbalanced
            if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;

            return Math.max(left, right) + 1;
        }
    }
}
