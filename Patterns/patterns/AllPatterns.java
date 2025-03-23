
public class AllPatterns {
    public void square(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1 || i == n || j == n) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");

                }
            }
            System.out.println();
        }
    }

    public void upAndDownPattern(int n) {
        /*
         * n=6
         * 1
         * 7 2
         * 12 8 3
         * 16 13 9 4
         * 19 17 14 10 5
         * 21 20 18 15 11 6
         */

        int row = 1;
        int rowdelim = n;
        int k = 1;
        int coldelim = n - 1;

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int temp = row;
            for (int j = 1; j <= k; j++) {
                if (j == 1) {
                    System.out.print(temp + "  ");
                } else {
                    temp -= coldelim;
                    System.out.print(temp + "  ");
                    coldelim++;
                }
            }
            k++;
            coldelim = n - i;
            row = row + rowdelim;
            rowdelim--;

            System.out.println();
        }
    }

    public static void main(String[] args) {
        AllPatterns p = new AllPatterns();
        // p.square(5);
        p.upAndDownPattern(15);
    }
}
