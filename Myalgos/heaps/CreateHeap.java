
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class CreateHeap {

    public static void main(String[] args) {
        // min heap
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((x, y) -> y - x);
        minheap.add(5);
        minheap.add(8);
        minheap.add(1);
        minheap.add(6);

        maxheap.add(5);
        maxheap.add(8);
        maxheap.add(1);
        maxheap.add(6);
        System.out.println(minheap.peek() + " ---- " + maxheap.peek());

    }
}
