package leetcode.Tree;

public class LC1379_FindACorrespondingNodeInClone {
    class Solution {
        TreeNode ans, target;

        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            this.target = target;
            preorder(original, cloned);
            return ans;
        }

        public void preorder(TreeNode original, TreeNode cloned) {
            if (original != null) {
                if (original == target) {
                    ans = cloned;
                }
                preorder(original.left, cloned.left);
                preorder(original.right, cloned.right);
            }
        }
    }
}
