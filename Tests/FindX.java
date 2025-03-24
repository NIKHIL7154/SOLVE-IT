public class FindX {
    public void findSecondLargest(int[] arr) {
        int a = arr[0];
        int b = arr[0];
        for (int i : arr) {
            if (i > a) {
                b = a;
                a = i;

            }
        }
        System.out.println(b);
    }

    public void Ladder(int[] arr, int sum, int[] res, int i) {
        if (i >= arr.length) {
            if (sum < res[0]) {
                res[0] = sum;
            }
            return;
        }
        if (i != -1) {
            sum += arr[i];
        }
        Ladder(arr, sum, res, i + 1);
        Ladder(arr, sum, res, i + 2);// 2 ki poer n h beeee
    }

    public int iterativeLadder(int[] arr) {
        int cost = 0;
        int i = 0;
        while (i < arr.length - 1) {
            if (arr[i] < arr[i + 1]) {
                cost += arr[i];
                i++;
            } else {
                cost += arr[i + 1];
                i += 2;
            }
        }

        return cost;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 7, 5, 9, 5, 6, 2, 2, 10, 150, 1 };
        FindX a = new FindX();
        a.findSecondLargest(arr);
        int[] res = { Integer.MAX_VALUE };

        a.Ladder(arr, 0, res, -1);
        System.out.println(res[0]);
        System.out.println(a.iterativeLadder(arr));

    }
}
