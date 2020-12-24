package Leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1602_FindNearestRightNodeInBinaryTree {
    class DFS_Preorder_Solution {
        int uDepth;
        TreeNode nextNode, u;
        public void preorder(TreeNode node, int depth) {
            // the depth to look for next node is identified
            if (node == u) {
                uDepth = depth;
                // we're on the level to look for the next node
            } else if (depth == uDepth) {
                // if this next node is not identified yet
                if (nextNode == null)
                    nextNode = node;
            } else {
                // continue to traverse the tree
                if (node.left != null)
                    preorder(node.left, depth + 1);
                if (node.right != null)
                    preorder(node.right, depth + 1);
            }
        }

        public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
            uDepth = - 1;
            nextNode = null;
            this.u = u;
            preorder(root, 0);
            return nextNode;
        }
    }

    class BFS_Solution {
        public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();

                    if (node == u) {
                        if (i == 1) {
                            return null;
                        }
                        return queue.poll();
                    }

                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            return null;
        }
    }
}
