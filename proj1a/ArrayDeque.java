public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int R;
    private int factor = 2;
    private int capacity = 8;

    public ArrayDeque() {
        items = (T[]) new Object[capacity];
        size = 0;
        nextFirst = capacity - 1;
        nextLast = 0;
    }

    public boolean isEmpty() {
        if (nextFirst == capacity - 1 && nextLast == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addFirst(T x) {
        items[nextFirst] = x;
        nextFirst -= 1;
        if (nextFirst == nextLast) {
            resizing(capacity * 2);
        }
        size += 1;
    }

    public void addLast(T x) {
        items[nextLast] = x;
        nextLast += 1;
        if (nextFirst == nextLast) {
            resizing(capacity * 2);
        }
        size += 1;
    }

    private T[] a;

    public void resizing(int x) {
        a = (T[]) new Object[x];
        nextFirst = x - (capacity - nextFirst);
        capacity = x;
        items = a;
    }

    public int size() {
        return size;
    }

    private T x;

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            if (nextFirst == capacity - 1) {
                x = items[0];
                items[0] = null;
                nextFirst = 0;
            } else {
                x = items[nextFirst + 1];
                items[nextFirst + 1] = null;
                nextFirst = nextFirst + 1;
            }
            return x;
        }
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            x = items[nextLast - 1];
            items[nextLast - 1] = null;
            nextLast = nextLast - 1;
            return x;
        }
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        } else {
            return items[index];
        }
    }

    private int m;
    private int n = 0;

    public void printDeque() {
        if (nextFirst == capacity - 1) {
            if (nextLast == 0) {
            } else {
                while (n != nextLast) {
                    System.out.println(items[n] + " ");
                    n++;
                }
                System.out.println();
            }
        } else {
            n = nextFirst + 1;
            while (n != capacity) {
                System.out.println(items[n] + " ");
                n++;
            }
            n = 0;
            while (n != nextLast) {
                System.out.println(items[n] + " ");
                n++;
            }
            System.out.println();
        }

    }
}
