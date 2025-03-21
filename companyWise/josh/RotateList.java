import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }

}

public class RotateList {
    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }

    public void reverseArray(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    public void rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverseArray(arr, 0, n - 1);
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, n - 1);
    }

    public ListNode rotateList(ListNode head, int a, int b, int k) {
        int[] arr = new int[b - a + 1];
        int s = 1;
        ListNode start = head;
        while (s < a) {
            start = start.next;
            s++;
        }
        ListNode temp = start;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp.val;
            temp = temp.next;
        }
        rotateArray(arr, k);
        for (int i : arr) {
            start.val = i;
            start = start.next;
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        RotateList rl = new RotateList();
        ListNode n = new ListNode(6);
        n.next = new ListNode(6);
        int a = 2;
        int b = 4;
        int k = 4;
        ListNode newhead = rl.rotateList(head, a, b, k);
        rl.printList(newhead);
    }
}
