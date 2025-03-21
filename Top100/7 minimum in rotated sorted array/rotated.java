
public class rotated {

    public static void main(String[] args) {
        //using binary search for better time complexity
        //this one works in o(log n)

        int[] arr = {3, 4, 5, 1, 2};
        int low = 0, high = arr.length - 1;
        if (arr[low] < arr[high]) {
            System.out.println(arr[low]);
            return;
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }

        }
        System.out.println(arr[low]);

    }

    static void myapproach() {
        //this approach is built by me only
        int[] arr = {3, 4, 5, 1, 2};
        // given rotated and sorted array find the minimum value in this array
        if (arr[0] < arr[arr.length - 1]) {
            System.out.println(arr[0]);
            return;
        }
        int low = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > low) {
                break;
            }
            low = arr[i];

        }
        System.out.println(low);
    }
}
