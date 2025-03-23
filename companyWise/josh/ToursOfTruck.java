import java.util.*;
import java.io.*;

public class ToursOfTruck {
    public static boolean completeJourney(int[] petrol, int[] distance, int n, int visited, int cur, int petLeft) {

        if (visited >= n) {
            return true;
        }
        if (cur >= n) {
            cur = 0;
        }

        if (petLeft + petrol[cur] >= distance[cur]) {
            return completeJourney(petrol, distance, n, visited + 1, cur + 1, petLeft + petrol[cur] - distance[cur]);
        }
        return false;

    }

    public static int firstCircularTour(int[] petrol, int[] distance, int n) {

        for (int i = 0; i < n; i++) {
            if (petrol[i] >= distance[i] && completeJourney(petrol, distance, n, 0, i, 0)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
