import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestArrayDequeGold {
    @Test
    public void test() {
        StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> tea = new ArrayDequeSolution<>();

        String message = new String();
        Integer m;
        Integer n;
        int s = 0;
        while (true) {
            m = StdRandom.uniform(4);
            if (m == 1) {
                n = StdRandom.uniform(100);
                s++;
                stu.addFirst(n);
                tea.addFirst(n);
                message += "addFirst(" + n + ")\n";
                assertEquals(message, tea.get(0), stu.get(0));
            } else if (m == 2) {
                n = StdRandom.uniform(100);
                s++;
                stu.addLast(n);
                tea.addLast(n);
                message += "addLast(" + n + ")\n";
                assertEquals(message, tea.get(s - 1), stu.get(s - 1));
            } else if (m == 3) {
                if (stu.isEmpty()) {
                    message += "isEmpty\n";
                    assertTrue(message, tea.isEmpty());
                    continue;
                }
                n = StdRandom.uniform(100);
                s--;
                Integer x = stu.removeFirst();
                Integer y = tea.removeFirst();
                message += "removeFirst()\n";
                assertEquals(message, x, y);
            } else {
                if (stu.isEmpty()) {
                    message += "isEmpty\n";
                    assertTrue(message, tea.isEmpty());
                    continue;
                }
                n = StdRandom.uniform(100);
                s--;
                Integer x = stu.removeLast();
                Integer y = tea.removeLast();
                message += "removeLast()\n";
                assertEquals(message, x, y);
            }

        }

    }
}
