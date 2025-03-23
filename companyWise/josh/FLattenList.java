
class FLattenList {
    static class Node {
        int data;
        Node next, down;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.down = null;
        }
    }

    /*
     * 5 -> 10 -> 19 -> 28
     * | | | |
     * 7 20 22 35
     * | | |
     * 8 50 40
     * | |
     * 30 45
     */

    public static Node flatten(Node root) {
        if (root == null || root.next == null) {
            return root;
        }

        // Merge the current list with the next list
        root.next = flatten(root.next);

        // Merge current node and its down list
        root = merge(root, root.next);

        return root;
    }

    private static Node merge(Node a, Node b) {
        if (a == null)
            return b;
        if (b == null)
            return a;

        Node result;

        if (a.data < b.data) {
            result = a;
            result.down = merge(a.down, b);
        } else {
            result = b;
            result.down = merge(a, b.down);
        }

        return result;
    }

    public static void printList(Node root) {
        while (root != null) {
            System.out.print(root.data + " -> ");
            root = root.down;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.down = new Node(7);
        head.down.down = new Node(8);
        head.down.down.down = new Node(30);

        head.next = new Node(10);
        head.next.down = new Node(20);

        head.next.next = new Node(19);
        head.next.next.down = new Node(22);
        head.next.next.down.down = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.down = new Node(35);
        head.next.next.next.down.down = new Node(40);
        head.next.next.next.down.down.down = new Node(45);

        head = flatten(head);
        printList(head);
    }
}
