public class LinkedListDeque<T> {
    private class Node {
        T item;
        Node next;
        Node prev;

        Node(T i, Node m, Node n) {
            item = i;
            prev = m;
            next = n;
        }
    }

    private Node sentinel;
    public int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public boolean isEmpty() {
        if (sentinel.prev == sentinel && sentinel.next == sentinel && size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void addFirst(T x) {
        sentinel.next = new Node(x, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    public void addLast(T x) {
        sentinel.prev = new Node(x, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            T removed = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.next.prev = sentinel.next;
            size -= 1;
            return removed;
        }
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            T removed = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.prev.next = sentinel.prev;
            size -= 1;
            return removed;
        }
    }

    public T getRecursive(int index) {
        Node copy = sentinel.next;
        if (index >= size) {
            return null;
        } else {
            if (index == 0) {
                return copy.item;
            } else {
                copy = copy.next;
                return getRecursive(index - 1);
            }
        }
    }

    public void printDeque() {
        Node copy = sentinel;
        while (copy.next != sentinel) {
            System.out.print(copy.next.item + " ");
            copy = copy.next;
        }
        System.out.println();
    }

}
