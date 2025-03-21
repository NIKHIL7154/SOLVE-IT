
public class maxproduct {

    static void bruteforce() {
        int[] arr = {-2, 2, 0, 7, -10, -1};
        int prod = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int cur = 1;

            for (int j = i; j < arr.length; j++) {
                cur *= arr[j];
                prod = Math.max(prod, cur);

            }

        }
        System.out.println(prod);
        // time= o(n^2) space o(1)
    }

    public static void main(String[] args) {
        int[] arr = {-2, 2, 0, 7, -10, -1};
        int n = arr.length;
        int left = 1;
        int right = 1;
        int prod = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (left == 0) {
                left = 1;
            }
            if (right == 0) {
                right = 1;
            }

            left *= arr[i];
            right *= arr[n - 1 - i];
            prod = Math.max(left, Math.max(prod, right));
        }
        System.out.println(prod);
        //this approach is very effective as time =o(n) and space o(1)

    }
}
