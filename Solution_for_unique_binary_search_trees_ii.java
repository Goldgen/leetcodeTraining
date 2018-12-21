import java.util.ArrayList;
import java.util.List;

public class Solution_for_unique_binary_search_trees_ii {

    class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public List<TreeNode> generateTrees(int n) {
        if(n < 1)
            return new ArrayList<TreeNode>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> tree = new ArrayList<TreeNode>();
        if(start > end){
            tree.add(null);
            return tree;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> leftChild = helper(start, i - 1);
            List<TreeNode> rightChild = helper(i + 1, end);
            for(TreeNode left : leftChild) {
                for(TreeNode right : rightChild) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    tree.add(root);
                }
            }
        }
        return tree;
    }
}
