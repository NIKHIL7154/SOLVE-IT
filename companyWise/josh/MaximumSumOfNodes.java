import java.util.HashMap;

public class MaximumSumOfNodes {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }

    public static TreeNode createTree() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        return root;
    }

    public static int maxSumUtil(TreeNode node, HashMap<TreeNode, Integer> dp) {
        if (node == null) {
            return 0;
        }
        if (dp.containsKey(node)) {
            return dp.get(node);
        }

        int incl = node.val;
        if (node.left != null) {
            incl += maxSumUtil(node.left.left, dp);
            incl += maxSumUtil(node.left.right, dp);
        }
        if (node.right != null) {
            incl += maxSumUtil(node.right.left, dp);
            incl += maxSumUtil(node.right.right, dp);
        }

        int excl = 0;
        if (node.left != null) {
            excl += maxSumUtil(node.left, dp);
        }
        if (node.right != null) {

            excl += maxSumUtil(node.right, dp);
        }
        int result = Math.max(incl, excl);
        dp.put(node, result);

        return result;
    }

    public static int maxSum(TreeNode root) {
        HashMap<TreeNode, Integer> dp = new HashMap<>();

        if (root == null) {
            return 0;
        }

        return maxSumUtil(root, dp);
    }

    public static void main(String[] args) {
        TreeNode root = createTree();
        System.out.println(maxSum(root));
        // o(n) time and o(n) sapce using top down dp where the result of each node is
        // stored so that whenever it is used again we can fetch the result from the map
    }

}