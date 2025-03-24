import java.util.Arrays;
import java.util.PriorityQueue;

public class AllSorting {
    // Quick sort implementation
    public int getPivIndex(int[] arr, int l, int r) {
        int piv = arr[r];
        int i = l - 1;
        for (int j = l; j <= r; j++) {
            if (arr[j] < piv) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
        return i;
    }

    public void quickUtil(int[] arr, int l, int r) {
        if (l > r) {
            return;
        }
        int piv = getPivIndex(arr, l, r);

        quickUtil(arr, l, piv - 1);
        quickUtil(arr, piv + 1, r);

    }

    public void quickSort(int[] arr) {
        quickUtil(arr, 0, arr.length - 1);
        System.out.println("Quick Sort : " + Arrays.toString(arr));
    }
    // Quick sort ends

    // Merge sort starts

    public void mergeParts(int[] arr, int l, int mid, int r) {

        int[] res = new int[r - l + 1];
        int a = l;
        int b = mid + 1;
        int i = 0;

        while (a <= mid && b <= r) {
            if (arr[a] < arr[b]) {
                res[i++] = arr[a++];
            } else {
                res[i++] = arr[b++];
            }
        }
        while (a <= mid) {
            res[i++] = arr[a++];
        }
        while (b <= r) {
            res[i++] = arr[b++];
        }

        i = 0;
        for (int z = l; z <= r; z++) {
            arr[z] = res[i++];
        }
    }

    public void mergeUtil(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeUtil(arr, l, mid);
        mergeUtil(arr, mid + 1, r);
        mergeParts(arr, l, mid, r);
    }

    public void mergeSort(int[] arr) {
        mergeUtil(arr, 0, arr.length - 1);
        System.out.println("Merge Sort : " + Arrays.toString(arr));

    }

    public String StringSort(String a) {
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for (char x : a.toCharArray()) {
            if (x > 64 && x < 91) {
                pq.add(x);
            }
        }
        System.out.println(pq);

        char[] arr = a.toLowerCase().toCharArray();

        mergeUtilForString(arr, 0, arr.length - 1);
        StringBuilder sb = new StringBuilder();

        for (char c : arr) {
            if (pq.peek() + 32 == c) {

                sb.append(pq.poll());

            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public void mergeUtilForString(char[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeUtilForString(arr, l, mid);
        mergeUtilForString(arr, mid + 1, r);
        mergeStringParts(arr, l, mid, r);
    }

    public void mergeStringParts(char[] arr, int l, int mid, int r) {

        char[] res = new char[r - l + 1];
        int a = l;
        int b = mid + 1;
        int i = 0;

        while (a <= mid && b <= r) {
            if (arr[a] < arr[b]) {
                res[i++] = arr[a++];
            } else {
                res[i++] = arr[b++];
            }
        }
        while (a <= mid) {
            res[i++] = arr[a++];
        }
        while (b <= r) {
            res[i++] = arr[b++];
        }

        i = 0;
        for (int z = l; z <= r; z++) {
            arr[z] = res[i++];
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 8, 2, 5, 4, 6, 55, 5, 5, 5, 0, 0, 0 };
        AllSorting a = new AllSorting();
        a.quickSort(arr);
        a.mergeSort(arr);
        System.out.println(a.StringSort("bvdfagAAXX"));
    }
}
