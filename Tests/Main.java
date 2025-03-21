
class Main {

    class Helper<T> {

        private T[] arr;
        private int ind;

        @SuppressWarnings("unchecked")
        public Helper() {
            arr = (T[]) new Object[10];
            ind = 0;
        }

        @SuppressWarnings("unchecked")
        public void add(T element) {
            if (ind > arr.length - 1) {
                T[] temp = (T[]) new Object[ind * ind];
                System.arraycopy(arr, 0, temp, 0, arr.length);
                arr = temp;

                arr[ind++] = element;
                System.out.println(arr.length);
                return;
            }

            arr[ind++] = element;

        }

        public T get(int i) {
            if (i >= ind) {
                return null;
            }
            return arr[i];
        }

        @Override
        public String toString() {
            StringBuilder r = new StringBuilder("[");
            for (int i = 0; i < ind; i++) {
                r.append(arr[i]);
                if (i != ind - 1) {
                    r.append(", ");
                }

            }
            r.append("]");
            return r.toString();

        }
    }

    class Node {

        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
            next = null;
        }

    }

    public static void main(String[] args) {
        Main m = new Main();
        Node ab = m.new Node(4);
        Helper<Node> abc = m.new Helper<>();
        abc.add(ab);

        System.out.println(abc.get(0).val);
        System.out.println(abc);
        System.out.println("This is Main thread");

    }
}
