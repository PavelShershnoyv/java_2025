package Laba3.Homework8;

public class LinkedList {
    private Node node;

    public void createHead(int value) {
        node = new Node(value);
    }

    public void createTail(int value) {
        Node newNode = new Node(value);
        Node ref = node;

        while (ref.next != null) {
            ref = ref.next;
        }

        ref.next = newNode;
    }

    public String toString() {
        Node ref = node;
        StringBuilder sb = new StringBuilder();
        if (ref.next == null) {
            sb.append(ref.value);
            return sb.toString();
        }
        while (ref.next != null) {
            sb.append(ref.value).append(" ");
            ref = ref.next;
        }
        sb.append(ref.value);

        return sb.toString();
    }

    public void AddFirst(Node newNode) {
        newNode.next = node;
        node = newNode;
    }

    public void AddLast(Node newNode) {
        Node ref = node;

        while (ref.next != null) {
            ref = ref.next;
        }

        ref.next = newNode;
    }

    public void Insert(int position, Node newNode) {
        if (position == 0) {
            AddFirst(newNode);
            return;
        }

        Node ref = node;
        int k = 1;

        while (ref.next != null && k < position) {
            ref = ref.next;
            k++;
        }

        newNode.next = ref.next;
        ref.next = newNode;
    }

    public void RemoveFirst() {
        node = node.next;
    }

    public void RemoveLast() {
        Node ref = node;

        while (ref.next.next != null) {
            ref = ref.next;
        }

        ref.next = null;
    }

    public void Remove(int position) {
        if (position == 0) {
            RemoveFirst();
            return;
        }

        Node ref = node;
        int k = 1;

        while (ref.next != null && k < position) {
            ref = ref.next;
            k++;
        }

        ref.next = ref.next.next;
    }

    // Рекурсия

    public void createHeadRec(int value) {
        node = new Node(value);
    }

    public void createTailRec(int value) {
        Node newNode = new Node(value);

        createTailRecDop(node, newNode);
    }

    private void createTailRecDop(Node node, Node newNode) {
        if (node.next == null) {
            node.next = newNode;
            return;
        }

        createTailRecDop(node.next, newNode);
    }

    public String toStringRec() {
        return toStringRecDop(node);
    }

    private String toStringRecDop(Node node) {
        if (node.next == null) {
            return Integer.toString(node.value);
        }

        return node.value + " " + toStringRecDop(node.next);
    }
}
