package Leetcode.Tree;

public class LC129_SumRootToLeafNumbers {
    class Solution {
        int ans = 0;
        public int sumNumbers(TreeNode root) {
            if(root==null)  return 0;
            preorder(root, 0);
            return ans;
        }

        private void preorder(TreeNode node, int current){
            if(node!=null){
                current = current*10 + node.val;

                if(node.left==null && node.right==null){
                    ans+=current;
                }
                preorder(node.left, current);
                preorder(node.right, current);
            }
        }
    }
}
