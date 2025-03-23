import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class LinkyList {
    public Node head;
    public Node tail;

    class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public LinkyList() {
        head = null;
    }

    public void add(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
            return;
        }

        tail.next = new Node(val);
        tail = tail.next;
    }

    public Node getHead() {
        return head;
    }

    public int size() {
        int count = 0;
        Node cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void reverseTheList() {
        Node prev = null;
        Node cur = head;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        head = prev;
    }

    public void reversePrint() {
        Node cur = head;
        Stack<Integer> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
            if (!stack.isEmpty()) {
                System.out.print(" -> ");
            }
        }
        System.out.println();

    }

    public void reverseAtoB(int a, int b) {
        int n = size();
        if (a < 1 || b < 1 || a > n || b > n || a > b) {
            System.out.println("Not valid range to reverse");
            return;
        }

        Node start = head;
        Node end = head;
        Node prev = null;
        int x = 1;

        while (x < b) {
            if (x < a) {
                prev = start;
                start = start.next;
            }
            end = end.next;
            x++;
        }
        Node nextNode = end.next;
        end.next = null;
        reverseList(start);
        start.next = nextNode;
        if (a == 1) {
            head = end;
        } else {
            prev.next = end;
        }

    }

    public Node getKthNode(Node node, int k) {
        Node kth = node;
        k--;
        while (k > 0) {
            kth = kth.next;
            if (kth == null) {
                return null;
            }
            k--;
        }
        return kth;
    }

    public void reverseKgroup(int k) {
        if (head == null) {
            System.out.println("No nodes");
            return;
        }
        Node temp = head;
        Node prevLast = null;

        while (temp != null) {
            Node kthNode = getKthNode(temp, k);
            if (kthNode == null) {
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }
            Node nextNode = kthNode.next;
            kthNode.next = null;
            reverseList(temp);
            if (temp == head) {
                head = kthNode;
            } else {
                prevLast.next = kthNode;
            }
            prevLast = temp;
            temp = nextNode;
        }

    }

    public void reverseOddNodes() {
        Node temp = head;
        int k = 1;
        Node prevLast = null;

        while (temp != null) {
            Node kthNode = getKthNode(temp, k);
            if (kthNode == null) {
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }
            if (k % 2 != 0) {
                Node nextNode = kthNode.next;
                kthNode.next = null;
                reverseList(temp);
                if (prevLast != null) {
                    prevLast.next = kthNode;
                }
                prevLast = temp;
                temp = nextNode;

            } else {
                prevLast.next = temp;
                prevLast = kthNode;
                temp = kthNode.next;
            }
            k++;
        }
    }

    public void reverseEvenNodes() {
        Node temp = head;
        int k = 1;
        Node prevLast = null;
        while (temp != null) {
            Node kthNode = getKthNode(temp, k);
            if (kthNode == null) {
                if (prevLast != null) {
                    prevLast.next = temp;

                }
                break;
            }
            if (k % 2 == 0) {
                Node nextNode = kthNode.next;
                kthNode.next = null;
                reverseList(temp);
                prevLast.next = kthNode;
                prevLast = temp;
                temp = nextNode;

            } else {
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                prevLast = kthNode;
                temp = kthNode.next;
            }
            k++;
        }
    }

    public Node reverseList(Node root) {
        Node prev = null;
        Node cur = root;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public void print() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
            if (cur != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public boolean detectCycle() {
        Node a = head;
        Node b = head;
        while (a != null && b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
            if (a == b) {
                return true;
            }
        }
        return false;
    }

    public void makeCycle() {
        tail.next = head;
    }

    public Node removeCycle() {
        HashSet<Node> visited = new HashSet<>();
        Node start = head;
        Node startOfCycle = null;
        ;

        while (start != null) {
            if (visited.contains(start.next)) {
                startOfCycle = start.next;
                start.next = null;
                break;
            }
            visited.add(start);
            start = start.next;
        }
        return startOfCycle;
    }

    public Node findMiddle() {
        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] a) {
        LinkyList l = new LinkyList();
        l.add(0);
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        l.add(10);
        l.add(11);
        l.add(12);
        l.add(13);
        l.add(14);
        l.add(15);

        l.print();
        System.out.println(l.detectCycle());
        l.makeCycle();
        System.out.println(l.detectCycle());
        System.out.println(l.removeCycle().val);
        System.out.println(l.detectCycle());
        System.out.println(l.findMiddle().val);
    }

}
