import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class GoodNodes {
    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null)
            return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();

            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public void recurse(TreeNode node, int prev, ArrayList<Integer> arr) {
        if (node == null) {
            return;
        }
        int next = prev;
        if (node.val >= prev) {
            arr.add(node.val);
            next = node.val;
        }

        recurse(node.left, next, arr);
        recurse(node.right, next, arr);
    }

    public int goodNodes(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        recurse(root, Integer.MIN_VALUE, arr);
        System.out.println(arr);
        return 0;
    }

    public static void main(String[] args) {
        Integer[] arr = { -1, 5, -2, 4, 4, 2, -2, null, null, -4, null, -2, 3, null, -2, 0, null, -1, null, -3, null,
                -4, -3, 3, null, null, null, null, null, null, null, 3, -3 };
        TreeNode root = buildTree(arr);
        GoodNodes gn = new GoodNodes();
        System.out.println(gn.goodNodes(root));
    }
}
