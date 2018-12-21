public class Solution_for_add_one_row {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        add(root, v, d, 1);
        return root;
    }

    private void add(TreeNode node, int v, int d, int currentDepth) {
        if (node == null) {
            return;
        }

        if (currentDepth == d - 1) {
            TreeNode temp = node.left;
            node.left = new TreeNode(v);
            node.left.left = temp;

            temp = node.right;
            node.right = new TreeNode(v);
            node.right.right = temp;
            return;
        }

        add(node.left, v, d, currentDepth + 1);
        add(node.right, v, d, currentDepth + 1);
    }
}
