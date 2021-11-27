import edu.princeton.cs.algs4.Queue;
import org.junit.Test;

public class MergeSort {
    /**
     * Removes and returns the smallest item that is in q1 or q2.
     * <p>
     * The method assumes that both q1 and q2 are in sorted order, with the smallest item first. At
     * most one of q1 or q2 can be empty (but both cannot be empty).
     *
     * @param q1 A Queue in sorted order from least to greatest.
     * @param q2 A Queue in sorted order from least to greatest.
     * @return The smallest item that is in q1 or q2.
     */

    @Test
    public void mergesortTest() {
        Queue<Integer> students = new Queue<Integer>();
        students.enqueue(1);
        students.enqueue(4);
        students.enqueue(20);
        students.enqueue(23);
        students.enqueue(12);
        students.enqueue(5);
        System.out.print(students);

        Queue<Queue<Integer>> singleQueue = makeSingleItemQueues(students);
        System.out.print(singleQueue);
        Queue q1 = singleQueue.dequeue();
        System.out.print(q1);

    }

    private static <Item extends Comparable> Item getMin(
            Queue<Item> q1, Queue<Item> q2) {
        if (q1.isEmpty()) {
            return q2.dequeue();
        } else if (q2.isEmpty()) {
            return q1.dequeue();
        } else {
            // Peek at the minimum item in each queue (which will be at the front, since the
            // queues are sorted) to determine which is smaller.
            Comparable q1Min = q1.peek();
            Comparable q2Min = q2.peek();
            if (q1Min.compareTo(q2Min) <= 0) {
                // Make sure to call dequeue, so that the minimum item gets removed.
                return q1.dequeue();
            } else {
                return q2.dequeue();
            }
        }
    }

    @Test
    public void makeSingleItemQueuesTest() {
        Queue<String> m = new Queue<String>();
        m.enqueue("abc");
        m.enqueue("qew");
        m.enqueue("asadf");
        System.out.print(m);
        makeSingleItemQueues(m);
        System.out.print(m);
    }

    /**
     * Returns a queue of queues that each contain one item from items.
     */
    private static <Item extends Comparable> Queue<Queue<Item>>
    makeSingleItemQueues(Queue<Item> items) {
        // Your code here!
        Queue<Queue<Item>> n = new Queue<>();
        for (Item item : items) {
            Queue<Item> q = new Queue<>();
            q.enqueue(item);
            n.enqueue(q);
        }
        return n;
    }

    @Test
    public void mergeSortedQueuesTest() {
        Queue<Integer> q1 = new Queue<>();
        Queue<Integer> q2 = new Queue<>();
        q1.enqueue(1);
        q1.enqueue(3);
        q1.enqueue(5);
        q2.enqueue(2);
        q2.enqueue(4);
        q2.enqueue(6);
        System.out.print(mergeSortedQueues(q1, q2));

    }

    /**
     * Returns a new queue that contains the items in q1 and q2 in sorted order.
     * <p>
     * This method should take time linear in the total number of items in q1 and q2.  After
     * running this method, q1 and q2 will be empty, and all of their items will be in the
     * returned queue.
     *
     * @param q1 A Queue in sorted order from least to greatest.
     * @param q2 A Queue in sorted order from least to greatest.
     * @return A Queue containing all of the q1 and q2 in sorted order, from least to
     * greatest.
     */
    private static <Item extends Comparable> Queue<Item> mergeSortedQueues(
            Queue<Item> q1, Queue<Item> q2) {
        // Your code here!
        Queue<Item> queue = new Queue<>();

        while (!q1.isEmpty() || !q2.isEmpty()) {
            queue.enqueue(getMin(q1, q2));
        }
        return queue;
    }

    /**
     * Returns a Queue that contains the given items sorted from least to greatest.
     */
    public static <Item extends Comparable> Queue<Item> mergeSort(
            Queue<Item> items) {
        // Your code here!
        if (items.size() <= 1) {
            return items;
        }
        Queue<Queue<Item>> queue1 = makeSingleItemQueues(items);
        int mid = items.size() / 2;
        Queue<Item> q1 = new Queue<>();
        Queue<Item> q2 = new Queue<>();
        for (Item item : items) {
            if (mid > 0) {
                q1.enqueue(item);
            } else {
                q2.enqueue(item);
            }
            mid--;
        }
        Queue<Item> p1 = mergeSort(q1);
        Queue<Item> p2 = mergeSort(q2);
        Queue<Item> res = mergeSortedQueues(p1, p2);
        return res;
    }
}
