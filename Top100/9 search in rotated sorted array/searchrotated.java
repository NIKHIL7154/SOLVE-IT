
public class searchrotated {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int tar = 4;

        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == tar || arr[low] == tar || arr[high] == tar) {
                System.out.println(low + mid + " Found");

                return;
            }
            if (arr[low] <= arr[mid]) {
                // Left half is sorted
                if (tar >= arr[low] && tar < arr[mid]) {
                    high = mid - 1; // Target is in the left half
                } else {
                    low = mid + 1; // Target is in the right half
                }
            } else {
                // Right half is sorted
                if (tar > arr[mid] && tar <= arr[high]) {
                    low = mid + 1; // Target is in the right half
                } else {
                    high = mid - 1; // Target is in the left half
                }
            }

        }

        System.out.println("Not found");

    }
}
