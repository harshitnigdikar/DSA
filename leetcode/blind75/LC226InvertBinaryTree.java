package dsa.leetcode.blind75;

  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class LC226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        solve(root);
        return root;
    }

    private void solve(TreeNode root){
        if(root == null){
            return;
        }

        solve(root.left);
        solve(root.right);

        TreeNode helper = root.left;
        root.left = root.right;
        root.right = helper;
    }
}
